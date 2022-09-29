package com.chicken.project.release.model.dto;

public class ReleaseCartDTO {

    private int cartAmount;
    private int categoryNo;
    private int itemNo;
    private int cartNo;
    private String storeName;
    private String cartYn;
    private String relYn;

    public ReleaseCartDTO() {}

    public ReleaseCartDTO(int cartAmount, int categoryNo, int itemNo, int cartNo, String storeName, String cartYn, String relYn) {
        this.cartAmount = cartAmount;
        this.categoryNo = categoryNo;
        this.itemNo = itemNo;
        this.cartNo = cartNo;
        this.storeName = storeName;
        this.cartYn = cartYn;
        this.relYn = relYn;
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

    public String getRelYn() {
        return relYn;
    }

    public void setRelYn(String relYn) {
        this.relYn = relYn;
    }

    @Override
    public String toString() {
        return "ReleaseCartDTO{" +
                "cartAmount=" + cartAmount +
                ", categoryNo=" + categoryNo +
                ", itemNo=" + itemNo +
                ", cartNo=" + cartNo +
                ", storeName='" + storeName + '\'' +
                ", cartYn='" + cartYn + '\'' +
                ", relYn='" + relYn + '\'' +
                '}';
    }
}
