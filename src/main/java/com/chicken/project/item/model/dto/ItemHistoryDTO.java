package com.chicken.project.item.model.dto;

public class ItemHistoryDTO {

    private int itemManageNo;
    private String recCode;
    private String empId;
    private int categoryNo;
    private int itemNo;
    private int orderNo;
    private String relCode;

    public ItemHistoryDTO() {
    }

    public ItemHistoryDTO(int itemManageNo, String recCode, String empId, int categoryNo, int itemNo, int orderNo, String relCode) {
        this.itemManageNo = itemManageNo;
        this.recCode = recCode;
        this.empId = empId;
        this.categoryNo = categoryNo;
        this.itemNo = itemNo;
        this.orderNo = orderNo;
        this.relCode = relCode;
    }

    public int getItemManageNo() {
        return itemManageNo;
    }

    public void setItemManageNo(int itemManageNo) {
        this.itemManageNo = itemManageNo;
    }

    public String getRecCode() {
        return recCode;
    }

    public void setRecCode(String recCode) {
        this.recCode = recCode;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getRelCode() {
        return relCode;
    }

    public void setRelCode(String relCode) {
        this.relCode = relCode;
    }

    @Override
    public String toString() {
        return "ItemHistoryDTO{" +
                "itemManageNo=" + itemManageNo +
                ", recCode='" + recCode + '\'' +
                ", empId='" + empId + '\'' +
                ", categoryNo=" + categoryNo +
                ", itemNo=" + itemNo +
                ", orderNo=" + orderNo +
                ", relCode='" + relCode + '\'' +
                '}';
    }
}
