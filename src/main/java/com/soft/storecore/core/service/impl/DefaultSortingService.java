package com.soft.storecore.core.service.impl;

import com.soft.storecore.core.pojo.Sorting;
import com.soft.storecore.core.pojo.SortingField;
import com.soft.storecore.core.pojo.SortingType;
import com.soft.storecore.core.service.SortingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

@Service
public class DefaultSortingService implements SortingService {

    @Resource
    private Map<String, SortingField> sortingFieldMap;

    @Resource
    private Map<String, SortingType> sortingTypeMap;

    @Override
    public Optional<Sorting> getSorting(String sortingFieldKey, String sortingTypeFieldKey) {
        Optional<SortingField> sortingField = Optional.ofNullable(sortingFieldMap.get(sortingFieldKey));
        Optional<SortingType> sortingType = Optional.ofNullable(sortingTypeMap.get(sortingTypeFieldKey));
        return sortingField.flatMap(sf -> sortingType.map(st -> new Sorting(sf, st)));
    }

}
