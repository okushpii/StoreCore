package com.soft.storecore.core.product.service;

import com.soft.storecore.core.product.dao.ProductDao;
import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.sorting.entity.Sorting;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DefaultProductService implements ProductService {

    @Resource
    private ProductDao productDao;
    @Resource
    private PaginationService paginationService;


    @Override
    public List<Product> findAllByCategory(String categoryCode, Sorting sorting,
                                           int pageNumber, int pageSize) {
        return productDao.findAllByCategory(categoryCode, sorting,
                paginationService.getStart(pageNumber, pageSize), pageSize);
    }
}
