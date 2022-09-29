package com.chicken.project.order.model.service;

import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.exception.order.InterestException;
import com.chicken.project.order.model.dao.OrderMapper;
import com.chicken.project.order.model.dto.CartDTO;
import com.chicken.project.order.model.dto.InterestDTO;
import com.chicken.project.order.model.dto.OrderDTO;
import com.chicken.project.order.model.dto.OrderHistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {

        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> selectAllItem(SelectCriteria selectCriteria) {

        return orderMapper.selectAllItem(selectCriteria);

    }

    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = orderMapper.selectTotalCount(searchMap);

        return result;

    }

    @Override
    public int selectInterestCount(InterestDTO interest) {

        int interCheck = orderMapper.selectInterestCount(interest);

        return interCheck;
    }

    @Override
    @Transactional
    public int insertInterest(InterestDTO interest) throws InterestException {

        int insert = orderMapper.insertInterest(interest);

        if (!(insert > 0)) {

            throw new InterestException("관심 등록에 실패하셨습니다.");
        }

        return insert;
    }

    @Override
    @Transactional
    public int deleteInterest(InterestDTO interest) throws InterestException {

        int delete = orderMapper.deleteInterest(interest);

        if (!(delete > 0)) {

            throw new InterestException("관심 삭제에 실패하셨습니다.");
        }

        return delete;

    }

    @Override
    public int selectCartTotalCount(Map<String, String> searchMap) {

        int result = orderMapper.selectCartTotalCount(searchMap);

        return result;

    }


    @Override
    public List<CartDTO> selectCartItem(SelectCriteria selectCriteria) {

        return orderMapper.selectCartItem(selectCriteria);
    }

    @Override
    public int selectAvailableItemCount(Map<String, String> searchMap) {

        int result = orderMapper.selectAvailableItemCount(searchMap);

        return result;
    }

    @Override
    public List<OrderDTO> selectAvailableItem(SelectCriteria selectCriteria) {

        return orderMapper.selectAvailableItem(selectCriteria);
    }

    @Override
    public int selectInterestItemCount(Map<String, String> searchMap) {

        int result = orderMapper.selectInterestItemCount(searchMap);

        return result;
    }


    @Override
    public List<OrderDTO> selectInterestItem(SelectCriteria selectCriteria) {

        return orderMapper.selectInterestItem(selectCriteria);

    }


    @Override
    @Transactional
    public int insertStoreOrderNo(CartDTO cart) {

        orderMapper.insertStoreOrderNo(cart);
        int orderNoResult = cart.getOrderNo();

        System.out.println("orderNoResult 서비스 제발 = " + orderNoResult);
        return orderNoResult;
    }

    @Override
    @Transactional
    public int insertOrderItems(CartDTO cart) {

        orderMapper.insertOrderItems(cart);
        int cartNoResult = cart.getCartNo();

        return cartNoResult;
    }


    @Override
    @Transactional
    public void insertOrderHandler(CartDTO cart) {

        orderMapper.insertOrderHandler(cart);

    }

    @Override
    @Transactional
    public void resetCartItems(CartDTO cart) {

        orderMapper.resetCartItems(cart);
    }


    @Override
    @Transactional
    public void deleteCartItem(CartDTO cart) {

        orderMapper.deleteCartItem(cart);
    }

    @Override
    public int selectOrderHistoryCount(Map<String, Object> searchMap) {

        int result = orderMapper.selectOrderHistoryCount(searchMap);

        return result;


    }

    @Override
    public List<OrderHistoryDTO> selectOrderHistory(SelectCriteria selectCriteria) {

        return orderMapper.selectOrderHistory(selectCriteria);

    }

    @Override
    public int insertStoreBreakdown(CartDTO cart) {

        return orderMapper.insertStoreBreakdown(cart);
    }

    @Override
    public int updateStoreBalance(CartDTO cart) {

        return orderMapper.updateStoreBalance(cart);
    }

    @Override
    public int selectCartAvailableItemCount(Map<String, String> searchMap) {

        return orderMapper.selectCartAvailableItemCount(searchMap);
    }

    @Override
    public List<OrderDTO> selectCartAvailableItem(SelectCriteria selectCriteria) {

        return orderMapper.selectCartAvailableItem(selectCriteria);
    }

    @Override
    public void cancelOrder(OrderHistoryDTO history) {

        orderMapper.cancelOrder(history);
    }

    @Override
    public String selectFinalOrderDate(OrderHistoryDTO history) {

        return orderMapper.selectFinalOrderDate(history);
    }

    @Override
    public int checkItemOverlap(CartDTO cart) {
        return orderMapper.checkItemOverlap(cart);
    }

    @Override
    public void insertItemIntoCart(CartDTO cart) {

        orderMapper.insertItemIntoCart(cart);
    }

    @Override
    public void updateItemIntoCart(CartDTO cart) {

        orderMapper.updateItemIntoCart(cart);
    }

    @Override
    public int checkBalance(CartDTO cart) {
        return orderMapper.checkBalance(cart);
    }


}