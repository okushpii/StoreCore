package com.soft.storecore.facade.product.converter;

import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.util.converter.impl.AbstractConverter;
import com.soft.storecore.facade.util.populator.Populator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ProductConverter extends AbstractConverter<Product, ProductData> {

    @Resource
    private Populator<Product, ProductData> productPopulator;

    @Override
    public ProductData convert(Product product) {
        ProductData productsData = new ProductData();
        productPopulator.populate(product, productsData);
        return productsData;
    }
}
