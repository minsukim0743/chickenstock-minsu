package com.chicken.project.storeReceive.model.dto;

import com.chicken.project.item.model.dto.ItemCategoryDTO;
import com.chicken.project.item.model.dto.ItemFileDTO;
import com.chicken.project.item.model.dto.ItemInfoDTO;

import java.sql.Date;

public class RecStoreOrderDTO {

    private int orderNo;
    private java.sql.Date orderDate;
    private String orderCode;
    private String countOrderNo;
    private int rNum;


    public RecStoreOrderDTO() {
    }

    public RecStoreOrderDTO(int orderNo, Date orderDate, String orderCode, String countOrderNo, int rNum) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderCode = orderCode;
        this.countOrderNo = countOrderNo;
        this.rNum = rNum;
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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCountOrderNo() {
        return countOrderNo;
    }

    public void setCountOrderNo(String countOrderNo) {
        this.countOrderNo = countOrderNo;
    }

    public int getrNum() {
        return rNum;
    }

    public void setrNum(int rNum) {
        this.rNum = rNum;
    }

    @Override
    public String toString() {
        return "RecStoreOrderDTO{" +
                "orderNo=" + orderNo +
                ", orderDate=" + orderDate +
                ", orderCode='" + orderCode + '\'' +
                ", countOrderNo='" + countOrderNo + '\'' +
                ", rNum=" + rNum +
                '}';
    }
}
