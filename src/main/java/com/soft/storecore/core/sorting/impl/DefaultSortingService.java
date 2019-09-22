package com.soft.storecore.core.sorting.impl;

import com.soft.storecore.core.sorting.SortingService;
import com.soft.storecore.core.sorting.pojo.SortingData;
import com.soft.storecore.core.sorting.pojo.SortingField;
import com.soft.storecore.core.sorting.pojo.SortingType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

//TODO create test
@Service
public class DefaultSortingService implements SortingService {

    @Resource
    private Map<String, SortingField> sortingFieldMap;

    @Resource
    private Map<String, SortingType> sortingTypeMap;

    @Override
    public SortingData getSorting(String sortingFieldKey, String sortingTypeFieldKey) {
        Optional<SortingField> sortingField = Optional.ofNullable(sortingFieldMap.get(sortingFieldKey));
        Optional<SortingType> sortingType = Optional.ofNullable(sortingTypeMap.get(sortingTypeFieldKey));
        return sortingField.flatMap(sf -> sortingType.map(st -> new SortingData(sf, st))).orElse(null);
    }

}
