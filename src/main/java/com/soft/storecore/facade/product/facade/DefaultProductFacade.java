package com.soft.storecore.facade.product.facade;

import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.product.service.ProductService;
import com.soft.storecore.core.service.SortingService;
import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.util.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultProductFacade implements ProductFacade {

    @Resource
    private ProductService productService;

    @Resource
    private Converter<Product, ProductData> productConverter;

    @Resource
    private SortingService sortingService;

    @Override
    public List<ProductData> findAllByCategoryId(Long categoryId, String sortingFieldKey, String sortingTypeFieldKey) {
        return sortingService.getSorting(sortingFieldKey, sortingTypeFieldKey)
                .map(s -> productService.findAllByCategoryId(categoryId, s))
                .orElse(productService.findAllByCategoryId(categoryId))
                .stream().map(p -> productConverter.convert(p))
                .collect(Collectors.toList());
    }
}
