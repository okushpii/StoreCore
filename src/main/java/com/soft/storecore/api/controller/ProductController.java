package com.soft.storecore.api.controller;

import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.product.facade.ProductFacade;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.soft.storecore.api.util.ApiConstants.FE_HTTP_URI;

@RestController
@RequestMapping("api/products")
@CrossOrigin(origins = FE_HTTP_URI)
public class ProductController {

    @Resource
    private ProductFacade productFacade;

    @GetMapping("/c/{code}")
    public List<ProductData> findByCategory(@PathVariable("code") String categoryCode,
                                            @RequestParam(required = false) String sorting){
        return productFacade.findAllByCategory(categoryCode, sorting);
    }
}
