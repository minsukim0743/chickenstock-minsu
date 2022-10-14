package com.chicken.project.counsel.controller;

import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.counsel.model.dto.CounselApplyDTO;
import com.chicken.project.counsel.model.dto.CounselDTO;
import com.chicken.project.counsel.model.service.CounselService;
import com.chicken.project.member.model.dto.StoreImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/counsel/*")
public class CounselController {

    private final CounselService counselService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CounselController(CounselService counselService){

        this.counselService = counselService;
    }

    /* 본인이 작성한 1:1 문의 조회 */
    @GetMapping("/user/list")
    public ModelAndView userCounselListPage(ModelAndView mv, @AuthenticationPrincipal User user){

        /* 현재 로그인 storeName 가져오기 */
        String storeName = ((StoreImpl) user).getStoreName();

        log.info("[CounselController] storeName : " + storeName);

        /* 현재 로그인 계정 1:1 문의 리스트 조회하기 */
        List<CounselDTO> counselList = counselService.selectCounselByStoreName(storeName);

        mv.addObject("counselList", counselList);
        mv.setViewName("/counsel/user/userCounselList");

        return mv;
    }

    /* 관리자 1:1 문의 조회 */
    @GetMapping("/admin/list")
    public ModelAndView adminCounselListPage(ModelAndView mv, HttpServletRequest request){

        /* 현재 페이지 인덱스 가져오기 */
        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        /* 페이징처리를 위해 전체 개수 조회 */
        int totalCount = counselService.selectTotalCount();
        log.info("[CounselController] totalCount = " + totalCount);

        /* 한 페이지당 최대 조회 개수 */
        int limit = 6;
        /* 페이지 이동 버튼 최대 개수 */
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        /* 페이지 이동시 인자값 같이 넘기기*/
        selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        log.info("[CounselController] selectCriteria = " + selectCriteria);
        
        /* 1:1 문의 리스트 조회하기 */
        List<CounselDTO> counselList = counselService.selectCounsel(selectCriteria);

        mv.addObject("counselList", counselList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("/counsel/admin/adminCounselList");

        return mv;
    }

    /* 유저 1:1 문의 등록 페이지 이동 */
    @GetMapping("/user/insert")
    public String counselInsertPage(){

        return "/counsel/user/userCounselInsert";
    }

    /* 유저 1:1 문의 등록 */
    @PostMapping("/user/insert")
    public String userCounselInsert(@ModelAttribute CounselDTO counsel, RedirectAttributes rttr, ModelAndView mv){

        log.info("[CounselController] counsel : " + counsel);

        /* 유저 1:1 문의 작성하기 */
        counselService.insertCounsel(counsel);

        mv.addObject("counsel", counsel);

        /* 1:1 문의 작성시 alert창으로 message 띄워주기 위해 넘겨줌 */
        rttr.addFlashAttribute("message", "1:1 문의 등록 성공!");

        return "redirect:/counsel/user/list";
    }

    /* 관리자 1:1 문의 등록 상세페이지 */
    @GetMapping("/admin/detail")
    public ModelAndView adminCounselDetail(ModelAndView mv, @RequestParam int counselNo){

        log.info("[CounselController] counselNo : " + counselNo);

        /* RequestParam으로 1:1 문의 인덱스를 가져와 해당 1:1 문의 내용 조회 */
        CounselDTO counsel = counselService.selectCounselByNo(counselNo);
        /* RequestParam으로 1:1 문의 인덱스를 가져와 해당 1:1 문의 답변내용 조회 */
        CounselApplyDTO counselApply = counselService.selectCounselApplyByNo(counselNo);

        mv.addObject("counsel", counsel);
        mv.addObject("counselApply", counselApply);
        mv.setViewName("/counsel/admin/adminCounselDetail");

        return mv;
    }

    /* 관리자 1:1 문의 답변 등록 페이지 이동 */
    @GetMapping("/admin/insert")
    public ModelAndView adminCounselInsertPage(ModelAndView mv, HttpServletRequest request){

        /* 1:1 문의 답변 등록을 하기 위하여 해당 1:1 문의 index 가져오기 */
        int counselNo = Integer.parseInt(request.getParameter("counselNo"));
        log.info("[CounselController] counselNo : " + counselNo);

        /* 가져온 index로 해당 1:1 문의 내용 조회하기 */
        CounselDTO counsel = counselService.selectCounselByNo(counselNo);
        log.info("[CounselController] counsel : " + counsel);

        mv.addObject("counsel", counsel);
        mv.setViewName("/counsel/admin/adminCounselInsert");

        return mv;
    }

    /* 관리자 1:1 문의 답변 등록 */
    @PostMapping("/admin/insert")
    public String adminCounselInsert(@RequestParam String answerContent,
                                     HttpServletRequest request,
                                     ModelAndView mv,
                                     RedirectAttributes rttr){

        /* 1:1 문의 답변 등록을 하기 위하여 해당 1:1 문의 index 가져오기 */
        int counselNo = Integer.parseInt(request.getParameter("counselNo"));
        log.info("[CounselController] counselNo : " + counselNo);

        /* 관리자 1:1 문의 답변 등록 empName 가져오기 */
        String empName = request.getParameter("empName");
        
        /* 관리자 1:1 문의 답변 등록하기 */
        counselService.insertCounselApply(answerContent, counselNo, empName);

        /* 1:1 문의 답변 성공 시 alert창으로 message 띄워주기 위해 넘겨줌 */
        rttr.addFlashAttribute("message", "1:1문의 답변 등록 완료!");

        return "redirect:/counsel/admin/list";
    }

    /* 유저 1:1 문의 상세페이지 */
    @GetMapping("/user/detail")
    public ModelAndView userCounselPage(ModelAndView mv, @RequestParam int counselNo){

        log.info("[CounselController] couneslNo : " + counselNo);

        /* RequestParam으로 1:1 문의 인덱스를 가져와 해당 1:1 문의 내용 조회 */
        CounselDTO counsel = counselService.selectCounselByNo(counselNo);
        /* RequestParam으로 1:1 문의 인덱스를 가져와 해당 1:1 문의 답변내용 조회 */
        CounselApplyDTO counselApply = counselService.selectCounselApplyByNo(counselNo);

        mv.addObject("counsel", counsel);
        mv.addObject("counselApply", counselApply);

        mv.setViewName("/counsel/user/userCounselDetail");

        return mv;

    }
}
