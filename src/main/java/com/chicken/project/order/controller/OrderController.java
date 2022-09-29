package com.chicken.project.order.controller;

import com.chicken.project.account.model.service.AccountServiceImpl;
import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.exception.order.InterestException;
import com.chicken.project.member.model.dto.StoreImpl;
import com.chicken.project.order.model.dto.CartDTO;
import com.chicken.project.order.model.dto.InterestDTO;
import com.chicken.project.order.model.dto.OrderDTO;
import com.chicken.project.order.model.dto.OrderHistoryDTO;
import com.chicken.project.order.model.service.OrderServiceImpl;
import com.chicken.project.common.paging.SelectCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chicken.project.store.model.dto.BalanceDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("order")
public class OrderController {
    private final OrderServiceImpl orderService;
    private final AccountServiceImpl accountService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    public OrderController(OrderServiceImpl orderService, AccountServiceImpl accountService) {
        this.orderService = orderService;
        this.accountService = accountService;
    }

    /* 상품 조회 리스트 출력 */
    @GetMapping(value = "/list")
    public ModelAndView inquire(ModelAndView mv,
                                HttpServletRequest request,
                                @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();
        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;

        if (currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");



        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("storeName", storeName);

        int totalCount = orderService.selectTotalCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<OrderDTO> orderList = orderService.selectAllItem(selectCriteria);

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderList");
        return mv;

    }

    /* 관심 설정 저장 */
    @ResponseBody
    @PostMapping ("/list/interest/insert")
    public String interestControl(HttpServletRequest request,
                                        RedirectAttributes rttr,
                                        @AuthenticationPrincipal User user,
                                        ModelAndView mv
                                  ) throws InterestException {

        String storeName = ((StoreImpl) user).getStoreName();

        InterestDTO interest = new InterestDTO();
        OrderDTO order = new OrderDTO();

        int itemNo = Integer.parseInt(request.getParameter("itemNo"));
        interest.setItemNo(itemNo);

        interest.setStoreName(storeName);

        int interCheck = orderService.selectInterestCount(interest);
        String interYn = "";

        if (interCheck == 0) {
            interYn = "Y";
            order.setInterYn(interYn);
            orderService.insertInterest(interest);

        } else if (interCheck == 1) {
            interYn = "N";
            order.setInterYn(interYn);
            orderService.deleteInterest(interest);

        }

        rttr.addFlashAttribute("message", "관심 상품 등록 성공!");
        return "redirect:/order/list";
    }

    /* 관심 설정 상품만 조회 */
    @GetMapping("/list/interest/select")
    public ModelAndView interestList(ModelAndView mv,
                                     HttpServletRequest request,
                                     @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();
        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;

        if (currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("storeName", storeName);

        OrderDTO order = new OrderDTO();
        order.setStoreName(storeName);

        int totalCount = orderService.selectInterestItemCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<OrderDTO> orderList = orderService.selectInterestItem(selectCriteria);

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderList");
        return mv;

    }

    /* 품절 상품 제외 */
    @GetMapping("/list/available")
    public ModelAndView availableList(ModelAndView mv,
                                      HttpServletRequest request,
                                      @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();
        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;

        if (currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("storeName", storeName);

        int totalCount = orderService.selectAvailableItemCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<OrderDTO> orderList = orderService.selectAvailableItem(selectCriteria);

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderList");
        return mv;

    }

    /* 장바구니에 담기 */
    @GetMapping(value = "/list/insert")
    public ModelAndView insertCart (HttpServletRequest request,
                                    ModelAndView mv,
                                    @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();
        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;

        if (currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("storeName", storeName);

        int totalCount = orderService.selectTotalCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<OrderDTO> orderList = orderService.selectAllItem(selectCriteria);

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderList");

        return mv;
    }

    /* 장바구니에 담기 */
    @PostMapping(value="/list/insert")
    public ModelAndView insertCartList(HttpServletRequest request,
                                       ModelAndView mv,
                                       @RequestParam("itemNoList") String itemNoList,
                                       @AuthenticationPrincipal User user) throws InterestException, ParseException {

        String storeName = ((StoreImpl) user).getStoreName();
        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;

        if (currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("storeName", storeName);

        int totalCount = orderService.selectTotalCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<OrderDTO> orderList = orderService.selectAllItem(selectCriteria);

        System.out.println("itemNo = " + itemNoList);

        JSONParser jsonParse = new JSONParser();

        JSONArray jsonObj = (JSONArray) jsonParse.parse(itemNoList);

        System.out.println("jsonObj = " + jsonObj);

        CartDTO cart = new CartDTO();

        for(int i = 0; i < jsonObj.size(); i++){

            System.out.println("jsonObj.get(i).get(\"itemNo\") = " + ((JSONObject)jsonObj.get(i)).get("itemNo"));
            System.out.println("jsonObj.get(i).get(\"cartAmount\") = " + ((JSONObject)jsonObj.get(i)).get("cartAmount"));

            int itemNo = Integer.parseInt(((JSONObject)jsonObj.get(i)).get("itemNo").toString());
            int cartAmount = Integer.parseInt(((JSONObject)jsonObj.get(i)).get("cartAmount").toString());

            cart.setItemNo(itemNo);
            cart.setCartAmount(cartAmount);
            cart.setStoreName(storeName);
            int result = orderService.checkItemOverlap(cart);

            if(result == 0) {
                orderService.insertItemIntoCart(cart);

            } else {
                orderService.updateItemIntoCart(cart);
            }
        }

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("cart", cart);
        mv.setViewName("order/orderList");

        return mv;
    }

    /* 장바구니 리스트 출력 */
    @GetMapping(value = "/cart/list")
    public ModelAndView cartList(ModelAndView mv,
                                 HttpServletRequest request,
                                 @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();
        String currentPage = request.getParameter("currentPage");
        CartDTO cart = new CartDTO();

        int pageNo = 1;

        if (currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("storeName", storeName);

        int totalCount = orderService.selectCartTotalCount(searchMap);

        if (totalCount < 1) {
            cart.setCartCount("empty");
        } else {
            cart.setCartCount("have");
        }

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<CartDTO> cartList = orderService.selectCartItem(selectCriteria);
        BalanceDTO balance = accountService.selectBalance(storeName);

        mv.addObject("cart", cart);
        mv.addObject("cartList", cartList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.addObject("balance", balance);
        mv.setViewName("order/cart");
        return mv;
    }

    /* 장바구니 상품 삭제 */
    @PostMapping(value ="/cart/delete")
    public String deleteCartItem(HttpServletRequest request, @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();

        CartDTO cart = new CartDTO();
        cart.setStoreName(storeName);

        int itemNo = Integer.parseInt(request.getParameter("itemNo"));
        cart.setItemNo(itemNo);

        orderService.deleteCartItem(cart);

        return "redirect:/order/cart/list";
    }

    /* 장바구니 | 품절 상품 제외 */
    @GetMapping("/cart/available")
    public ModelAndView cartAvailableList(ModelAndView mv,
                                      HttpServletRequest request,
                                      @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();
        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;

        if (currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("storeName", storeName);

        int totalCount = orderService.selectCartAvailableItemCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<OrderDTO> orderList = orderService.selectCartAvailableItem(selectCriteria);

        mv.addObject("orderList", orderList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/cart");
        return mv;

    }


    /* 발주하기 */
    @GetMapping(value = "/insert/items/page")
    public ModelAndView insertItemsPage (HttpServletRequest request,
                                    ModelAndView mv,
                                    @AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();
        String currentPage = request.getParameter("currentPage");

        int pageNo = 1;

        if (currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("storeName", storeName);

        int totalCount = orderService.selectCartTotalCount(searchMap);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<CartDTO> cartList = orderService.selectCartItem(selectCriteria);

        mv.addObject("cartList", cartList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/cart");

        return mv;
    }


    /* 발주하기 */
    @PostMapping(value="/insert/items/do")
    public ModelAndView insertItemsDo(HttpServletRequest request,
                                      ModelAndView mv,
                                      @RequestParam("cartNoList") String cartNoList,
                                      @AuthenticationPrincipal User user) throws InterestException, ParseException {

        String storeName = ((StoreImpl) user).getStoreName();
        CartDTO cart = new CartDTO();
        cart.setStoreName(storeName);

        JSONParser jsonParse = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParse.parse(cartNoList);

        for (int i = 0; i < jsonArray.size(); i++) {

            String price = ((JSONObject) jsonArray.get(i)).get("totalPrice").toString();
            int totalPrice = Integer.parseInt(price.replace(",", ""));

            cart.setTotalPrice(totalPrice);

        }

        int checkPrice = cart.getTotalPrice();

        int balanceCheck = orderService.checkBalance(cart);

        if(checkPrice < balanceCheck) {
            int orderNoResult = orderService.insertStoreOrderNo(cart);

            JSONArray jsonArr = (JSONArray) jsonParse.parse(cartNoList);

            for (int i = 0; i < jsonArr.size(); i++) {

                int itemNo = Integer.parseInt(((JSONObject) jsonArr.get(i)).get("itemNo").toString());
                int cartAmount = Integer.parseInt(((JSONObject) jsonArr.get(i)).get("cartAmount").toString());
                int categoryNo = Integer.parseInt(((JSONObject) jsonArr.get(i)).get("categoryNo").toString());
                String price = ((JSONObject) jsonArr.get(i)).get("totalPrice").toString();
                int totalPrice = Integer.parseInt(price.replace(",", ""));

                cart.setItemNo(itemNo);
                cart.setCartAmount(cartAmount);
                cart.setCategoryNo(categoryNo);
                cart.setTotalPrice(totalPrice);

                orderService.resetCartItems(cart);

                int cartNoResult = orderService.insertOrderItems(cart);

                cart.setOrderNo(orderNoResult);
                cart.setCartNo(cartNoResult);

                orderService.insertOrderHandler(cart);

            }

                int result = orderService.insertStoreBreakdown(cart);

                if (result > 0) {

                    int result1 = orderService.updateStoreBalance(cart);

                    if (result1 > 0) {

                        mv.setViewName("order/orderSuccess");
                    }

                }

        } else {

            mv.setViewName("order/orderFailure");
            return mv;
        }

        return mv;
    }

    /* 발주 내역 조회 */
    @GetMapping(value = "/history")
    public ModelAndView history(ModelAndView mv,
                                HttpServletRequest request,
                                @AuthenticationPrincipal User user) throws java.text.ParseException {

        String storeName = ((StoreImpl) user).getStoreName();
        String currentPage = request.getParameter("currentPage");

        OrderHistoryDTO history = new OrderHistoryDTO();
        history.setStoreName(storeName);

        int pageNo = 1;

        if (currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("storeName", storeName);

        int totalCount = orderService.selectOrderHistoryCount(searchMap);

        int limit = 50;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue, storeName);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, storeName);
        }

        List<OrderHistoryDTO> historyList = orderService.selectOrderHistory(selectCriteria);

        String result = orderService.selectFinalOrderDate(history);
        history.setOrderDate(result);

        System.out.println("제발 테스트 날짜 : " + history.getOrderDate());

        mv.addObject("historyList", historyList);
        mv.addObject("history", history);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("order/orderHistory");
        return mv;

    }


    @GetMapping(value ="/cancel")
    public String cancelOrder(@AuthenticationPrincipal User user) {

        String storeName = ((StoreImpl) user).getStoreName();

        OrderHistoryDTO history = new OrderHistoryDTO();

        history.setStoreName(storeName);

        orderService.cancelOrder(history);

        return "redirect:/order/history";
    }



}