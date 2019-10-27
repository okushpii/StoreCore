package com.soft.storecore.core.sorting.entity;

import com.soft.storecore.core.common.entity.IndexedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Sorting extends IndexedEntity {

    @Column(nullable = false)
    private String sortingGroup;

    @Column(nullable = false)
    private String field;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String name;

    @Transient
    private boolean selected;

    public String getSortingGroup() {
        return sortingGroup;
    }

    public void setSortingGroup(String type_code) {
        this.sortingGroup = type_code;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
