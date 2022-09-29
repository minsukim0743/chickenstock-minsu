package com.chicken.project.item.model.dto;

public class ItemCategoryDTO {

    private int categoryNo;
    private String categoryName;
    private int preCategory;

    public ItemCategoryDTO() {
    }

    public ItemCategoryDTO(int categoryNo, String categoryName, int preCategory) {
        this.categoryNo = categoryNo;
        this.categoryName = categoryName;
        this.preCategory = preCategory;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getPreCategory() {
        return preCategory;
    }

    public void setPreCategory(int preCategory) {
        this.preCategory = preCategory;
    }

    @Override
    public String toString() {
        return "ItemCategoryDTO{" +
                "categoryNo=" + categoryNo +
                ", categoryName='" + categoryName + '\'' +
                ", preCategory=" + preCategory +
                '}';
    }
}
