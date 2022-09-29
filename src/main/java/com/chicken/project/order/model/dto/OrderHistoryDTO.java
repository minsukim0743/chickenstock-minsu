package com.chicken.project.order.model.dto;


public class OrderHistoryDTO {

    private int itemNo;
    private int categoryNo;
    private int cartAmount;
    private String itemName;
    private String itemStandard;
    private String itemMake;
    private int itemSales;
    private String orderDate;
    private String cartYn;
    private int orderNo;
    private String storeName;
    private OrderItemFileDTO itemFile;
    private int cartNo;

    public OrderHistoryDTO() {
    }

    public OrderHistoryDTO(int itemNo, int categoryNo, int cartAmount, String itemName, String itemStandard, String itemMake, int itemSales, String orderDate, String cartYn, int orderNo, String storeName, OrderItemFileDTO itemFile, int cartNo) {
        this.itemNo = itemNo;
        this.categoryNo = categoryNo;
        this.cartAmount = cartAmount;
        this.itemName = itemName;
        this.itemStandard = itemStandard;
        this.itemMake = itemMake;
        this.itemSales = itemSales;
        this.orderDate = orderDate;
        this.cartYn = cartYn;
        this.orderNo = orderNo;
        this.storeName = storeName;
        this.itemFile = itemFile;
        this.cartNo = cartNo;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public int getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(int cartAmount) {
        this.cartAmount = cartAmount;
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCartYn() {
        return cartYn;
    }

    public void setCartYn(String cartYn) {
        this.cartYn = cartYn;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public OrderItemFileDTO getItemFile() {
        return itemFile;
    }

    public void setItemFile(OrderItemFileDTO itemFile) {
        this.itemFile = itemFile;
    }

    public int getCartNo() {
        return cartNo;
    }

    public void setCartNo(int cartNo) {
        this.cartNo = cartNo;
    }

    @Override
    public String toString() {
        return "OrderHistoryDTO{" +
                "itemNo=" + itemNo +
                ", categoryNo=" + categoryNo +
                ", cartAmount=" + cartAmount +
                ", itemName='" + itemName + '\'' +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemMake='" + itemMake + '\'' +
                ", itemSales=" + itemSales +
                ", orderDate='" + orderDate + '\'' +
                ", cartYn='" + cartYn + '\'' +
                ", orderNo=" + orderNo +
                ", storeName='" + storeName + '\'' +
                ", itemFile=" + itemFile +
                ", cartNo=" + cartNo +
                '}';
    }
}