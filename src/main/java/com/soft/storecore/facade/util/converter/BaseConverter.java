package com.soft.storecore.facade.util.converter;

public interface BaseConverter<SOURCE, TARGET> {

    TARGET convert(SOURCE source);
}
