package com.chicken.project.order.model.dto;

public class OrderItemFileDTO {

    private int fileNo;
    private String originName;
    private String fileName;
    private int itemNo;

    public OrderItemFileDTO() {
    }

    public OrderItemFileDTO(int fileNo, String originName, String fileName, int itemNo) {
        this.fileNo = fileNo;
        this.originName = originName;
        this.fileName = fileName;
        this.itemNo = itemNo;
    }

    public int getFileNo() {
        return fileNo;
    }

    public void setFileNo(int fileNo) {
        this.fileNo = fileNo;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    @Override
    public String toString() {
        return "OrderItemFileDTO{" +
                "fileNo=" + fileNo +
                ", originName='" + originName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", itemNo=" + itemNo +
                '}';
    }
}