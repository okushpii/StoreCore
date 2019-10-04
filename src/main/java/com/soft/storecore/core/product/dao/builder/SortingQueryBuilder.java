package com.soft.storecore.core.product.dao.builder;

import com.soft.storecore.core.common.dao.QueryBuilder;
import com.soft.storecore.core.sorting.pojo.SortingData;
import com.soft.storecore.core.sorting.pojo.SortingField;
import com.soft.storecore.core.sorting.pojo.SortingType;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

@Component
public class SortingQueryBuilder implements QueryBuilder<SortingData> {

    private static final String ORDER_APPENDER = "ORDER BY";
    private static final String SPACE = " ";

    @Resource
    private Map<SortingField, String> daoSortingFieldMap;
    @Resource
    private Map<SortingType, String> daoSortingTypeMap;

    @Override
    public String buildQuery(String baseQuery, SortingData sortingData) {

        if (Objects.isNull(sortingData)){
            return baseQuery;
        }
        String sortingField = daoSortingFieldMap.get(sortingData.getSortingField());
        String sortingType = daoSortingTypeMap.get(sortingData.getSortingType());

        return baseQuery + SPACE +
                ORDER_APPENDER +
                SPACE +
                sortingField +
                SPACE +
                sortingType;
    }
}
