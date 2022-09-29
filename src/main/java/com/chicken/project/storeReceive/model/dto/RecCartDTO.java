package com.chicken.project.storeReceive.model.dto;

public class RecCartDTO {

    private int cartAmount;
    private int categoryNo;
    private int itemNo;
    private int cartNo;
    private String storeName;
    private String cartYn;

    public RecCartDTO() {
    }

    public RecCartDTO(int cartAmount, int categoryNo, int itemNo, int cartNo, String storeName, String cartYn) {
        this.cartAmount = cartAmount;
        this.categoryNo = categoryNo;
        this.itemNo = itemNo;
        this.cartNo = cartNo;
        this.storeName = storeName;
        this.cartYn = cartYn;
    }

    public int getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(int cartAmount) {
        this.cartAmount = cartAmount;
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

    public int getCartNo() {
        return cartNo;
    }

    public void setCartNo(int cartNo) {
        this.cartNo = cartNo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCartYn() {
        return cartYn;
    }

    public void setCartYn(String cartYn) {
        this.cartYn = cartYn;
    }

    @Override
    public String toString() {
        return "RecCartDTO{" +
                "cartAmount=" + cartAmount +
                ", categoryNo=" + categoryNo +
                ", itemNo=" + itemNo +
                ", cartNo=" + cartNo +
                ", storeName='" + storeName + '\'' +
                ", cartYn='" + cartYn + '\'' +
                '}';
    }
}
