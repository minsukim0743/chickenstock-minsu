package com.chicken.project.account.model.dto;

import java.sql.Date;

public class StoreBreakdownDTO {

    private String storeName;
    private String breakdownDate;
    private int withdrawal;
    private String content;

    public StoreBreakdownDTO() {}

    public StoreBreakdownDTO(String storeName, String breakdownDate, int withdrawal, String content) {
        this.storeName = storeName;
        this.breakdownDate = breakdownDate;
        this.withdrawal = withdrawal;
        this.content = content;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getBreakdownDate() {
        return breakdownDate;
    }

    public void setBreakdownDate(String breakdownDate) {
        this.breakdownDate = breakdownDate;
    }

    public int getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(int withdrawal) {
        this.withdrawal = withdrawal;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "StoreBreakdownDTO{" +
                "storeName='" + storeName + '\'' +
                ", breakdownDate='" + breakdownDate + '\'' +
                ", withdrawal=" + withdrawal +
                ", content='" + content + '\'' +
                '}';
    }
}
