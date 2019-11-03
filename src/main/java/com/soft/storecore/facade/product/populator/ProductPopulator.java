package com.soft.storecore.facade.product.populator;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.util.converter.Converter;
import com.soft.storecore.facade.util.populator.Populator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ProductPopulator implements Populator<Product, ProductData> {

    @Resource
    private Converter<Category, CategoryData> categoryConverter;

    @Override
    public void populate(Product product, ProductData productData) {
        productData.setCode(product.getCode());
        productData.setName(product.getName());
        productData.setPrice(product.getPrice());
        productData.setImageCode(product.getImageCode());
        productData.setDescription(product.getDescription());
        productData.setCategory(categoryConverter.convert(product.getCategory()));
    }
}
