package com.soft.storecore.facade.product.facade;

import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.product.service.ProductService;
import com.soft.storecore.core.sorting.SortingService;
import com.soft.storecore.core.sorting.pojo.SortingData;
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
    public List<ProductData> findAllByCategory(String categoryCode, String sortingFieldKey, String sortingTypeFieldKey) {
        SortingData sortingData = sortingService.getSorting(sortingFieldKey, sortingTypeFieldKey);
        return productConverter.convertAll(productService
                .findAllByCategory(categoryCode, sortingData));
    }
}
