package com.chicken.project.storeReceive.model.dto;

public class ReceiveStoreOrderDTO {

    private String relCode;
    private int orderNo;
    private String checkYn;
    private int storeOrderNum;

    public ReceiveStoreOrderDTO() {
    }

    public ReceiveStoreOrderDTO(String relCode, int orderNo, String checkYn, int storeOrderNum) {
        this.relCode = relCode;
        this.orderNo = orderNo;
        this.checkYn = checkYn;
        this.storeOrderNum = storeOrderNum;
    }

    public String getRelCode() {
        return relCode;
    }

    public void setRelCode(String relCode) {
        this.relCode = relCode;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getCheckYn() {
        return checkYn;
    }

    public void setCheckYn(String checkYn) {
        this.checkYn = checkYn;
    }

    public int getStoreOrderNum() {
        return storeOrderNum;
    }

    public void setStoreOrderNum(int storeOrderNum) {
        this.storeOrderNum = storeOrderNum;
    }

    @Override
    public String toString() {
        return "ReceiveStoreOrderDTO{" +
                "relCode='" + relCode + '\'' +
                ", orderNo=" + orderNo +
                ", checkYn='" + checkYn + '\'' +
                ", storeOrderNum=" + storeOrderNum +
                '}';
    }
}
