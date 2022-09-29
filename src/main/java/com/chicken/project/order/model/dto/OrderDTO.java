package com.chicken.project.order.model.dto;


public class OrderDTO {

    /* ITEM_INFO, ITEM_FILE, ITEM_CATEGORY, STO_ITEM_INFO, INTEREST join */
    private int itemNo; //상품번호
    private String itemName; //상품명
    private int categoryNo; //카테고리 번호
    private String categoryName; //카테고리명
    private String itemStandard; //규격
    private String itemMake; //생산자
    private int itemSales; //가격
    private int storeAmount; //재고
    private int orderAmount; //주문량
    private String itemSoldoutYn; //품절여부
    private String interYn; //관심여부
    private String orderDate; //주문일
    private OrderItemFileDTO itemFile;
    private String storeName;
    private int cartAmount;

    public OrderDTO() {
    }

    public OrderDTO(int itemNo, String itemName, int categoryNo, String categoryName, String itemStandard, String itemMake, int itemSales, int storeAmount, int orderAmount, String itemSoldoutYn, String interYn, String orderDate, OrderItemFileDTO itemFile, String storeName, int cartAmount) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.categoryNo = categoryNo;
        this.categoryName = categoryName;
        this.itemStandard = itemStandard;
        this.itemMake = itemMake;
        this.itemSales = itemSales;
        this.storeAmount = storeAmount;
        this.orderAmount = orderAmount;
        this.itemSoldoutYn = itemSoldoutYn;
        this.interYn = interYn;
        this.orderDate = orderDate;
        this.itemFile = itemFile;
        this.storeName = storeName;
        this.cartAmount = cartAmount;
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

    public int getItemSales() {
        return itemSales;
    }

    public void setItemSales(int itemSales) {
        this.itemSales = itemSales;
    }

    public int getStoreAmount() {
        return storeAmount;
    }

    public void setStoreAmount(int storeAmount) {
        this.storeAmount = storeAmount;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getItemSoldoutYn() {
        return itemSoldoutYn;
    }

    public void setItemSoldoutYn(String itemSoldoutYn) {
        this.itemSoldoutYn = itemSoldoutYn;
    }

    public String getInterYn() {
        return interYn;
    }

    public void setInterYn(String interYn) {
        this.interYn = interYn;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public OrderItemFileDTO getItemFile() {
        return itemFile;
    }

    public void setItemFile(OrderItemFileDTO itemFile) {
        this.itemFile = itemFile;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(int cartAmount) {
        this.cartAmount = cartAmount;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "itemNo=" + itemNo +
                ", itemName='" + itemName + '\'' +
                ", categoryNo=" + categoryNo +
                ", categoryName='" + categoryName + '\'' +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemMake='" + itemMake + '\'' +
                ", itemSales=" + itemSales +
                ", storeAmount=" + storeAmount +
                ", orderAmount=" + orderAmount +
                ", itemSoldoutYn='" + itemSoldoutYn + '\'' +
                ", interYn='" + interYn + '\'' +
                ", orderDate=" + orderDate +
                ", itemFile=" + itemFile +
                ", storeName='" + storeName + '\'' +
                ", cartAmount=" + cartAmount +
                '}';
    }
}