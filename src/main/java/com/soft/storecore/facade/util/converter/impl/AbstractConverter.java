package com.soft.storecore.facade.util.converter.impl;

import com.soft.storecore.facade.util.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<SOURCE, TARGET> implements Converter<SOURCE, TARGET> {

    @Override
    public List<TARGET> convertAll(List<SOURCE> sourceList) {
        return sourceList.stream().map(this::convert)
                .collect(Collectors.toList());
    }
}
