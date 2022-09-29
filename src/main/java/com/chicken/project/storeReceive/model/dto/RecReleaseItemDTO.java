package com.chicken.project.storeReceive.model.dto;

import com.chicken.project.item.model.dto.ItemCategoryDTO;
import com.chicken.project.item.model.dto.ItemFileDTO;
import com.chicken.project.item.model.dto.ItemInfoDTO;

import java.sql.Date;

public class RecReleaseItemDTO {

    private String relYn;
    private int relAmount;
    private String relCode;
    private int itemNo;
    private int orderAmount;
    private java.sql.Date relDate;
    private java.sql.Date relItemRequestDate;
    private String storeName;
    private int totalMoney;
    private int orderNo;
    private int relCodeDetail;
    private String relListYn;
    private String orderCode;
    private String recCode;
    private String fileName;
    private String itemName;
    private String categoryName;
    private String itemStandard;
    private String itemMake;
    private int recAmount;
    private int itemSales;
    private int recMoney;
    private java.sql.Date orderDate;
    private java.sql.Date recDate;
    private ItemInfoDTO itemInfo;
    private ItemCategoryDTO itemCategory;
    private ItemFileDTO itemFile;
    private RecStoreOrderDTO recStoreOrder;
    private RecReleaseItemHistoryDTO recReleaseItemHistory;
    private ReceiveStoreDTO receiveStore;
    private ReceiveStoreItemDTO receiveStoreItem;

    public RecReleaseItemDTO() {
    }

    public RecReleaseItemDTO(String relYn, int relAmount, String relCode, int itemNo, int orderAmount, Date relDate, Date relItemRequestDate, String storeName, int totalMoney, int orderNo, int relCodeDetail, String relListYn, String orderCode, String recCode, String fileName, String itemName, String categoryName, String itemStandard, String itemMake, int recAmount, int itemSales, int recMoney, Date orderDate, Date recDate, ItemInfoDTO itemInfo, ItemCategoryDTO itemCategory, ItemFileDTO itemFile, RecStoreOrderDTO recStoreOrder, RecReleaseItemHistoryDTO recReleaseItemHistory, ReceiveStoreDTO receiveStore, ReceiveStoreItemDTO receiveStoreItem) {
        this.relYn = relYn;
        this.relAmount = relAmount;
        this.relCode = relCode;
        this.itemNo = itemNo;
        this.orderAmount = orderAmount;
        this.relDate = relDate;
        this.relItemRequestDate = relItemRequestDate;
        this.storeName = storeName;
        this.totalMoney = totalMoney;
        this.orderNo = orderNo;
        this.relCodeDetail = relCodeDetail;
        this.relListYn = relListYn;
        this.orderCode = orderCode;
        this.recCode = recCode;
        this.fileName = fileName;
        this.itemName = itemName;
        this.categoryName = categoryName;
        this.itemStandard = itemStandard;
        this.itemMake = itemMake;
        this.recAmount = recAmount;
        this.itemSales = itemSales;
        this.recMoney = recMoney;
        this.orderDate = orderDate;
        this.recDate = recDate;
        this.itemInfo = itemInfo;
        this.itemCategory = itemCategory;
        this.itemFile = itemFile;
        this.recStoreOrder = recStoreOrder;
        this.recReleaseItemHistory = recReleaseItemHistory;
        this.receiveStore = receiveStore;
        this.receiveStoreItem = receiveStoreItem;
    }

    public String getRelYn() {
        return relYn;
    }

    public void setRelYn(String relYn) {
        this.relYn = relYn;
    }

    public int getRelAmount() {
        return relAmount;
    }

    public void setRelAmount(int relAmount) {
        this.relAmount = relAmount;
    }

    public String getRelCode() {
        return relCode;
    }

    public void setRelCode(String relCode) {
        this.relCode = relCode;
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getRelCodeDetail() {
        return relCodeDetail;
    }

    public void setRelCodeDetail(int relCodeDetail) {
        this.relCodeDetail = relCodeDetail;
    }

    public String getRelListYn() {
        return relListYn;
    }

    public void setRelListYn(String relListYn) {
        this.relListYn = relListYn;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getRecCode() {
        return recCode;
    }

    public void setRecCode(String recCode) {
        this.recCode = recCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public int getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(int recAmount) {
        this.recAmount = recAmount;
    }

    public int getItemSales() {
        return itemSales;
    }

    public void setItemSales(int itemSales) {
        this.itemSales = itemSales;
    }

    public int getRecMoney() {
        return recMoney;
    }

    public void setRecMoney(int recMoney) {
        this.recMoney = recMoney;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public ItemInfoDTO getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(ItemInfoDTO itemInfo) {
        this.itemInfo = itemInfo;
    }

    public ItemCategoryDTO getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategoryDTO itemCategory) {
        this.itemCategory = itemCategory;
    }

    public ItemFileDTO getItemFile() {
        return itemFile;
    }

    public void setItemFile(ItemFileDTO itemFile) {
        this.itemFile = itemFile;
    }

    public RecStoreOrderDTO getRecStoreOrder() {
        return recStoreOrder;
    }

    public void setRecStoreOrder(RecStoreOrderDTO recStoreOrder) {
        this.recStoreOrder = recStoreOrder;
    }

    public RecReleaseItemHistoryDTO getRecReleaseItemHistory() {
        return recReleaseItemHistory;
    }

    public void setRecReleaseItemHistory(RecReleaseItemHistoryDTO recReleaseItemHistory) {
        this.recReleaseItemHistory = recReleaseItemHistory;
    }

    public ReceiveStoreDTO getReceiveStore() {
        return receiveStore;
    }

    public void setReceiveStore(ReceiveStoreDTO receiveStore) {
        this.receiveStore = receiveStore;
    }

    public ReceiveStoreItemDTO getReceiveStoreItem() {
        return receiveStoreItem;
    }

    public void setReceiveStoreItem(ReceiveStoreItemDTO receiveStoreItem) {
        this.receiveStoreItem = receiveStoreItem;
    }

    @Override
    public String toString() {
        return "RecReleaseItemDTO{" +
                "relYn='" + relYn + '\'' +
                ", relAmount=" + relAmount +
                ", relCode='" + relCode + '\'' +
                ", itemNo=" + itemNo +
                ", orderAmount=" + orderAmount +
                ", relDate=" + relDate +
                ", relItemRequestDate=" + relItemRequestDate +
                ", storeName='" + storeName + '\'' +
                ", totalMoney=" + totalMoney +
                ", orderNo=" + orderNo +
                ", relCodeDetail=" + relCodeDetail +
                ", relListYn='" + relListYn + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", recCode='" + recCode + '\'' +
                ", fileName='" + fileName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemMake='" + itemMake + '\'' +
                ", recAmount=" + recAmount +
                ", itemSales=" + itemSales +
                ", recMoney=" + recMoney +
                ", orderDate=" + orderDate +
                ", recDate=" + recDate +
                ", itemInfo=" + itemInfo +
                ", itemCategory=" + itemCategory +
                ", itemFile=" + itemFile +
                ", recStoreOrder=" + recStoreOrder +
                ", recReleaseItemHistory=" + recReleaseItemHistory +
                ", receiveStore=" + receiveStore +
                ", receiveStoreItem=" + receiveStoreItem +
                '}';
    }
}
