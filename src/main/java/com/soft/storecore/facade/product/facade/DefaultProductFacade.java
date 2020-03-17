package com.soft.storecore.facade.product.facade;

import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.product.service.ProductService;
import com.soft.storecore.core.sorting.entity.Sorting;
import com.soft.storecore.core.sorting.service.SortingService;
import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.util.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DefaultProductFacade implements ProductFacade {

    @Resource
    private ProductService productService;
    @Resource
    private Converter<Product, ProductData> productConverter;
    @Resource
    private SortingService sortingService;

    @Override
    public List<ProductData> findAllByCategory(String categoryCode, String sortingCode,
                                               int pageNumber, int pageSize) {
        Sorting sorting = sortingService.find(sortingCode).orElse(null);
        return productConverter.convertAll(productService
                .findAllByCategory(categoryCode, sorting, pageNumber, pageSize));
    }
}
