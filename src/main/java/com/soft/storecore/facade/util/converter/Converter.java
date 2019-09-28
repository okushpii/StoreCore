package com.soft.storecore.facade.util.converter;

import java.util.List;

public interface Converter<SOURCE, TARGET> extends BaseConverter<SOURCE, TARGET> {

    List<TARGET> convertAll(List<SOURCE> sourceList);
}
