package com.soft.storecore.core.pojo;

public class Sorting {

    private SortingField sortingField;
    private SortingType sortingType;

    public Sorting(SortingField sortingField, SortingType sortingType) {
        this.sortingField = sortingField;
        this.sortingType = sortingType;
    }

    public SortingField getSortingField() {
        return sortingField;
    }

    public void setSortingField(SortingField sortingField) {
        this.sortingField = sortingField;
    }

    public SortingType getSortingType() {
        return sortingType;
    }

    public void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }
}
