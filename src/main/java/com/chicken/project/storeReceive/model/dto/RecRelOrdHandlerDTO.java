package com.chicken.project.storeReceive.model.dto;

public class RecRelOrdHandlerDTO {

    private int cartNo;
    private int relCodeDetail;

    public RecRelOrdHandlerDTO() {
    }

    public RecRelOrdHandlerDTO(int cartNo, int relCodeDetail) {
        this.cartNo = cartNo;
        this.relCodeDetail = relCodeDetail;
    }

    public int getCartNo() {
        return cartNo;
    }

    public void setCartNo(int cartNo) {
        this.cartNo = cartNo;
    }

    public int getRelCodeDetail() {
        return relCodeDetail;
    }

    public void setRelCodeDetail(int relCodeDetail) {
        this.relCodeDetail = relCodeDetail;
    }

    @Override
    public String toString() {
        return "RecRelOrdHandlerDTO{" +
                "cartNo=" + cartNo +
                ", relCodeDetail=" + relCodeDetail +
                '}';
    }
}
