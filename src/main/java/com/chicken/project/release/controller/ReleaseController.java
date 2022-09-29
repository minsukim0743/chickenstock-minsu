package com.chicken.project.release.controller;


import com.chicken.project.release.model.dto.*;
import com.chicken.project.release.model.service.ReleaseService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/release")
public class ReleaseController {

    private final ReleaseService releaseService;
    private RelItemDTO relItemDTO;

    @Autowired
    public ReleaseController(ReleaseService releaseService) {

        this.releaseService = releaseService;
    }

    @RequestMapping("/orderSelect")
    public ModelAndView releaseOrderSelect(ModelAndView mv, Model model, @ModelAttribute ReleaseSelectCriteria releaseSelectCriteria){

        System.out.println(releaseSelectCriteria);
        /* 발주서에 등록된 발주품목 조회 */
        List<ReleaseOrderDTO> orderList = releaseService.releaseOrderSelect(releaseSelectCriteria);
        System.out.println(orderList);
        /* 임시출고서에 등록된 출고품목 조회 */
        List<ReleaseOrderDTO> orderListN = releaseService.releaseOrderSelectN();
        /* 출고서 목록 조회 */
        List<ReleaseDTO> releaseDTO = releaseService.releaseDtoOrderSelect();

        System.out.println(releaseDTO.size());

        /* 출고번호 생성 코드 */
        int relCode = 0;

        if(!releaseDTO.isEmpty()){
            relCode = releaseDTO.size()+1;

        } else {
            relCode = releaseDTO.size()+1;
        }

        System.out.println("relCode : " + relCode);

        System.out.println(releaseSelectCriteria);

        for(ReleaseOrderDTO ro : orderListN){
            System.out.println(ro);
        }

        int intRelCode = relCode;
        /* 출고서 작성시 물품 총 금액 조회 */
        Integer totalMoney = releaseService.totalMoneySelect(intRelCode);

        mv.addObject("orderList", orderList);
        mv.addObject("orderListN", orderListN);
        mv.addObject("releaseSelectCriteria", releaseSelectCriteria);
        mv.addObject("totalMoney", totalMoney);
        mv.addObject("relCode", relCode);
        mv.addObject("releaseDTO",releaseDTO);

        mv.setViewName("release/release_order");

        return mv;
    }

    @PostMapping("/orderInsertUpdate")
    public ModelAndView releaseInsertUpdate(@ModelAttribute ReleaseItemInfoDTO releaseItemInfoDTO,
                                            @ModelAttribute ReleaseItemDTO releaseItemDTO,
                                            @ModelAttribute ReleaseCartDTO releaseCartDTO,
                                            @ModelAttribute StoreOrderDTO storeOrderDTO,
                                            @RequestParam("relCode") int relCode,
                                            ModelAndView mv) {

        System.out.println("releaseItemInfoDTO = " + releaseItemInfoDTO);
        System.out.println("ReleaseItemDTO = " + releaseItemDTO);
        System.out.println("releaseCartDTO = " + releaseCartDTO);
        System.out.println("StoreOrderDTO = " + storeOrderDTO);
        System.out.println("relCode" + relCode);

        int itemSales = Integer.parseInt(releaseItemInfoDTO.getItemSales());
        int orderAmount = releaseCartDTO.getCartAmount();
        int totalItemMoney = itemSales * orderAmount;
        int cartNo = releaseCartDTO.getCartNo();
        int relCodeDetail = releaseItemDTO.getRelCodeDetail();

        System.out.println("itemSales = " + itemSales);
        System.out.println("orderAmount = " + orderAmount);
        System.out.println("totalItemMoney = " + totalItemMoney);
        System.out.println("cartNo = " + cartNo);
        System.out.println("relCodeDetail = " + relCodeDetail);


        /* 임시출고서에 가맹점 발주 물품 등록 */
        int resultUpdate = releaseService.cartYnUpdateR(releaseCartDTO);
        int resultInsert = releaseService.releaseItemInsert(releaseItemInfoDTO, releaseItemDTO, storeOrderDTO, releaseCartDTO, relCode, totalItemMoney);
        int resultInsert2 = releaseService.releaseInsertHandler(cartNo, relCodeDetail);

        mv.setViewName("redirect:/release/orderSelect");

        return mv;
    }
    @PostMapping("/orderDeleteUpdate")
    public ModelAndView releaseDeleteUpdate(@ModelAttribute ReleaseItemInfoDTO releaseItemInfoDTO,
                                            @ModelAttribute ReleaseItemDTO releaseItemDTO,
                                            @ModelAttribute ReleaseCartDTO releaseCartDTO,
                                            @ModelAttribute StoreOrderDTO storeOrderDTO,
                                            @RequestParam("relCode") int relCode,
                                            ModelAndView mv) {

        System.out.println("StoreOrderDTO = " + storeOrderDTO);
        System.out.println("releaseItemInfoDTO = " + releaseItemInfoDTO);
        System.out.println("releaseItemDTO = " + releaseItemDTO);
        System.out.println("releaseCartDTO = " + releaseCartDTO);
        System.out.println("relCode" + relCode);

        int resultUpdate  = releaseService.releaseItemUpdateN(releaseItemDTO);
        int resultUpdate2 = releaseService.cartYnUpdateN(releaseCartDTO);
        int resultDelete = releaseService.releaseItemDelete(releaseItemInfoDTO, releaseCartDTO, releaseItemDTO, storeOrderDTO, relCode);

        mv.setViewName("redirect:/release/orderSelect");
        return mv;
    }

    @PostMapping("/releaseInsertUpdate")
    public ModelAndView releaseInsert(ModelAndView mv, @ModelAttribute ReleaseDTO relDto){

        System.out.println(relDto);

        int releaseInsert = releaseService.releaseInsert(relDto);
        int resultUpdate = releaseService.releaseItemUpdateF();

        mv.setViewName("redirect:/release/orderSelect");
        return mv;
    }

    @GetMapping("/releaseSelect")
    public ModelAndView releaseSelect(ModelAndView mv, @ModelAttribute ReleaseSelectCriteria releaseSelectCriteria, HttpServletRequest request){

        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;
        if(currentPage != null && !"".equals(currentPage)){

            pageNo = Integer.parseInt(currentPage);
        }

        int totalCount = releaseService.totalCount(releaseSelectCriteria);

        int limit;
        if(releaseSelectCriteria.getSearchCategory() != null && !"".equals(releaseSelectCriteria.getSearchCategory())){
            limit = totalCount;
        } else {
            limit = 10;
        }

        int buttonAmount = 5;

        if(releaseSelectCriteria.getSearchCategory() != null && !"".equals(releaseSelectCriteria.getSearchCategory())){

            releaseSelectCriteria = ReleasePagenation.getReleaseSelectCriteria(pageNo, totalCount, limit, buttonAmount, releaseSelectCriteria.getSearchCategory(), releaseSelectCriteria.getSearchValue(), releaseSelectCriteria.getSearchDate(), releaseSelectCriteria.getSearchDate2());
        } else {

            releaseSelectCriteria = ReleasePagenation.getReleaseSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        List<ReleaseDTO> releaseSelect = releaseService.releaseSelect(releaseSelectCriteria);

        System.out.println("selectCriteria : " + releaseSelectCriteria);

        List<List<ReleaseOrderDTO>> releaseSelectItem = new ArrayList<>();

        for(int i = 0; i < releaseSelect.size(); i++){

            int relCode = releaseSelect.get(i).getRelCode();
            List<ReleaseOrderDTO> releaseSelect2 = releaseService.releaseSelect2(relCode);

            System.out.println("releaseSelect2 = " + releaseSelect2);
            releaseSelectItem.add(releaseSelect2);
        }
        mv.addObject("releaseSelectCriteria", releaseSelectCriteria);
        mv.addObject("releaseSelect", releaseSelect);
        mv.addObject("releaseSelectItem", releaseSelectItem);
        mv.setViewName("release/release_list");
        return mv;
    }

    @RequestMapping(value="/releaseItem", method=RequestMethod.POST)
    @ResponseBody
    public Object releaseItemInsertUpdate(@ModelAttribute RelItemDTO relItemDTO, HttpServletResponse response) {

        response.setContentType("application/json");

        System.out.println("relItemDTO :" + relItemDTO);

        int itemAmount = Integer.parseInt(relItemDTO.getItemAmount());
        int orderAmount = Integer.parseInt(relItemDTO.getOrderAmount());
        int itemNo = Integer.parseInt(relItemDTO.getItemNo());
        int relCode = Integer.parseInt(relItemDTO.getRelCode());
        int relCodeDetail = Integer.parseInt(relItemDTO.getRelCodeDetail());
        int relSumAmount = Integer.parseInt(relItemDTO.getRelSumAmount());
        int relAmount = Integer.parseInt(relItemDTO.getRelAmount());

        int amountUpdate = itemAmount - relAmount;
        int relSum = relAmount + relSumAmount;

        System.out.println("itemAmount : " + relItemDTO.getItemAmount());
        System.out.println("orderAmount : " + relItemDTO.getOrderAmount());
        System.out.println("itemNo : " + relItemDTO.getItemNo());
        System.out.println("relCode : " + relItemDTO.getRelCode());
        System.out.println("relCodeDetail : " + relItemDTO.getRelCodeDetail());
        System.out.println("relSumAmount : " + relItemDTO.getRelSumAmount());
        System.out.println("relAmount : " + relItemDTO.getRelAmount());
        System.out.println("itemAmountUpdate : " + amountUpdate);
        System.out.println("relSum : " + relSum);

        Map<String, Integer> itemAmountUpdate = new HashMap<>();
        itemAmountUpdate.put("itemAmount", itemAmount);
        itemAmountUpdate.put("cartAmount", orderAmount);
        itemAmountUpdate.put("relAmount", relAmount);
        itemAmountUpdate.put("amountUpdate", amountUpdate);
        itemAmountUpdate.put("relSum", relSum);
        itemAmountUpdate.put("itemNo", itemNo);
        itemAmountUpdate.put("relCode", relCode);
        itemAmountUpdate.put("relCodeDetail", relCodeDetail);

        System.out.println("itemAmountInsert : " + itemAmountUpdate);

        int result1 = releaseService.itemAmountUpdate(itemAmountUpdate);
        int result4 = releaseService.itemHistoryInsert(relCode, itemNo);


        if(orderAmount != relSum) {

            int result2 = releaseService.relItemHistoryInsert(itemAmountUpdate);

        } else {

            int result2 = releaseService.relItemHistoryInsert(itemAmountUpdate);
            int result3 = releaseService.releaseItemUpdateY(itemAmountUpdate);
            List<ReleaseItemDTO> relItemSelectY = releaseService.relItemSelectY(relCode);

            int sum = 0;
            for(int i = 0; i < relItemSelectY.size(); i++){

                if(relItemSelectY.get(i).getRelYn().equals("Y")){

                    sum++;
                } else {

                    break;
                }

                System.out.println("sum :" + sum);

                if(sum == relItemSelectY.size()){

                    int relYnResult = releaseService.relYnUpdate(relCode);
                }
            }
        }

        ReleaseOrderDTO relItemDetailAjax = releaseService.relItemDetailSelect(relCodeDetail);

        System.out.println("relItemDetailAjax : " + relItemDetailAjax);
        int reItemAmount = relItemDetailAjax.getReleaseItemInfoDTO().getItemAmount();
        int reRelSumAmount = relItemDetailAjax.getReleaseItemHistroyDTO().getRelSumAmount();
        java.sql.Date reRelDate = relItemDetailAjax.getReleaseItemDTO().getRelDate();
        String reRelYn = relItemDetailAjax.getReleaseItemDTO().getRelYn();

        Map<String, Object> ajaxMap = new HashMap<>();
        ajaxMap.put("itemAmount", reItemAmount);
        ajaxMap.put("relSumAmount", reRelSumAmount);
        ajaxMap.put("relDate", reRelDate);
        ajaxMap.put("relYn", reRelYn);

        return ajaxMap;
    }

    @GetMapping("/releaseItemDetail")
    @ResponseBody
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String storitemDetail(@RequestParam("relCodeDetail") String relCodeDetail, HttpServletResponse response) throws JsonProcessingException {

        response.setContentType("application/json; charset=UTF-8");

        System.out.println("relCodeDetail : " + relCodeDetail);

        ReleaseDetailDTO selectDetail = releaseService.selectDetail(relCodeDetail);

        System.out.println(selectDetail);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(selectDetail);
    }
}
