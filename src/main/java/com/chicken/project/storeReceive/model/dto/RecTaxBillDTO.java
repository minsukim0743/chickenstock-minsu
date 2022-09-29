package com.chicken.project.storeReceive.model.dto;

import java.sql.Date;

public class RecTaxBillDTO {

    private int taxNo;
    private java.sql.Date taxDate;
    private String recCode;

    public RecTaxBillDTO() {
    }

    public RecTaxBillDTO(int taxNo, Date taxDate, String recCode) {
        this.taxNo = taxNo;
        this.taxDate = taxDate;
        this.recCode = recCode;
    }

    public int getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(int taxNo) {
        this.taxNo = taxNo;
    }

    public Date getTaxDate() {
        return taxDate;
    }

    public void setTaxDate(Date taxDate) {
        this.taxDate = taxDate;
    }

    public String getRecCode() {
        return recCode;
    }

    public void setRecCode(String recCode) {
        this.recCode = recCode;
    }

    @Override
    public String toString() {
        return "RecTaxBillDTO{" +
                "taxNo=" + taxNo +
                ", taxDate=" + taxDate +
                ", recCode='" + recCode + '\'' +
                '}';
    }
}
