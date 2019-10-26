package com.soft.storecore.core.common.dao.builder;

import com.soft.storecore.core.common.dao.pojo.Query;

public interface QueryAppender<SOURCE> {

    Query appendQuery(Query baseQuery, SOURCE source);
}
