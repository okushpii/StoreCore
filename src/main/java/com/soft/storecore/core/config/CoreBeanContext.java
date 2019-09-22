package com.soft.storecore.core.config;

import com.soft.storecore.core.sorting.pojo.SortingField;
import com.soft.storecore.core.sorting.pojo.SortingType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CoreBeanContext {

    @Bean
    public Map<SortingField, String> daoSortingFieldMap(){
        Map<SortingField, String> map = new HashMap<>();
        map.put(SortingField.PRICE, "p.price");
        map.put(SortingField.PLACEMENT_DATE, "p.placementDate");
        return map;
    }

    @Bean
    public Map<SortingType, String> daoSortingTypeMap(){
        Map<SortingType, String> map = new HashMap<>();
        map.put(SortingType.ASC, "ASC");
        map.put(SortingType.DESC, "DESC");
        return map;
    }
}
