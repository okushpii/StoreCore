package com.soft.storecore.api.controller;

import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.category.facade.CategoryFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.NoSuchElementException;

import static com.soft.storecore.api.util.ApiConstants.FE_HTTP_URI;

@RestController
@RequestMapping("api/categories")
@CrossOrigin(origins = FE_HTTP_URI)
public class CategoryController {

    @Resource
    private CategoryFacade categoryFacade;

    @GetMapping
    public List<CategoryData> getCategories(){
        return categoryFacade.findAll();
    }

    @GetMapping("/{code}")
    public CategoryData getCategory(@PathVariable String code){
        return categoryFacade.find(code).orElseThrow();
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundExceptionHandler(NoSuchElementException ex) {
        return ex.getMessage();
    }
}
