package com.chicken.project.notice.controller;

import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.exception.notice.NoticeDeleteException;
import com.chicken.project.notice.model.dto.NoticeDTO;
import com.chicken.project.notice.model.dto.NoticeFileDTO;
import com.chicken.project.notice.model.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

    private final NoticeService noticeService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public NoticeController(NoticeService noticeService){

        this.noticeService = noticeService;
    }

    /* 관리자 공지사항 조회 */
    @GetMapping("/admin/list")
    public ModelAndView adminNoticeList(ModelAndView mv, HttpServletRequest request){

        /* 현재 페이지 인덱스 가져오기 */
        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        /* 검색 조건 가져오기 */
        String searchCondition = request.getParameter("searchCondition");
        /* 검색 값 가져오기 */
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        /* HaspMap에 검색조건, 검색 값 담아 조회할 때 같이 넘겨주기 */
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        log.info("[NoticeController] searchMap = " + searchMap);

        /* 페이징처리를 위해 전체 개수 조회 */
        int totalCount = noticeService.selectTotalCount(searchMap);

        log.info("[NoticeController] totalCount = " + totalCount);

        /* 한 페이지당 최대 조회 개수 */
        int limit = 6;
        /* 페이지 이동 버튼 최대 개수 */
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        /* 페이지 이동시 인자값 같이 넘기기 */
        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        log.info("[NoticeController] selectCriteria = " + selectCriteria);

        /* 공지사항 리스트 조회하기 */
        List<NoticeDTO> noticeList = noticeService.selectNoticeList(selectCriteria);

        log.info("[NoticeController] noticeList = " + noticeList);

        mv.addObject("noticeList", noticeList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("/notice/admin/adminNoticeList");

        return mv;
    }

    /* 유저 공지사항 조회 */
    @GetMapping("/user/list")
    public ModelAndView userNoticeList(ModelAndView mv, HttpServletRequest request){

        /* 현재 페이지 인덱스 가져오기 */
        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        /* 검색 조건 가져오기 */
        String searchCondition = request.getParameter("searchCondition");
        /* 검색 값 가져오기 */
        String searchValue = request.getParameter("searchValue");

        /* HaspMap에 검색조건, 검색 값 담아 조회할 때 같이 넘겨주기 */
        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        log.info("[NoticeController] searchMap = " + searchMap);

        /* 페이징처리를 위해 전체 개수 조회 */
        int totalCount = noticeService.selectTotalCount(searchMap);

        log.info("[NoticeController] totalCount = " + totalCount);

        /* 한 페이지당 최대 조회 개수 */
        int limit = 6;
        /* 페이지 이동 버튼 최대 개수 */
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        /* 페이지 이동시 인자값 같이 넘기기 */
        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        log.info("[NoticeController] selectCriteria = " + selectCriteria);

        /* 공지사항 리스트 조회하기 */
        List<NoticeDTO> noticeList = noticeService.selectNoticeList(selectCriteria);

        log.info("[NoticeController] noticeList = " + noticeList);

        mv.addObject("noticeList", noticeList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("/notice/user/userNoticeList");

        return mv;
    }

    /* 관리자 공지사항 등록 페이지 이동 */
    @GetMapping("/admin/insert")
    public String noticeInsertPage(){

        return "/notice/admin/adminNoticeInsert";
    }

    /* 관리자 공지사항 등록 */
    @PostMapping("/admin/insert")
    public String noticeInsert(@ModelAttribute NoticeDTO notice,
                               @RequestParam(value="file", required=false) MultipartFile file,
                               RedirectAttributes rttr
                               ) throws Exception{

        NoticeFileDTO noticeFile = new NoticeFileDTO();

        /* 공지사항 등록 */
        int result = noticeService.noticeInsert(notice);

        log.info("[NoticeController]" + notice);
        log.info("[NoticeController]" + file);

        /* 공지사헝 첨부파일 첨부 시 저장 루트 설정 */
        String root = ResourceUtils.getURL("src/main/resources").getPath();
        String filePath = root + "static/uploadFiles";

        log.info("루트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + filePath);

        /* 저장 루트 폴더 없을 시 폴더 생성 */
        File mkdir = new File(filePath);
        if(!mkdir.exists()) {
            mkdir.mkdirs();
        }

        String originFileName = "";
        String ext = "";
        String changeName = "";
        String savedPath = "";

        if(file.getSize() > 0) {
            originFileName = file.getOriginalFilename(); // 첨부 파일명
            ext = originFileName.substring(originFileName.lastIndexOf(".")); // 첨부파일명 끝 확장자
            changeName = UUID.randomUUID().toString().replace("-",  ""); // 첨부 파일명 랜덤 설정
            savedPath = filePath + "/" + changeName + ext; // 저장 경로 및 파일명

            /* 첨부파일정보 noticeFile DTO에 담기 */
            noticeFile.setOriginName(originFileName);
            noticeFile.setFileName(changeName + ext);
            noticeFile.setSavedPath(savedPath);

            /* 첨부 파일 등록시 파일정보 등록 */
            noticeService.noticeFileInsert(noticeFile);

            try {
                /* 등록 성공 시 파일명 changeName + ext로 변경하여 저장 */
                file.transferTo(new File(filePath + "\\" + changeName + ext));
            } catch (IOException e) {

                /* 등록 실패 시 해당 파일 삭제 */
                e.printStackTrace();
                new File(filePath + "\\" + changeName + ext).delete();
            }
        }

        /* 등록 성공 시 alert창으로 message 띄워주기 위해 넘겨줌 */
        rttr.addFlashAttribute("message", "공지사항 등록 성공!");

        return "redirect:/notice/admin/list";
    }

    /* 관리자 공지사항 상세페이지 */
    @GetMapping("/admin/detail")
    public ModelAndView adminNoticeDetail(ModelAndView mv, HttpServletRequest request){

        /* 공지사항 index 가져오기 */
        int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
        log.info("[noticeController] noticeNo : " + noticeNo);

        /* 공지사항 index로 해당 게시물 상세정보 조회 */
        NoticeDTO noticeDetail = noticeService.noticeDetailByNo(noticeNo);
        log.info("[noticeController] noticeDetail : " + noticeDetail);

        mv.addObject("noticeDetail", noticeDetail);
        mv.setViewName("/notice/admin/adminNoticeDetail");

        return mv;
    }

    /* 유저 공지사항 상세페이지 */
    @GetMapping("/user/detail")
    public ModelAndView userNoticeDetail(ModelAndView mv, HttpServletRequest request){

        /* 공지사항 index 가져오기 */
        int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
        log.info("[noticeController] noticeNo : " + noticeNo);

        /* 공지사항 index로 해당 게시물 상세정보 조회 */
        NoticeDTO noticeDetail = noticeService.noticeDetailByNo(noticeNo);
        log.info("[noticeController] noticeDetail : " + noticeDetail);

        mv.addObject("noticeDetail", noticeDetail);
        mv.setViewName("/notice/user/userNoticeDetail");

        return mv;
    }

    /* 관리자 공지사항 삭제 */
    @GetMapping("/admin/delete")
    public String deleteNotice(HttpServletRequest request, RedirectAttributes rttr) throws NoticeDeleteException {

        /* 공지사항 index 가져오기 */
        int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));

        /* 공지사항 index로 해당 게시물 삭제하기 */
        int result = noticeService.deleteNotice(noticeNo);

        /* 삭제 성공 시 alert창으로 message를 띄워주기 위해 넘겨줌 */
        rttr.addFlashAttribute("message", "공지사항 삭제 성공!");

        return "redirect:/notice/admin/list";
    }

    /* 관리자 공지사항 수정 페이지 이동 */
    @GetMapping("/admin/update")
    public ModelAndView updateNoticePage(HttpServletRequest request, ModelAndView mv) {

        /* 공지사항 index 가져오기 */
        int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));

        /* 공지사항 index로 해당 게시물 상세정보 조회 */
        NoticeDTO noticeDetail = noticeService.noticeDetailByNo(noticeNo);

        mv.addObject("noticeDetail", noticeDetail);
        mv.setViewName("/notice/admin/adminNoticeUpdate");

        return mv;
    }

    /* 관리자 공지사항 수정 */
    @PostMapping("/admin/update")
    public String updateNotice(@ModelAttribute NoticeDTO notice,
                               @RequestParam int noticeNo,
                               @RequestParam(value="file", required=false) MultipartFile file,
                               RedirectAttributes rttr) throws Exception{

        /* 공지사항 정보 수정하기 */
        int result = noticeService.updateNotice(notice);

        log.info("[NoticeController]" + notice);
        log.info("[NoticeController]" + file);

        /* 공지사헝 첨부파일 첨부 시 저장 루트 설정 */
        String root = ResourceUtils.getURL("src/main/resources").getPath();
        String filePath = root + "static/uploadFiles";

        log.info("루트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + filePath);

        /* 저장 루트 폴더 없을 시 폴더 생성 */
        File mkdir = new File(filePath);
        if(!mkdir.exists()) {
            mkdir.mkdirs();
        }

        String originFileName = "";
        String ext = "";
        String changeName = "";
        String savedPath = "";

        if(file.getSize() > 0) {
            originFileName = file.getOriginalFilename(); // 첨부 파일명
            ext = originFileName.substring(originFileName.lastIndexOf(".")); // 첨부파일명 끝 확장자
            changeName = UUID.randomUUID().toString().replace("-",  ""); // 첨부 파일명 랜덤 설정
            savedPath = filePath + "/" + changeName + ext; // 저장 경로 및 파일명

            NoticeFileDTO noticeFile = new NoticeFileDTO();

            if(result > 0) {

                if(notice.getNoticeFile() != null){

                    /* 수정 할 공지사항에 파일 정보가 존재하면 삭제한다. */
                    int result2 = noticeService.deleteNoticeFile(noticeNo);

                    /* 파일 정보 삭제 후 파일 재첨부시 DTO에 담아 재등록 한다. */
                    if(result2 > 0) {

                        noticeFile.setNoticeNo(noticeNo);
                        noticeFile.setOriginName(originFileName);
                        noticeFile.setFileName(changeName);
                        noticeFile.setSavedPath(savedPath);

                        noticeService.updateNoticeFile(noticeFile);
                    }

                } else {

                        /* 첨부 파일 등록시 DTO에 담아 파일정보 등록 */
                        noticeFile.setNoticeNo(noticeNo);
                        noticeFile.setOriginName(originFileName);
                        noticeFile.setFileName(changeName);
                        noticeFile.setSavedPath(savedPath);

                        noticeService.updateNoticeFile(noticeFile);
                    }

            }

            try {
                /* 등록 성공 시 파일명 changeName + ext로 변경하여 저장 */
                file.transferTo(new File(filePath + "\\" + changeName + ext));
            } catch (IOException e) {

                /* 등록 실패 시 해당 파일 삭제 */
                e.printStackTrace();
                new File(filePath + "\\" + changeName + ext).delete();
            }
        }

        /* 수정 성공 시 alert창으로 message를 띄어주기 위해 넘겨줌 */
        rttr.addFlashAttribute("message", "공지사항 수정 성공!");

        return "redirect:/notice/admin/list";

        }
}
