package com.chicken.project.storeReceive.model.dto;

public class ReceiveStoreItemDTO {

    private int recItemNo;
    private int itemNo;
    private String recCode;
    private int recAmount;
    private int recMoney;
    private int recSupply;
    private int recTax;

    public ReceiveStoreItemDTO() {
    }

    public ReceiveStoreItemDTO(int recItemNo, int itemNo, String recCode, int recAmount, int recMoney, int recSupply, int recTax) {
        this.recItemNo = recItemNo;
        this.itemNo = itemNo;
        this.recCode = recCode;
        this.recAmount = recAmount;
        this.recMoney = recMoney;
        this.recSupply = recSupply;
        this.recTax = recTax;
    }

    public int getRecItemNo() {
        return recItemNo;
    }

    public void setRecItemNo(int recItemNo) {
        this.recItemNo = recItemNo;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getRecCode() {
        return recCode;
    }

    public void setRecCode(String recCode) {
        this.recCode = recCode;
    }

    public int getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(int recAmount) {
        this.recAmount = recAmount;
    }

    public int getRecMoney() {
        return recMoney;
    }

    public void setRecMoney(int recMoney) {
        this.recMoney = recMoney;
    }

    public int getRecSupply() {
        return recSupply;
    }

    public void setRecSupply(int recSupply) {
        this.recSupply = recSupply;
    }

    public int getRecTax() {
        return recTax;
    }

    public void setRecTax(int recTax) {
        this.recTax = recTax;
    }

    @Override
    public String toString() {
        return "ReceiveStoreItemDTO{" +
                "recItemNo=" + recItemNo +
                ", itemNo=" + itemNo +
                ", recCode='" + recCode + '\'' +
                ", recAmount=" + recAmount +
                ", recMoney=" + recMoney +
                ", recSupply=" + recSupply +
                ", recTax=" + recTax +
                '}';
    }
}
