package com.soft.storecore.facade.product.facade;

import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.product.service.ProductService;
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

    @Override
    public List<ProductData> findAllByCategoryId(Long categoryId) {
        return productService.findAllByCategoryId(categoryId).stream()
                .map(p -> productConverter.convert(p))
                .collect(Collectors.toList());
    }
}
