package com.soft.storecore.facade.util.converter;

public interface Converter<SOURCE, TARGET> {

    TARGET convert(SOURCE source);
}
