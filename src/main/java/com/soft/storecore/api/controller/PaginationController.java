package com.soft.storecore.api.controller;

import com.soft.storecore.core.product.service.PaginationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/pagination")
public class PaginationController {

    @Resource
    private PaginationService paginationService;

    @GetMapping
    public int getCountOfPages(@RequestParam(value = "itemsCount", defaultValue = "20") int itemsCount,
                                  @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        return paginationService.getPagesCount(itemsCount, pageSize);
    }

}
