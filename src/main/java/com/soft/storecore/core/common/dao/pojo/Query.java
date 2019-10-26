package com.soft.storecore.core.common.dao.pojo;

public class Query {

    private String query;
    private String alias;

    public Query(String query, String alias) {
        this.query = query;
        this.alias = alias;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
