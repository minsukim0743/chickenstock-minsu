package com.chicken.project.reItem.model.dto;

public class ReListDTO {

    private int rNo;                    // 반품서 번호
    private String rDate;               // 반품신청일
    private String returnProgress;      // 반품신청상태
    private String rDoneDate;           // 반품 완료일
    private String storeName;           // 가맹점 이름
    private String storeRep;            // 가맹점주 이름
    private String rProgress;           // 반품진행상태
    private String empId;               // 본사직원 아이디

    public ReListDTO() {
    }

    public ReListDTO(int rNo, String rDate, String returnProgress, String rDoneDate, String storeName, String storeRep, String rProgress, String empId) {
        this.rNo = rNo;
        this.rDate = rDate;
        this.returnProgress = returnProgress;
        this.rDoneDate = rDoneDate;
        this.storeName = storeName;
        this.storeRep = storeRep;
        this.rProgress = rProgress;
        this.empId = empId;
    }

    public int getrNo() {
        return rNo;
    }

    public void setrNo(int rNo) {
        this.rNo = rNo;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public String getReturnProgress() {
        return returnProgress;
    }

    public void setReturnProgress(String returnProgress) {
        this.returnProgress = returnProgress;
    }

    public String getrDoneDate() {
        return rDoneDate;
    }

    public void setrDoneDate(String rDoneDate) {
        this.rDoneDate = rDoneDate;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreRep() {
        return storeRep;
    }

    public void setStoreRep(String storeRep) {
        this.storeRep = storeRep;
    }

    public String getrProgress() {
        return rProgress;
    }

    public void setrProgress(String rProgress) {
        this.rProgress = rProgress;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "ReListDTO{" +
                "rNo=" + rNo +
                ", rDate='" + rDate + '\'' +
                ", returnProgress='" + returnProgress + '\'' +
                ", rDoneDate='" + rDoneDate + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeRep='" + storeRep + '\'' +
                ", rProgress='" + rProgress + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }
}
