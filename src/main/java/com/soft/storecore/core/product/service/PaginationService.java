package com.soft.storecore.core.product.service;

public interface PaginationService {

    int getStart(int pageNumber, int pageSize);

    int getPagesCount(int itemsCount, int pageSize);
}

