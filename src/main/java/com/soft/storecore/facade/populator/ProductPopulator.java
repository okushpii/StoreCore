package com.soft.storecore.facade.populator;

import com.soft.storecore.core.entity.Product;
import com.soft.storecore.facade.data.ProductData;
import org.springframework.stereotype.Component;

@Component
public class ProductPopulator implements Populator<Product, ProductData> {

    @Override
    public void populate(Product product, ProductData productData) {
        productData.setId(product.getId());
        productData.setName(product.getName());
        productData.setPrice(product.getPrice());
        productData.setImageUrl(product.getImageUrl());
        productData.setDescription(product.getDescription());
        productData.setCategory(product.getCategory());
    }
}
