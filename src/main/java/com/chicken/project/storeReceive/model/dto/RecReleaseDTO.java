package com.chicken.project.storeReceive.model.dto;

import java.sql.Date;
import java.util.List;

public class RecReleaseDTO {

    private String relCode;
    private String relName;
    private java.sql.Date relDate;
    private String relYn;
    private String storeName;
    private String totalMoney;
    private java.sql.Date relListDate;

    private String orderNo;
    private String orderCode;
    private int rNum;
    private String recCode;
    private int recAmount;
    private int recTotalMoney;
    private java.sql.Date orderDate;
    private java.sql.Date recDate;
    private List<RecReleaseItemDTO> recReleaseItem;
    private List< ReceiveStoreDTO> receiveStore;

    private List<RecStoreOrderDTO> recStoreOrder;

    public RecReleaseDTO() {
    }

    public RecReleaseDTO(String relCode, String relName, Date relDate, String relYn, String storeName, String totalMoney, Date relListDate, String orderNo, String orderCode, int rNum, String recCode, int recAmount, int recTotalMoney, Date orderDate, Date recDate, List<RecReleaseItemDTO> recReleaseItem, List<ReceiveStoreDTO> receiveStore, List<RecStoreOrderDTO> recStoreOrder) {
        this.relCode = relCode;
        this.relName = relName;
        this.relDate = relDate;
        this.relYn = relYn;
        this.storeName = storeName;
        this.totalMoney = totalMoney;
        this.relListDate = relListDate;
        this.orderNo = orderNo;
        this.orderCode = orderCode;
        this.rNum = rNum;
        this.recCode = recCode;
        this.recAmount = recAmount;
        this.recTotalMoney = recTotalMoney;
        this.orderDate = orderDate;
        this.recDate = recDate;
        this.recReleaseItem = recReleaseItem;
        this.receiveStore = receiveStore;
        this.recStoreOrder = recStoreOrder;
    }

    public String getRelCode() {
        return relCode;
    }

    public void setRelCode(String relCode) {
        this.relCode = relCode;
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
    }

    public Date getRelDate() {
        return relDate;
    }

    public void setRelDate(Date relDate) {
        this.relDate = relDate;
    }

    public String getRelYn() {
        return relYn;
    }

    public void setRelYn(String relYn) {
        this.relYn = relYn;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getRelListDate() {
        return relListDate;
    }

    public void setRelListDate(Date relListDate) {
        this.relListDate = relListDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getrNum() {
        return rNum;
    }

    public void setrNum(int rNum) {
        this.rNum = rNum;
    }

    public String getRecCode() {
        return recCode;
    }

    public void setRecCode(String recCode) {
        this.recCode = recCode;
    }

    public int getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(int recAmount) {
        this.recAmount = recAmount;
    }

    public int getRecTotalMoney() {
        return recTotalMoney;
    }

    public void setRecTotalMoney(int recTotalMoney) {
        this.recTotalMoney = recTotalMoney;
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

    public List<RecReleaseItemDTO> getRecReleaseItem() {
        return recReleaseItem;
    }

    public void setRecReleaseItem(List<RecReleaseItemDTO> recReleaseItem) {
        this.recReleaseItem = recReleaseItem;
    }

    public List<ReceiveStoreDTO> getReceiveStore() {
        return receiveStore;
    }

    public void setReceiveStore(List<ReceiveStoreDTO> receiveStore) {
        this.receiveStore = receiveStore;
    }

    public List<RecStoreOrderDTO> getRecStoreOrder() {
        return recStoreOrder;
    }

    public void setRecStoreOrder(List<RecStoreOrderDTO> recStoreOrder) {
        this.recStoreOrder = recStoreOrder;
    }

    @Override
    public String toString() {
        return "RecReleaseDTO{" +
                "relCode='" + relCode + '\'' +
                ", relName='" + relName + '\'' +
                ", relDate=" + relDate +
                ", relYn='" + relYn + '\'' +
                ", storeName='" + storeName + '\'' +
                ", totalMoney='" + totalMoney + '\'' +
                ", relListDate=" + relListDate +
                ", orderNo='" + orderNo + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", rNum=" + rNum +
                ", recCode='" + recCode + '\'' +
                ", recAmount=" + recAmount +
                ", recTotalMoney=" + recTotalMoney +
                ", orderDate=" + orderDate +
                ", recDate=" + recDate +
                ", recReleaseItem=" + recReleaseItem +
                ", receiveStore=" + receiveStore +
                ", recStoreOrder=" + recStoreOrder +
                '}';
    }
}
