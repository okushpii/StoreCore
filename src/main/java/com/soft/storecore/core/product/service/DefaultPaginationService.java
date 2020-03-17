package com.soft.storecore.core.product.service;

import org.springframework.stereotype.Service;

@Service
public class DefaultPaginationService implements PaginationService {

    @Override
    public int getStart(int pageNumber, int pageSize) {
        return (pageNumber-1) * pageSize;
    }
}
