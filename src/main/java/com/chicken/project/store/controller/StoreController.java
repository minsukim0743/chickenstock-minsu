package com.chicken.project.store.controller;

import com.chicken.project.exception.store.StoreInsertException;
import com.chicken.project.exception.store.StoreUpdateException;
import com.chicken.project.store.model.dto.StoreDTO;
import com.chicken.project.store.model.service.StoreService;
import com.chicken.project.store.model.service.StoreServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/store/*")
public class StoreController {

    private final StoreService storeService;
    private final PasswordEncoder passwordEncoder;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public StoreController(StoreService storeService, PasswordEncoder passwordEncoder) {

        this.storeService = storeService;
        this.passwordEncoder = passwordEncoder;
    }

    /* 관리자 가맹점 조회 */
    @GetMapping("/admin/list")
    public ModelAndView storeListPage(ModelAndView mv) {

        /* 가맹점 리스트 조회하기 */
        List<StoreDTO> storeList = storeService.storeList();
        log.info("[storeController] storeList : " + storeList);

        mv.addObject("storeList", storeList);
        mv.setViewName("/store/admin/adminStoreList");

        return mv;
    }

    /* 유저 가맹점 조회 */
    @GetMapping("/user/list")
    public ModelAndView userStoreListPage(ModelAndView mv) {

        /* 가맹점 리스트 조회하기 */
        List<StoreDTO> storeList = storeService.storeList();
        log.info("[storeController] storeList : " + storeList);

        mv.addObject("storeList", storeList);
        mv.setViewName("/store/user/userStoreList");

        return mv;
    }

    /* 관리자 가맹점 삭제 */
    @GetMapping("/admin/delete")
    public String deleteStore(HttpServletRequest request, RedirectAttributes rttr) throws Exception {

        /* 가맹점 명  가져오기 */
        String storeName = request.getParameter("storeName");
        log.info("[storeController] storeName : " + storeName);

        /* 가져온 가맹점 명으로 해당 가맹점 정보 삭제  */
        storeService.deleteStore(storeName);

        /* 가맹점 정보 삭제 시 alert창으로 message 띄워주기 위해 넘겨줌 */
        rttr.addFlashAttribute("message", "가맹점 정보 삭제 성공!");

        return "redirect:/store/admin/list";
    }

    /* 관리자 가맹점 등록 페이지 이동 */
    @GetMapping("/admin/insert")
    public String insertStorePage() {

        return "/store/admin/adminStoreInsert";
    }

    /* 관리자 가맹점 등록 */
    @PostMapping("/admin/insert")
    public String insertStore(@ModelAttribute StoreDTO store, HttpServletRequest request ,RedirectAttributes rttr, ModelAndView mv) throws StoreInsertException {

        /* 주소API를 사용하여 가져온 정보를 합쳐준다. */
        String storeAddress = request.getParameter("addr1") + " " + request.getParameter("addr2") + " " + request.getParameter("addr3");

        store.setStorePhone(store.getStorePhone().replace("-", ""));
        store.setStorePwd(passwordEncoder.encode(store.getStorePwd())); // 정보 보호를 위하여 password는 Encode 해줌.
        store.setStoreAddress(storeAddress);

        log.info("[StoreController] store : " + store);

        /* 가맹점 등록 */
        storeService.insertStore(store);

        /* 가맹점 등록 성공 시 alert창으로 message를 띄워주기 위해 넘겨줌 */
        rttr.addFlashAttribute("message", "가맹점 등록 성공!");

        mv.addObject("store", store);

        return "redirect:/store/admin/list";
    }

    /* 관리자 가맹점 정보 수정 페이지 이동 */
    @GetMapping("/admin/update")
    public ModelAndView updateStorePage(HttpServletRequest request, RedirectAttributes rttr, ModelAndView mv) {

        /* 가맹점 정보 수정을 위하여 해당 가맹점 명을 가져옴 */
        String storeName = request.getParameter("storeName");
        log.info("[StoreController] storeName : " + storeName);

        /* 가맹점 명으로 해당 가맹점 정보 조회 */
        StoreDTO store = storeService.selectStoreByName(storeName);

        mv.addObject("store", store);
        mv.setViewName("/store/admin/adminStoreUpdate");

        return mv;
    }

    /* 관리자 가맹점 정보 수정 */
    @PostMapping("/admin/update")
    public String updateStore(@ModelAttribute StoreDTO store, RedirectAttributes rttr) throws StoreUpdateException {

        log.info("[StoreController] store : " + store);
        log.info("[StoreController] storeId : " + store.getStoreId());

        /* 해당 가맹점 정보 수정 */
        storeService.updateStore(store);

        /* 수정 성공 시 alert창으로 message를 띄워주기 위해 넘겨줌 */
        rttr.addFlashAttribute("message", "가맹점 정보 수정 성공!");

        return "redirect:/store/admin/list";
    }

}
