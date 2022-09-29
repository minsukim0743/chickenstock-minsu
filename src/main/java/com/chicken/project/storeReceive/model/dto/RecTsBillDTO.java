package com.chicken.project.storeReceive.model.dto;

import java.sql.Date;

public class RecTsBillDTO {

    private int tsNo;
    private java.sql.Date tsTaxDate;
    private String recCode;

    public RecTsBillDTO() {
    }

    public RecTsBillDTO(int tsNo, Date tsTaxDate, String recCode) {
        this.tsNo = tsNo;
        this.tsTaxDate = tsTaxDate;
        this.recCode = recCode;
    }

    public int getTsNo() {
        return tsNo;
    }

    public void setTsNo(int tsNo) {
        this.tsNo = tsNo;
    }

    public Date getTsTaxDate() {
        return tsTaxDate;
    }

    public void setTsTaxDate(Date tsTaxDate) {
        this.tsTaxDate = tsTaxDate;
    }

    public String getRecCode() {
        return recCode;
    }

    public void setRecCode(String recCode) {
        this.recCode = recCode;
    }

    @Override
    public String toString() {
        return "RecTsBillDTO{" +
                "tsNo=" + tsNo +
                ", tsTaxDate=" + tsTaxDate +
                ", recCode='" + recCode + '\'' +
                '}';
    }
}
