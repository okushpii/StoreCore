package com.soft.storecore.facade.product.converter;

import com.soft.storecore.core.entity.Product;
import com.soft.storecore.facade.core.converter.Converter;
import com.soft.storecore.facade.core.populator.Populator;
import com.soft.storecore.facade.product.data.ProductData;
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
