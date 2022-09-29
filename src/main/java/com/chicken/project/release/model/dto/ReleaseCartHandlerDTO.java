package com.chicken.project.release.model.dto;

public class ReleaseCartHandlerDTO {

    private int cartNo;
    private int orderNo;

    public ReleaseCartHandlerDTO() {}

    public ReleaseCartHandlerDTO(int cartNo, int orderNo) {
        this.cartNo = cartNo;
        this.orderNo = orderNo;
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

    @Override
    public String toString() {
        return "ReleaseCartHandlerDTO{" +
                "cartNo=" + cartNo +
                ", orderNo=" + orderNo +
                '}';
    }
}
