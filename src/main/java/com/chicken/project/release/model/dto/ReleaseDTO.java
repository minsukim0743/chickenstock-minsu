package com.chicken.project.release.model.dto;

import java.sql.Date;

public class ReleaseDTO {

    private int relCode;
    private String relName;
    private java.sql.Date relDate;
    private String relYn;
    private String storeName;
    private int totalMoney;
    private java.sql.Date relListDate;

    public ReleaseDTO() {}

    public ReleaseDTO(int relCode, String relName, Date relDate, String relYn, String storeName, int totalMoney, Date relListDate) {
        this.relCode = relCode;
        this.relName = relName;
        this.relDate = relDate;
        this.relYn = relYn;
        this.storeName = storeName;
        this.totalMoney = totalMoney;
        this.relListDate = relListDate;
    }

    public int getRelCode() {
        return relCode;
    }

    public void setRelCode(int relCode) {
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

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getRelListDate() {
        return relListDate;
    }

    public void setRelListDate(Date relListDate) {
        this.relListDate = relListDate;
    }

    @Override
    public String toString() {
        return "ReleaseDTO{" +
                "relCode=" + relCode +
                ", relName='" + relName + '\'' +
                ", relDate=" + relDate +
                ", relYn='" + relYn + '\'' +
                ", storeName='" + storeName + '\'' +
                ", totalMoney=" + totalMoney +
                ", relListDate=" + relListDate +
                '}';
    }
}
