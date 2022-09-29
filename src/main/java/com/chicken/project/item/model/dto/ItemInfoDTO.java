package com.chicken.project.item.model.dto;

import java.sql.Date;

public class ItemInfoDTO {

    private int itemNo;
    private String itemName;
    private String itemStandard;
    private int itemPurchase;
    private int itemSales;
    private String itemSoldoutYn;
    private String itemMake;
    private int categoryNo;
    private String categoryName;
    private int preCategory;
    private int itemAmount;
    private java.sql.Date itemDate;
    private String fileName;
    private String soldout;
    private int rNum;
    private String itemDeleteYn;
    private ItemFileDTO itemFile;
    private ItemCategoryDTO itemCategory;

    public ItemInfoDTO() {
    }

    public ItemInfoDTO(int itemNo, String itemName, String itemStandard, int itemPurchase, int itemSales, String itemSoldoutYn, String itemMake, int categoryNo, String categoryName, int preCategory, int itemAmount, Date itemDate, String fileName, String soldout, int rNum, String itemDeleteYn, ItemFileDTO itemFile, ItemCategoryDTO itemCategory) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemStandard = itemStandard;
        this.itemPurchase = itemPurchase;
        this.itemSales = itemSales;
        this.itemSoldoutYn = itemSoldoutYn;
        this.itemMake = itemMake;
        this.categoryNo = categoryNo;
        this.categoryName = categoryName;
        this.preCategory = preCategory;
        this.itemAmount = itemAmount;
        this.itemDate = itemDate;
        this.fileName = fileName;
        this.soldout = soldout;
        this.rNum = rNum;
        this.itemDeleteYn = itemDeleteYn;
        this.itemFile = itemFile;
        this.itemCategory = itemCategory;
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

    public String getItemStandard() {
        return itemStandard;
    }

    public void setItemStandard(String itemStandard) {
        this.itemStandard = itemStandard;
    }

    public int getItemPurchase() {
        return itemPurchase;
    }

    public void setItemPurchase(int itemPurchase) {
        this.itemPurchase = itemPurchase;
    }

    public int getItemSales() {
        return itemSales;
    }

    public void setItemSales(int itemSales) {
        this.itemSales = itemSales;
    }

    public String getItemSoldoutYn() {
        return itemSoldoutYn;
    }

    public void setItemSoldoutYn(String itemSoldoutYn) {
        this.itemSoldoutYn = itemSoldoutYn;
    }

    public String getItemMake() {
        return itemMake;
    }

    public void setItemMake(String itemMake) {
        this.itemMake = itemMake;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getPreCategory() {
        return preCategory;
    }

    public void setPreCategory(int preCategory) {
        this.preCategory = preCategory;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public Date getItemDate() {
        return itemDate;
    }

    public void setItemDate(Date itemDate) {
        this.itemDate = itemDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSoldout() {
        return soldout;
    }

    public void setSoldout(String soldout) {
        this.soldout = soldout;
    }

    public int getrNum() {
        return rNum;
    }

    public void setrNum(int rNum) {
        this.rNum = rNum;
    }

    public String getItemDeleteYn() {
        return itemDeleteYn;
    }

    public void setItemDeleteYn(String itemDeleteYn) {
        this.itemDeleteYn = itemDeleteYn;
    }

    public ItemFileDTO getItemFile() {
        return itemFile;
    }

    public void setItemFile(ItemFileDTO itemFile) {
        this.itemFile = itemFile;
    }

    public ItemCategoryDTO getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategoryDTO itemCategory) {
        this.itemCategory = itemCategory;
    }

    @Override
    public String toString() {
        return "ItemInfoDTO{" +
                "itemNo=" + itemNo +
                ", itemName='" + itemName + '\'' +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemPurchase=" + itemPurchase +
                ", itemSales=" + itemSales +
                ", itemSoldoutYn='" + itemSoldoutYn + '\'' +
                ", itemMake='" + itemMake + '\'' +
                ", categoryNo=" + categoryNo +
                ", categoryName='" + categoryName + '\'' +
                ", preCategory=" + preCategory +
                ", itemAmount=" + itemAmount +
                ", itemDate=" + itemDate +
                ", fileName='" + fileName + '\'' +
                ", soldout='" + soldout + '\'' +
                ", rNum=" + rNum +
                ", itemDeleteYn='" + itemDeleteYn + '\'' +
                ", itemFile=" + itemFile +
                ", itemCategory=" + itemCategory +
                '}';
    }
}