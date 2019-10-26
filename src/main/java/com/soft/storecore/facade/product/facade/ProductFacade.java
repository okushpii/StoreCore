package com.soft.storecore.facade.product.facade;

import com.soft.storecore.facade.product.data.ProductData;

import java.util.List;

public interface ProductFacade {

    List<ProductData> findAllByCategory(String categoryCode, String sorting);
}

