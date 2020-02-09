package com.soft.storecore.facade.category.data;

import java.util.List;

public class CategoryData {

    private String code;
    private String name;
    private CategoryData superCategory;
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

    public CategoryData getSuperCategory() {
        return superCategory;
    }

    public void setSuperCategory(CategoryData superCategory) {
        this.superCategory = superCategory;
    }

    public List<CategoryData> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<CategoryData> childCategories) {
        this.childCategories = childCategories;
    }
}
