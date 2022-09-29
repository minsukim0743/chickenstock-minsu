package com.chicken.project.release.model.dto;

import org.springframework.web.bind.annotation.RequestParam;

public class RelItemDTO {

    private String itemAmount;
    private String orderAmount;
    private String itemNo;
    private String relCode;
    private String relCodeDetail;
    private String relSumAmount;
    private String relAmountInput;
    private String relAmount;

    public RelItemDTO(String itemAmount, String orderAmount, String itemNo, String relCode, String relCodeDetail, String relSumAmount, String relAmountInput, String relAmount) {
        this.itemAmount = itemAmount;
        this.orderAmount = orderAmount;
        this.itemNo = itemNo;
        this.relCode = relCode;
        this.relCodeDetail = relCodeDetail;
        this.relSumAmount = relSumAmount;
        this.relAmountInput = relAmountInput;
        this.relAmount = relAmount;
    }

    public String getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(String itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getRelCode() {
        return relCode;
    }

    public void setRelCode(String relCode) {
        this.relCode = relCode;
    }

    public String getRelCodeDetail() {
        return relCodeDetail;
    }

    public void setRelCodeDetail(String relCodeDetail) {
        this.relCodeDetail = relCodeDetail;
    }

    public String getRelSumAmount() {
        return relSumAmount;
    }

    public void setRelSumAmount(String relSumAmount) {
        this.relSumAmount = relSumAmount;
    }

    public String getRelAmountInput() {
        return relAmountInput;
    }

    public void setRelAmountInput(String relAmountInput) {
        this.relAmountInput = relAmountInput;
    }

    public String getRelAmount() {
        return relAmount;
    }

    public void setRelAmount(String relAmount) {
        this.relAmount = relAmount;
    }

    @Override
    public String toString() {
        return "RelItemDTO{" +
                "itemAmount='" + itemAmount + '\'' +
                ", orderAmount='" + orderAmount + '\'' +
                ", itemNo='" + itemNo + '\'' +
                ", relCode='" + relCode + '\'' +
                ", relCodeDetail='" + relCodeDetail + '\'' +
                ", relSumAmount='" + relSumAmount + '\'' +
                ", relAmountInput='" + relAmountInput + '\'' +
                ", relAmount='" + relAmount + '\'' +
                '}';
    }
}
