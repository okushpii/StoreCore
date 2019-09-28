package com.soft.storecore.storefront.breadcrumb.pojo;

public class Breadcrumb {

    private String name;
    private String url;
    private boolean isLast;

    public Breadcrumb(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }
}
