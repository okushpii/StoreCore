package com.soft.storecore.core.sorting.dao.builder;

import com.soft.storecore.core.common.dao.builder.QueryAppender;
import com.soft.storecore.core.common.dao.pojo.Query;
import com.soft.storecore.core.sorting.entity.Sorting;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SortingQueryAppender implements QueryAppender<Sorting> {

    private static final String ORDER_APPENDER = "ORDER BY";
    private static final String SPACE = " ";
    private static final String DOT = ".";


    @Override
    public Query appendQuery(Query baseQuery, Sorting sorting) {

        if (Objects.isNull(sorting)) {
            return baseQuery;
        }
        baseQuery.setQuery(build(baseQuery, sorting));
        return baseQuery;
    }

    private String build(Query baseQuery, Sorting sorting) {

        return baseQuery.getQuery() +
                SPACE +
                ORDER_APPENDER +
                SPACE +
                baseQuery.getAlias() +
                DOT +
                sorting.getField() +
                SPACE +
                sorting.getType();
    }
}
