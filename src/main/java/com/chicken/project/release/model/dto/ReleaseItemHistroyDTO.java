package com.chicken.project.release.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class ReleaseItemHistroyDTO {

    private int relAmountDetail;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private java.sql.Date relDateDetail;
    private int relCodeDetail;
    private int relSumAmount;

    private ReleaseItemHistroyDTO(){};

    public ReleaseItemHistroyDTO(int relAmountDetail, Date relDateDetail, int relCodeDetail, int relSumAmount) {
        this.relAmountDetail = relAmountDetail;
        this.relDateDetail = relDateDetail;
        this.relCodeDetail = relCodeDetail;
        this.relSumAmount = relSumAmount;
    }

    public int getRelAmountDetail() {
        return relAmountDetail;
    }

    public void setRelAmountDetail(int relAmountDetail) {
        this.relAmountDetail = relAmountDetail;
    }

    public Date getRelDateDetail() {
        return relDateDetail;
    }

    public void setRelDateDetail(Date relDateDetail) {
        this.relDateDetail = relDateDetail;
    }

    public int getRelCodeDetail() {
        return relCodeDetail;
    }

    public void setRelCodeDetail(int relCodeDetail) {
        this.relCodeDetail = relCodeDetail;
    }

    public int getRelSumAmount() {
        return relSumAmount;
    }

    public void setRelSumAmount(int relSumAmount) {
        this.relSumAmount = relSumAmount;
    }

    @Override
    public String toString() {
        return "ReleaseItemHistroyDTO{" +
                "relAmountDetail=" + relAmountDetail +
                ", relDateDetail=" + relDateDetail +
                ", relCodeDetail=" + relCodeDetail +
                ", relSumAmount=" + relSumAmount +
                '}';
    }
}
