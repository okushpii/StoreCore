package com.soft.storecore.facade.core.converter;

public interface Converter<SOURCE, TARGET> {

    TARGET convert(SOURCE source);
}
