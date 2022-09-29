package com.chicken.project.storeReceive.model.dto;

import java.sql.Date;

public class ReceiveStoreDTO {

    private int orderNo;
    private String recCode;
    private int recTotalAmount;
    private java.sql.Date recDate;
    private String recStatus;
    private String storeName;
    private int recTotalMoney;
    private String orderCode;
    private int countRecCode;
    private int sumRecAmount;
    private int rNum;

    public ReceiveStoreDTO() {
    }

    public ReceiveStoreDTO(int orderNo, String recCode, int recTotalAmount, Date recDate, String recStatus, String storeName, int recTotalMoney, String orderCode, int countRecCode, int sumRecAmount, int rNum) {
        this.orderNo = orderNo;
        this.recCode = recCode;
        this.recTotalAmount = recTotalAmount;
        this.recDate = recDate;
        this.recStatus = recStatus;
        this.storeName = storeName;
        this.recTotalMoney = recTotalMoney;
        this.orderCode = orderCode;
        this.countRecCode = countRecCode;
        this.sumRecAmount = sumRecAmount;
        this.rNum = rNum;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getRecCode() {
        return recCode;
    }

    public void setRecCode(String recCode) {
        this.recCode = recCode;
    }

    public int getRecTotalAmount() {
        return recTotalAmount;
    }

    public void setRecTotalAmount(int recTotalAmount) {
        this.recTotalAmount = recTotalAmount;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public String getRecStatus() {
        return recStatus;
    }

    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getRecTotalMoney() {
        return recTotalMoney;
    }

    public void setRecTotalMoney(int recTotalMoney) {
        this.recTotalMoney = recTotalMoney;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getCountRecCode() {
        return countRecCode;
    }

    public void setCountRecCode(int countRecCode) {
        this.countRecCode = countRecCode;
    }

    public int getSumRecAmount() {
        return sumRecAmount;
    }

    public void setSumRecAmount(int sumRecAmount) {
        this.sumRecAmount = sumRecAmount;
    }

    public int getrNum() {
        return rNum;
    }

    public void setrNum(int rNum) {
        this.rNum = rNum;
    }

    @Override
    public String toString() {
        return "ReceiveStoreDTO{" +
                "orderNo=" + orderNo +
                ", recCode='" + recCode + '\'' +
                ", recTotalAmount=" + recTotalAmount +
                ", recDate=" + recDate +
                ", recStatus='" + recStatus + '\'' +
                ", storeName='" + storeName + '\'' +
                ", recTotalMoney=" + recTotalMoney +
                ", orderCode='" + orderCode + '\'' +
                ", countRecCode=" + countRecCode +
                ", sumRecAmount=" + sumRecAmount +
                ", rNum=" + rNum +
                '}';
    }
}
