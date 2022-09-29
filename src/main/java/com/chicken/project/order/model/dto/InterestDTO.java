package com.chicken.project.order.model.dto;

public class InterestDTO {

    private int interNo;
    private String storeName;
    private int categoryNo;
    private int itemNo;

    public InterestDTO() {
    }

    public InterestDTO(int interNo, String storeName, int categoryNo, int itemNo) {
        this.interNo = interNo;
        this.storeName = storeName;
        this.categoryNo = categoryNo;
        this.itemNo = itemNo;
    }


    public int getInterNo() {
        return interNo;
    }

    public void setInterNo(int interNo) {
        this.interNo = interNo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    @Override
    public String toString() {
        return "InterestDTO{" +
                ", interNo=" + interNo +
                ", storeName='" + storeName + '\'' +
                ", categoryNo=" + categoryNo +
                ", itemNo=" + itemNo +
                '}';
    }
}
