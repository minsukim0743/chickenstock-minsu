package com.chicken.project.release.model.dto;

import java.sql.Date;

public class StoreOrderDTO {

    private int orderNo;
    private java.sql.Date orderDate;
    public StoreOrderDTO() {}

    public StoreOrderDTO(int orderNo, Date orderDate, int cartNo, String relYn) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "StoreOrderDTO{" +
                "orderNo=" + orderNo +
                ", orderDate=" + orderDate +
                '}';
    }
}
