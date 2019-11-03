package com.soft.storecore.facade.category.data;

import com.soft.storecore.core.category.entity.Category;

import java.util.List;

public class CategoryData {

    private String code;
    private String name;
    private Category superCategory;
    private List<CategoryData> childCategories;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getSuperCategory() {
        return superCategory;
    }

    public void setSuperCategory(Category superCategory) {
        this.superCategory = superCategory;
    }

    public List<CategoryData> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<CategoryData> childCategories) {
        this.childCategories = childCategories;
    }
}
