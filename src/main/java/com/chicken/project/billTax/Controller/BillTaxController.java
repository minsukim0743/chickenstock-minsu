package com.chicken.project.billTax.Controller;

import com.chicken.project.billTax.model.dto.BillTaxDTO;
import com.chicken.project.billTax.model.dto.tsBillTaxDTO;
import com.chicken.project.billTax.model.service.BillTaxServiceImpl;
import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.member.model.dto.StoreImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/billTax/*")
public class BillTaxController {

    private final BillTaxServiceImpl billTaxService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public BillTaxController(BillTaxServiceImpl billTaxService){

        this.billTaxService = billTaxService;
    }

    // 가맹점 세금계산서
    @GetMapping("/billList")
    public ModelAndView billList(ModelAndView mv, HttpServletRequest request,@AuthenticationPrincipal StoreImpl storeImpl) {

        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
            if(pageNo <= 0) {

                pageNo = 1;
            }
        }
        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");
        String storeName = storeImpl.getStoreName();

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("storeName", storeName);

        log.info("[BillTaxController] searchMap = " + searchMap);

        int totalCount = billTaxService.selectTotalCountS(searchMap);
        log.info("[BillTaxController] totalCount = " + totalCount);

        int limit = 30;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        log.info("[taxBillController] selectCriteria = " + selectCriteria);

        List<BillTaxDTO> taxBillList = billTaxService.selectTaxBillList(selectCriteria);

        Map<String, List<BillTaxDTO>> map = new HashMap<>();

        for(int i = 0; i < taxBillList.size(); i++){
            String recCode = taxBillList.get(i).getRecCode();
            List<BillTaxDTO> taxListMenu = billTaxService.selectTaxMenuList(recCode);

            map.put(recCode, taxListMenu);
        }

        log.info("[taxBillController] taxBillList = " + taxBillList);
        log.info("[taxBillController] map = " + map);
        //log.info("[taxBillController] recCode = " + recCode);

        mv.addObject("taxBillList", taxBillList);
        mv.addObject("taxListMenu", map);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("billTax/billList");

        return mv;
    }

    // 본사 세금계산서
    @GetMapping("/billtaxList")
    public ModelAndView billTaxList(ModelAndView mv, HttpServletRequest request) {

        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
            if(pageNo <= 0) {

                pageNo = 1;
            }
        }
        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        int totalCount = billTaxService.selectTotalCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        List<BillTaxDTO> billTaxList = billTaxService.selectBillList(selectCriteria);

        Map<String, List<BillTaxDTO>> map = new HashMap<>();

        for(int i = 0; i < billTaxList.size(); i++){
            String recCode = billTaxList.get(i).getRecCode();
            List<BillTaxDTO> taxListMenu = billTaxService.selectTaxMenuList(recCode);

            map.put(recCode, taxListMenu);
        }

        mv.addObject("billTaxList", billTaxList);
        mv.addObject("taxListMenu", map);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("billTax/billtaxList");

        return mv;
    }

    // 가맹점 거래명세서
    @GetMapping("/tsbillList")
    public ModelAndView tsBillList(ModelAndView mv, HttpServletRequest request, @AuthenticationPrincipal StoreImpl storeImpl){

        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
            if(pageNo <= 0) {

                pageNo = 1;
            }
        }
        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");
        String storeName = storeImpl.getStoreName();

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("storeName", storeName);

        int totalCount = billTaxService.selectTotalCountS(searchMap);

        int limit = 30;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<tsBillTaxDTO> tsBillTaxList = billTaxService.selectTsBillTaxList(selectCriteria);

        Map<String, List<tsBillTaxDTO>> map = new HashMap<>();

        for (int i = 0; i < tsBillTaxList.size(); i++) {
            String recCode = tsBillTaxList.get(i).getRecCode();
            List<tsBillTaxDTO> tsBillTaxListMenu = billTaxService.selectTsMenuList(recCode);

            map.put(recCode, tsBillTaxListMenu);
        }

        mv.addObject("tsBillTaxList", tsBillTaxList);
        mv.addObject("tsListMenu", map);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("billTax/tsbillList");

        return mv;
    }

    // 본사 거래명세서
    @GetMapping("/tsbilltaxList")
    public ModelAndView tsBillTaxList(ModelAndView mv, HttpServletRequest request){

        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
            if(pageNo <= 0) {

                pageNo = 1;
            }
        }
        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        int totalCount = billTaxService.selectTotalCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        List<tsBillTaxDTO> tsTaxBillList = billTaxService.selectTsList(selectCriteria);

        Map<String, List<tsBillTaxDTO>> map = new HashMap<>();

        for (int i = 0; i < tsTaxBillList.size(); i++) {
            String recCode = tsTaxBillList.get(i).getRecCode();
            List<tsBillTaxDTO> tsBillTaxListMenu = billTaxService.selectTsMenuList(recCode);

            map.put(recCode, tsBillTaxListMenu);
        }

        mv.addObject("tsBillTaxList", tsTaxBillList);
        mv.addObject("tsListMenu", map);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("billTax/tsbilltaxList");

        return mv;
    }
}