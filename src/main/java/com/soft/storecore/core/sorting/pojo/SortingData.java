package com.soft.storecore.core.sorting.pojo;

public class SortingData {

    private final SortingField sortingField;
    private final SortingType sortingType;

    public SortingData(SortingField sortingField, SortingType sortingType) {
        this.sortingField = sortingField;
        this.sortingType = sortingType;
    }

    public SortingField getSortingField() {
        return sortingField;
    }

    public SortingType getSortingType() {
        return sortingType;
    }
}
