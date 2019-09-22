package com.soft.storecore.facade.config;

import com.soft.storecore.core.sorting.pojo.SortingField;
import com.soft.storecore.core.sorting.pojo.SortingType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class FacadesBeanContext {

    @Bean
    public Map<String, SortingField> sortingFieldMap(){
        Map<String, SortingField> sortingFieldMap = new HashMap<>();
        sortingFieldMap.put("price", SortingField.PRICE);
        sortingFieldMap.put("placementDate", SortingField.PLACEMENT_DATE);
        return sortingFieldMap;
    }

    @Bean
    public Map<String, SortingType> sortingTypeMap(){
        Map<String, SortingType> sortingTypeMap = new HashMap<>();
        sortingTypeMap.put("asc", SortingType.ASC);
        sortingTypeMap.put("desc", SortingType.DESC);
        return sortingTypeMap;
    }

}
