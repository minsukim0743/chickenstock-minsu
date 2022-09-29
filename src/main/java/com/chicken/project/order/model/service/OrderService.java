package com.chicken.project.order.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.exception.order.InterestException;
import com.chicken.project.order.model.dto.CartDTO;
import com.chicken.project.order.model.dto.InterestDTO;
import com.chicken.project.order.model.dto.OrderDTO;
import com.chicken.project.order.model.dto.OrderHistoryDTO;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<OrderDTO> selectAllItem(SelectCriteria selectCriteria);

    int selectTotalCount(Map<String, String> searchMap);

    int selectInterestCount(InterestDTO interest);

    int insertInterest(InterestDTO interest) throws InterestException;

    int deleteInterest(InterestDTO interest) throws InterestException;

    int selectCartTotalCount(Map<String, String> searchMap);

    List<CartDTO> selectCartItem(SelectCriteria selectCriteria);

    int selectAvailableItemCount(Map<String, String> searchMap);

    List<OrderDTO> selectAvailableItem(SelectCriteria selectCriteria);

    int selectInterestItemCount(Map<String, String> searchMap);

    List<OrderDTO> selectInterestItem(SelectCriteria selectCriteria);
    
    int insertStoreOrderNo(CartDTO cart);

    int insertOrderItems(CartDTO cart);

    void insertOrderHandler(CartDTO cart);

    void resetCartItems(CartDTO cart);

    void deleteCartItem(CartDTO cart);

    int selectOrderHistoryCount(Map<String, Object> searchMap);

    List<OrderHistoryDTO> selectOrderHistory(SelectCriteria selectCriteria);

    int insertStoreBreakdown(CartDTO cart);

    int updateStoreBalance(CartDTO cart);

    int selectCartAvailableItemCount(Map<String, String> searchMap);

    List<OrderDTO> selectCartAvailableItem(SelectCriteria selectCriteria);

    void cancelOrder(OrderHistoryDTO history);

    String selectFinalOrderDate(OrderHistoryDTO history);

    int checkItemOverlap(CartDTO cart);

    void insertItemIntoCart(CartDTO cart);

    void updateItemIntoCart(CartDTO cart);

    int checkBalance(CartDTO cart);
}
