package com.soft.storecore.facade.product.facade;

import com.soft.storecore.facade.product.data.ProductData;

import java.util.List;

public interface ProductFacade {

    List<ProductData> findAllByCategoryId(Long categoryId, String sortingFieldKey, String sortingTypeFieldKey);
}

