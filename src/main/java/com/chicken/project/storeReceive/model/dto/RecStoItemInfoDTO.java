package com.chicken.project.storeReceive.model.dto;

public class RecStoItemInfoDTO {

    private int itemNo;
    private int categoryNo;
    private int storeAmount;
    private String storeName;
    private String storeAccount;

    public RecStoItemInfoDTO(int itemNo, int categoryNo, int storeAmount, String storeName, String storeAccount) {
        this.itemNo = itemNo;
        this.categoryNo = categoryNo;
        this.storeAmount = storeAmount;
        this.storeName = storeName;
        this.storeAccount = storeAccount;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public int getStoreAmount() {
        return storeAmount;
    }

    public void setStoreAmount(int storeAmount) {
        this.storeAmount = storeAmount;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAccount() {
        return storeAccount;
    }

    public void setStoreAccount(String storeAccount) {
        this.storeAccount = storeAccount;
    }

    @Override
    public String toString() {
        return "RecStoItemInfoDTO{" +
                "itemNo=" + itemNo +
                ", categoryNo=" + categoryNo +
                ", storeAmount=" + storeAmount +
                ", storeName='" + storeName + '\'' +
                ", storeAccount='" + storeAccount + '\'' +
                '}';
    }
}
