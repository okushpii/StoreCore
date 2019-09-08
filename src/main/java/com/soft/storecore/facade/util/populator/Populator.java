package com.soft.storecore.facade.util.populator;

public interface Populator<SOURCE, TARGET> {

    void populate(SOURCE source, TARGET target);
}
