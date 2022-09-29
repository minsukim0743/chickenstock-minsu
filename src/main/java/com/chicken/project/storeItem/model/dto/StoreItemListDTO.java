package com.chicken.project.storeItem.model.dto;

import com.chicken.project.item.model.dto.ItemCategoryDTO;
import com.chicken.project.item.model.dto.ItemFileDTO;
import com.chicken.project.item.model.dto.ItemInfoDTO;

public class StoreItemListDTO {

    private int storeName;
    private int storeAmount;
    private String storeAccount;
    private int itemNo;
    private int categoryNo;
    private ItemInfoDTO itemInfoDTO;
    private ItemCategoryDTO itemCategoryDTO;
    private ItemFileDTO itemFileDTO;

    public StoreItemListDTO(){}

    public StoreItemListDTO(int storeName, int storeAmount, String storeAccount, int itemNo, int categoryNo, ItemInfoDTO itemInfoDTO, ItemCategoryDTO itemCategoryDTO, ItemFileDTO itemFileDTO) {
        this.storeName = storeName;
        this.storeAmount = storeAmount;
        this.storeAccount = storeAccount;
        this.itemNo = itemNo;
        this.categoryNo = categoryNo;
        this.itemInfoDTO = itemInfoDTO;
        this.itemCategoryDTO = itemCategoryDTO;
        this.itemFileDTO = itemFileDTO;
    }

    public int getStoreName() {
        return storeName;
    }

    public void setStoreName(int storeName) {
        this.storeName = storeName;
    }

    public int getStoreAmount() {
        return storeAmount;
    }

    public void setStoreAmount(int storeAmount) {
        this.storeAmount = storeAmount;
    }

    public String getStoreAccount() {
        return storeAccount;
    }

    public void setStoreAccount(String storeAccount) {
        this.storeAccount = storeAccount;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public ItemInfoDTO getItemInfoDTO() {
        return itemInfoDTO;
    }

    public void setItemInfoDTO(ItemInfoDTO itemInfoDTO) {
        this.itemInfoDTO = itemInfoDTO;
    }

    public ItemCategoryDTO getItemCategoryDTO() {
        return itemCategoryDTO;
    }

    public void setItemCategoryDTO(ItemCategoryDTO itemCategoryDTO) {
        this.itemCategoryDTO = itemCategoryDTO;
    }

    public ItemFileDTO getItemFileDTO() {
        return itemFileDTO;
    }

    public void setItemFileDTO(ItemFileDTO itemFileDTO) {
        this.itemFileDTO = itemFileDTO;
    }

    @Override
    public String toString() {
        return "StoreItemListDTO{" +
                "storeName=" + storeName +
                ", storeAmount=" + storeAmount +
                ", storeAccount='" + storeAccount + '\'' +
                ", itemNo=" + itemNo +
                ", categoryNo=" + categoryNo +
                ", itemInfoDTO=" + itemInfoDTO +
                ", itemCategoryDTO=" + itemCategoryDTO +
                ", itemFileDTO=" + itemFileDTO +
                '}';
    }
}
