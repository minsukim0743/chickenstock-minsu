package com.chicken.project.storeReceive.model.dto;

public class RecOrderHandlerDTO {

    private int cartNo;
    private int orderNo;
    private int totalPrice;

    public RecOrderHandlerDTO() {
    }

    public RecOrderHandlerDTO(int cartNo, int orderNo, int totalPrice) {
        this.cartNo = cartNo;
        this.orderNo = orderNo;
        this.totalPrice = totalPrice;
    }

    public int getCartNo() {
        return cartNo;
    }

    public void setCartNo(int cartNo) {
        this.cartNo = cartNo;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "RecOrderHandlerDTO{" +
                "cartNo=" + cartNo +
                ", orderNo=" + orderNo +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
