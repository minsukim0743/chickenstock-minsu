package com.chicken.project.release.model.dto;

public class ReleaseItemFileDTO {

    private int fileNo;
    private String originName;
    private String fileName;
    private int categoryNo;
    private int itemNo;

    public ReleaseItemFileDTO() {
    }

    public ReleaseItemFileDTO(int fileNo, String originName, String fileName, int categoryNo, int itemNo) {
        this.fileNo = fileNo;
        this.originName = originName;
        this.fileName = fileName;
        this.categoryNo = categoryNo;
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

    @Override
    public String toString() {
        return "ItemFileDTO{" +
                "fileNo=" + fileNo +
                ", originName='" + originName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", categoryNo=" + categoryNo +
                ", itemNo=" + itemNo +
                '}';
    }
}
