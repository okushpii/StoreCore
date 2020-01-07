package com.soft.storecore.api.controller;

import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.product.facade.ProductFacade;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Resource
    private ProductFacade productFacade;

    @CrossOrigin
    @GetMapping("/c/{code}")
    public List<ProductData> findByCategory(@PathVariable("code") String categoryCode,
                                            @RequestParam(required = false) String sorting,
                                            @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
                                            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        return productFacade.findAllByCategory(categoryCode, sorting, pageNumber, pageSize);
    }
}
