package com.soft.storecore.facade.converter;

public interface Converter<SOURCE, TARGET> {

    TARGET convert(SOURCE source);
}
