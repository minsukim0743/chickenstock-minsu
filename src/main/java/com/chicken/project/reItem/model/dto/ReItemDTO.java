package com.chicken.project.reItem.model.dto;


public class ReItemDTO {

    private String rDate;  // 반품신청일
    private String rReason; // 반품사유
    private int returnTotalMoney; // 반품금액
    private int returnCount; // 반품수량
    private int itemNo; // 품목번호
    private String itemName; // 품목이름
    private String categoryName;  // 카테고리이름
    private String itemStandard; // 품목규격
    private String itemMake; // 제조사
    private String itemSales; // 매출단가
    private String fileName; //원본파일명
    private int rNo;   // 반품번호
    private int firstCount;  // 수정수량
    private int storeAmount; // 가맹점 픔목수량
    private int returnItemNo; // 가맹점 반품수량 고정번호
    private int total; // 수정된 반품 총 금액

    public ReItemDTO() {
    }

    public ReItemDTO(String rDate, String rReason, int returnTotalMoney, int returnCount, int itemNo, String itemName, String categoryName, String itemStandard, String itemMake, String itemSales, String fileName, int rNo, int firstCount, int storeAmount, int returnItemNo, int total) {
        this.rDate = rDate;
        this.rReason = rReason;
        this.returnTotalMoney = returnTotalMoney;
        this.returnCount = returnCount;
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.categoryName = categoryName;
        this.itemStandard = itemStandard;
        this.itemMake = itemMake;
        this.itemSales = itemSales;
        this.fileName = fileName;
        this.rNo = rNo;
        this.firstCount = firstCount;
        this.storeAmount = storeAmount;
        this.returnItemNo = returnItemNo;
        this.total = total;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public String getrReason() {
        return rReason;
    }

    public void setrReason(String rReason) {
        this.rReason = rReason;
    }

    public int getReturnTotalMoney() {
        return returnTotalMoney;
    }

    public void setReturnTotalMoney(int returnTotalMoney) {
        this.returnTotalMoney = returnTotalMoney;
    }

    public int getReturnCount() {
        return returnCount;
    }

    public void setReturnCount(int returnCount) {
        this.returnCount = returnCount;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getItemStandard() {
        return itemStandard;
    }

    public void setItemStandard(String itemStandard) {
        this.itemStandard = itemStandard;
    }

    public String getItemMake() {
        return itemMake;
    }

    public void setItemMake(String itemMake) {
        this.itemMake = itemMake;
    }

    public String getItemSales() {
        return itemSales;
    }

    public void setItemSales(String itemSales) {
        this.itemSales = itemSales;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getrNo() {
        return rNo;
    }

    public void setrNo(int rNo) {
        this.rNo = rNo;
    }

    public int getFirstCount() {
        return firstCount;
    }

    public void setFirstCount(int firstCount) {
        this.firstCount = firstCount;
    }

    public int getStoreAmount() {
        return storeAmount;
    }

    public void setStoreAmount(int storeAmount) {
        this.storeAmount = storeAmount;
    }

    public int getReturnItemNo() {
        return returnItemNo;
    }

    public void setReturnItemNo(int returnItemNo) {
        this.returnItemNo = returnItemNo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ReItemDTO{" +
                "rDate='" + rDate + '\'' +
                ", rReason='" + rReason + '\'' +
                ", returnTotalMoney=" + returnTotalMoney +
                ", returnCount=" + returnCount +
                ", itemNo=" + itemNo +
                ", itemName='" + itemName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemMake='" + itemMake + '\'' +
                ", itemSales='" + itemSales + '\'' +
                ", fileName='" + fileName + '\'' +
                ", rNo=" + rNo +
                ", firstCount=" + firstCount +
                ", storeAmount=" + storeAmount +
                ", returnItemNo=" + returnItemNo +
                ", total=" + total +
                '}';
    }
}
