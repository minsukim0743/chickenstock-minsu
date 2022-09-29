package com.chicken.project.receive.model.dto;

public class ReceiveOfficeItemDTO {
    private String recCode;
    private int itemNo;
    private String itemName;
    private String categoryName;
    private String itemStandard;
    private String itemMake;
    private int recItemNo;
    private int recAmount;
    private String stringRecAmount; // 입고 수량
    private String itemPurchase; // 입고단가
    private String recMoney; // 입고금액
    private String stringRecDate; // 입고일

    private String fileName;

    public ReceiveOfficeItemDTO() {
    }

    public ReceiveOfficeItemDTO(String recCode, int itemNo, String itemName, String categoryName, String itemStandard, String itemMake, int recItemNo, int recAmount, String stringRecAmount, String itemPurchase, String recMoney, String stringRecDate, String fileName) {
        this.recCode = recCode;
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.categoryName = categoryName;
        this.itemStandard = itemStandard;
        this.itemMake = itemMake;
        this.recItemNo = recItemNo;
        this.recAmount = recAmount;
        this.stringRecAmount = stringRecAmount;
        this.itemPurchase = itemPurchase;
        this.recMoney = recMoney;
        this.stringRecDate = stringRecDate;
        this.fileName = fileName;
    }

    public String getRecCode() {
        return recCode;
    }

    public void setRecCode(String recCode) {
        this.recCode = recCode;
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

    public int getRecItemNo() {
        return recItemNo;
    }

    public void setRecItemNo(int recItemNo) {
        this.recItemNo = recItemNo;
    }

    public int getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(int recAmount) {
        this.recAmount = recAmount;
    }

    public String getStringRecAmount() {
        return stringRecAmount;
    }

    public void setStringRecAmount(String stringRecAmount) {
        this.stringRecAmount = stringRecAmount;
    }

    public String getItemPurchase() {
        return itemPurchase;
    }

    public void setItemPurchase(String itemPurchase) {
        this.itemPurchase = itemPurchase;
    }

    public String getRecMoney() {
        return recMoney;
    }

    public void setRecMoney(String recMoney) {
        this.recMoney = recMoney;
    }

    public String getStringRecDate() {
        return stringRecDate;
    }

    public void setStringRecDate(String stringRecDate) {
        this.stringRecDate = stringRecDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "ReceiveOfficeItemDTO{" +
                "recCode='" + recCode + '\'' +
                ", itemNo=" + itemNo +
                ", itemName='" + itemName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemMake='" + itemMake + '\'' +
                ", recItemNo=" + recItemNo +
                ", recAmount=" + recAmount +
                ", stringRecAmount='" + stringRecAmount + '\'' +
                ", itemPurchase='" + itemPurchase + '\'' +
                ", recMoney='" + recMoney + '\'' +
                ", stringRecDate='" + stringRecDate + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
