package com.chicken.project.account.controller;

import com.chicken.project.account.model.dto.AccountApplyDTO;
import com.chicken.project.account.model.dto.AccountDTO;
import com.chicken.project.account.model.dto.StoreBreakdownDTO;
import com.chicken.project.account.model.dto.StoreDepositDTO;
import com.chicken.project.account.model.service.AccountService;
import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.member.model.dto.StoreImpl;
import com.chicken.project.store.model.dto.BalanceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account/*")
public class AccountController {

    private final AccountService accountService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }

    /* 관리자 입금신청 내역 조회 */
    @GetMapping("/admin/list")
    public ModelAndView accountAdminList(ModelAndView mv, HttpServletRequest request) {

        /* 현재 페이지 인덱스 가져오기 */
        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        /* 페이징처리를 위해 전체 개수 조회 */
        int totalCount = accountService.selectTotalCount();

        log.info("[AccountController] totalCount = " + totalCount);

        /* 한 페이지당 최대 조회 개수 */
        int limit = 6;
        /* 페이지 이동 버튼 최대 개수 */
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        /* 페이지 이동시 인자값 같이 넘기기 */
        selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        log.info("[AccountController] selectCriteria = " + selectCriteria);

        /* 입금 신청 리스트 조회하기 */
        List<AccountApplyDTO> accountApplyList = accountService.selectAccountApplyList(selectCriteria);

        mv.addObject("accountApplyList", accountApplyList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("/account/admin/adminAccountList");

        return mv;
    }

    /* 본인이 입금신청 한 내역 조회 */
    @GetMapping("/user/list")
    public ModelAndView accountUserList(ModelAndView mv, @AuthenticationPrincipal User user) {

        /* 현재 로그인 storeName 가져오기 */
        String storeName = ((StoreImpl) user).getStoreName();

        /* 현재 로그인 계정 입금신청 내역 조회하기 */
        List<AccountDTO> accountList = accountService.selectAccountListByStoreName(storeName);
        /* 현재 로그인 계정 잔액 조회하기 */
        BalanceDTO balance = accountService.selectBalance(storeName);

        log.info("[AccountController] accountList : " + accountList );
        log.info("[AccountController] balance : " + balance);

        mv.addObject("accountList", accountList);
        mv.addObject("balance", balance);

        mv.setViewName("/account/user/userAccountList");

        return mv;
    }

    /* 관리자 입금신청 승인 */
    @GetMapping("/admin/update")
    public String adminAccountApplyUpdate(@ModelAttribute AccountApplyDTO accountApply,HttpServletRequest request, RedirectAttributes rttr){

        /* 입금신청 금액 가져오기 */
        int accountDeposit = Integer.parseInt(request.getParameter("accountDeposit"));
        /* 입금신청한 storeName 가져오기 */
        String storeName = request.getParameter("storeName");

        log.info("[AccountController] accountDeposit : " + accountDeposit);
        log.info("[AccountController] storeName : " + storeName);
        log.info("[AccountController] accountApply : " + accountApply);

        /* 입금 승인시 입금신청한 store 잔액 update 해주기 */
        accountService.balanceUpdate(accountApply, accountDeposit, storeName);

        /* 입금 승인시 alert창으로 message 띄워주기 위해 넘겨줌 */
        rttr.addFlashAttribute("message", "입금을 승인 하였습니다.");

        return "redirect:/account/admin/list";
    }

    /* 관리자 입금신청 반려 */
    @GetMapping("/admin/update2")
    public String adminAccountApplyUpdate2(HttpServletRequest request, RedirectAttributes rttr){

        /* 입금신청한 index 가져오기 */
        int depositNum = Integer.parseInt(request.getParameter("depositNum"));

        /* 입금신청한 index 반려하기 */
        accountService.accountApplyUpdate2(depositNum);

        /* 입금신청 반려시 alert창으로 message 띄워주기 위해 넘겨줌 */
        rttr.addFlashAttribute("message", "입금을 반려 하였습니다.");

        return "redirect:/account/admin/list";
    }

    /* 유저 입금신청 */
    @GetMapping("/user/insert")
    public String userAccountInsert(@RequestParam int accountDeposit, RedirectAttributes rttr, @AuthenticationPrincipal User user){

        log.info("[AccountController] accountDeposit : " + accountDeposit);

        /* 현재 로그인 storeName 가져오기 */
        String storeName = ((StoreImpl) user).getStoreName();

        log.info("[AccountController] storeName : " + storeName);

        /* 입금신청 하기 */
        accountService.accountInsert(accountDeposit, storeName);

        /* 입금신청 시 alert창으로 message 띄워주기 위해 넘겨줌 */
        rttr.addFlashAttribute("message", "입금 신청을 하였습니다.");

        return "redirect:/account/user/list";

    }

    /* 가맹점 입출금 내역 조회 */
    @GetMapping("/user/bank")
    public ModelAndView userBankPage(ModelAndView mv, @AuthenticationPrincipal User user){

        /* 현재 로그인 storeName 가져오기 */
        String storeName = ((StoreImpl) user).getStoreName();

        /* 현재 로그인 잔액 조회 */
        BalanceDTO balance = accountService.selectBalance(storeName);
        /* 현재 로그인 입금내역 조회 */
        List<StoreDepositDTO> storeDeposit = accountService.selectStoreDeposit(storeName);
        /* 현재 로그인 출금내역 조회 */
        List<StoreBreakdownDTO> storeBreakdown = accountService.selectStoreBreakdown(storeName);

        log.info("[AccountController] balance : " + balance);

        mv.addObject("balance", balance);
        mv.addObject("storeDeposit", storeDeposit);
        mv.addObject("storeBreakdown", storeBreakdown);

        mv.setViewName("/account/user/userBank");

        return mv;
    }

    /* 관리자 가맹점 잔액 조회 */
    @GetMapping("/admin/balance")
    public ModelAndView adminBalanceSelect(ModelAndView mv){

        /* 전체 가맹점 잔액 조회 */
        List<BalanceDTO> balanceSelect = accountService.balanceSelect();

        mv.addObject("balanceSelect", balanceSelect);
        mv.setViewName("/account/admin/adminBalanceSelect");

        return mv;
    }


}
