package com.soft.storecore.facade.converter.impl;

import com.soft.storecore.facade.converter.Converter;
import com.soft.storecore.facade.data.ProductData;
import com.soft.storecore.facade.populator.Populator;
import com.soft.storecore.model.entity.Product;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ProductConverter implements Converter<Product, ProductData> {

    @Resource
    private Populator<Product, ProductData> productPopulator;

    @Override
    public ProductData convert(Product product) {
        ProductData productsData = new ProductData();
        productPopulator.populate(product, productsData);
        return productsData;
    }
}
