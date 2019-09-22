package com.soft.storecore.core.dao;

public interface QueryBuilder<SOURCE> {

    String buildQuery(String baseQuery, SOURCE source);
}
