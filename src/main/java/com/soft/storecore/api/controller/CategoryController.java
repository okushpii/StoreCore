package com.soft.storecore.api.controller;

import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.category.facade.CategoryFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Resource
    private CategoryFacade categoryFacade;

    @GetMapping
    public List<CategoryData> getCategories(){
        return categoryFacade.findAll();
    }
}
