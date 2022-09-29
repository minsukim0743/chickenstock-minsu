package com.chicken.project.release.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.util.List;

public class ReleaseDetailDTO {

    private int relAmount;
    private int itemNo;
    private int orderAmount;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private java.sql.Date relDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private java.sql.Date relItemRequestDate;
    private int totalMoney;
    private String itemName;
    private String itemStandard;
    private int itemPurchase;
    private int itemSales;
    private String itemMake;
    private int itemAmount;
    private String categoryName;
    private String fileName;
    private List<ReleaseItemHistroyDTO> releaseItemHistroyDTO;

    public ReleaseDetailDTO(){}

    public ReleaseDetailDTO(int relAmount, int itemNo, int orderAmount, Date relDate, Date relItemRequestDate, int totalMoney, String itemName, String itemStandard, int itemPurchase, int itemSales, String itemMake, int itemAmount, String categoryName, String fileName, List<ReleaseItemHistroyDTO> releaseItemHistroyDTO) {
        this.relAmount = relAmount;
        this.itemNo = itemNo;
        this.orderAmount = orderAmount;
        this.relDate = relDate;
        this.relItemRequestDate = relItemRequestDate;
        this.totalMoney = totalMoney;
        this.itemName = itemName;
        this.itemStandard = itemStandard;
        this.itemPurchase = itemPurchase;
        this.itemSales = itemSales;
        this.itemMake = itemMake;
        this.itemAmount = itemAmount;
        this.categoryName = categoryName;
        this.fileName = fileName;
        this.releaseItemHistroyDTO = releaseItemHistroyDTO;
    }

    public int getRelAmount() {
        return relAmount;
    }

    public void setRelAmount(int relAmount) {
        this.relAmount = relAmount;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getRelDate() {
        return relDate;
    }

    public void setRelDate(Date relDate) {
        this.relDate = relDate;
    }

    public Date getRelItemRequestDate() {
        return relItemRequestDate;
    }

    public void setRelItemRequestDate(Date relItemRequestDate) {
        this.relItemRequestDate = relItemRequestDate;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
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

    public String getItemMake() {
        return itemMake;
    }

    public void setItemMake(String itemMake) {
        this.itemMake = itemMake;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<ReleaseItemHistroyDTO> getReleaseItemHistroyDTO() {
        return releaseItemHistroyDTO;
    }

    public void setReleaseItemHistroyDTO(List<ReleaseItemHistroyDTO> releaseItemHistroyDTO) {
        this.releaseItemHistroyDTO = releaseItemHistroyDTO;
    }

    @Override
    public String toString() {
        return "ReleaseDetailDTO{" +
                "relAmount=" + relAmount +
                ", itemNo=" + itemNo +
                ", orderAmount=" + orderAmount +
                ", relDate=" + relDate +
                ", relItemRequestDate=" + relItemRequestDate +
                ", totalMoney=" + totalMoney +
                ", itemName='" + itemName + '\'' +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemPurchase=" + itemPurchase +
                ", itemSales=" + itemSales +
                ", itemMake='" + itemMake + '\'' +
                ", itemAmount=" + itemAmount +
                ", categoryName='" + categoryName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", releaseItemHistroyDTO=" + releaseItemHistroyDTO +
                '}';
    }
}
