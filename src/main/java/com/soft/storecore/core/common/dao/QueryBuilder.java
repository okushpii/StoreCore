package com.soft.storecore.core.common.dao;

public interface QueryBuilder<SOURCE> {

    String buildQuery(String baseQuery, SOURCE source);
}
