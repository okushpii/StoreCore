package com.soft.storecore.core.category.entity;

import com.soft.storecore.core.common.entity.BaseEntity;
import com.soft.storecore.core.product.entity.Product;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category extends BaseEntity {

    @Column
    private String name;

    @ManyToOne
    @JoinColumn
    private Category superCategory;

    @OneToMany(mappedBy = "superCategory")
    private List<Category> childCategories;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

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

    public List<Category> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<Category> childCategories) {
        this.childCategories = childCategories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
