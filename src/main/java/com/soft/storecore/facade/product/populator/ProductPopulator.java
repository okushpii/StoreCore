package com.soft.storecore.facade.product.populator;

import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.util.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class ProductPopulator implements Populator<Product, ProductData> {

    @Override
    public void populate(Product product, ProductData productData) {
        productData.setCode(product.getCode());
        productData.setName(product.getName());
        productData.setPrice(product.getPrice());
        productData.setImageUrl(product.getImageUrl());
        productData.setDescription(product.getDescription());
        productData.setCategory(product.getCategory());
    }
}
