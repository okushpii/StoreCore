package com.soft.storecore.facade.impl;

import com.soft.storecore.facade.ProductFacade;
import com.soft.storecore.facade.converter.Converter;
import com.soft.storecore.facade.data.ProductData;
import com.soft.storecore.model.entity.Product;
import com.soft.storecore.model.service.ProductService;
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

    @Override
    public List<ProductData> findAllByCategoryId(Long categoryId) {
        return productService.findAllByCategoryId(categoryId).stream()
                .map(p -> productConverter.convert(p))
                .collect(Collectors.toList());
    }
}
