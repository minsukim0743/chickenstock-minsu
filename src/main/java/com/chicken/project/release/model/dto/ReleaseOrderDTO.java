package com.chicken.project.release.model.dto;

import java.sql.Date;

public class ReleaseOrderDTO {


    private ReleaseItemInfoDTO releaseItemInfoDTO;
    private ReleaseItemCategoryDTO releaseItemCategoryDTO;
    private ReleaseCartDTO releaseCartDTO;
    private ReleaseItemFileDTO releaseItemFileDTO;
    private StoreOrderDTO storeOrderDTO;
    private ReleaseCartHandlerDTO releaseCartHandlerDTO;
    private ReleaseItemDTO releaseItemDTO;
    private ReleaseItemHistroyDTO releaseItemHistroyDTO;

    public ReleaseOrderDTO() {}

    public ReleaseOrderDTO(ReleaseItemInfoDTO releaseItemInfoDTO, ReleaseItemCategoryDTO releaseItemCategoryDTO, ReleaseCartDTO releaseCartDTO, ReleaseItemFileDTO releaseItemFileDTO, StoreOrderDTO storeOrderDTO, ReleaseCartHandlerDTO releaseCartHandlerDTO, ReleaseItemDTO releaseItemDTO, ReleaseItemHistroyDTO releaseItemHistroyDTO) {
        this.releaseItemInfoDTO = releaseItemInfoDTO;
        this.releaseItemCategoryDTO = releaseItemCategoryDTO;
        this.releaseCartDTO = releaseCartDTO;
        this.releaseItemFileDTO = releaseItemFileDTO;
        this.storeOrderDTO = storeOrderDTO;
        this.releaseCartHandlerDTO = releaseCartHandlerDTO;
        this.releaseItemDTO = releaseItemDTO;
        this.releaseItemHistroyDTO = releaseItemHistroyDTO;
    }

    public ReleaseItemInfoDTO getReleaseItemInfoDTO() {
        return releaseItemInfoDTO;
    }

    public void setReleaseItemInfoDTO(ReleaseItemInfoDTO releaseItemInfoDTO) {
        this.releaseItemInfoDTO = releaseItemInfoDTO;
    }

    public ReleaseItemCategoryDTO getReleaseItemCategoryDTO() {
        return releaseItemCategoryDTO;
    }

    public void setReleaseItemCategoryDTO(ReleaseItemCategoryDTO releaseItemCategoryDTO) {
        this.releaseItemCategoryDTO = releaseItemCategoryDTO;
    }

    public ReleaseCartDTO getReleaseCartDTO() {
        return releaseCartDTO;
    }

    public void setReleaseCartDTO(ReleaseCartDTO releaseCartDTO) {
        this.releaseCartDTO = releaseCartDTO;
    }

    public ReleaseItemFileDTO getReleaseItemFileDTO() {
        return releaseItemFileDTO;
    }

    public void setReleaseItemFileDTO(ReleaseItemFileDTO releaseItemFileDTO) {
        this.releaseItemFileDTO = releaseItemFileDTO;
    }

    public StoreOrderDTO getStoreOrderDTO() {
        return storeOrderDTO;
    }

    public void setStoreOrderDTO(StoreOrderDTO storeOrderDTO) {
        this.storeOrderDTO = storeOrderDTO;
    }

    public ReleaseCartHandlerDTO getReleaseCartHandlerDTO() {
        return releaseCartHandlerDTO;
    }

    public void setReleaseCartHandlerDTO(ReleaseCartHandlerDTO releaseCartHandlerDTO) {
        this.releaseCartHandlerDTO = releaseCartHandlerDTO;
    }

    public ReleaseItemDTO getReleaseItemDTO() {
        return releaseItemDTO;
    }

    public void setReleaseItemDTO(ReleaseItemDTO releaseItemDTO) {
        this.releaseItemDTO = releaseItemDTO;
    }

    public ReleaseItemHistroyDTO getReleaseItemHistroyDTO() {
        return releaseItemHistroyDTO;
    }

    public void setReleaseItemHistroyDTO(ReleaseItemHistroyDTO releaseItemHistroyDTO) {
        this.releaseItemHistroyDTO = releaseItemHistroyDTO;
    }

    @Override
    public String toString() {
        return "ReleaseOrderDTO{" +
                "releaseItemInfoDTO=" + releaseItemInfoDTO +
                ", releaseItemCategoryDTO=" + releaseItemCategoryDTO +
                ", releaseCartDTO=" + releaseCartDTO +
                ", releaseItemFileDTO=" + releaseItemFileDTO +
                ", storeOrderDTO=" + storeOrderDTO +
                ", releaseCartHandlerDTO=" + releaseCartHandlerDTO +
                ", releaseItemDTO=" + releaseItemDTO +
                ", releaseItemHistroyDTO=" + releaseItemHistroyDTO +
                '}';
    }
}
