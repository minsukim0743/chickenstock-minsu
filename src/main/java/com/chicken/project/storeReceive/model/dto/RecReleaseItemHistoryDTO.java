package com.chicken.project.storeReceive.model.dto;

import java.sql.Date;

public class RecReleaseItemHistoryDTO {

    private int relAmountDetail;
    private java.sql.Date relDateDetail;
    private String relCodeDetail;

    public RecReleaseItemHistoryDTO() {
    }

    public RecReleaseItemHistoryDTO(int relAmountDetail, Date relDateDetail, String relCodeDetail) {
        this.relAmountDetail = relAmountDetail;
        this.relDateDetail = relDateDetail;
        this.relCodeDetail = relCodeDetail;
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

    public String getRelCodeDetail() {
        return relCodeDetail;
    }

    public void setRelCodeDetail(String relCodeDetail) {
        this.relCodeDetail = relCodeDetail;
    }

    @Override
    public String toString() {
        return "RecReleaseItemHistoryDTO{" +
                "relAmountDetail=" + relAmountDetail +
                ", relDateDetail=" + relDateDetail +
                ", relCodeDetail='" + relCodeDetail + '\'' +
                '}';
    }
}
