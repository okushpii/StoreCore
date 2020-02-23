package com.soft.storecore.api.controller;

import com.soft.storecore.facade.sorting.data.SortingData;
import com.soft.storecore.facade.sorting.facade.SortingFacade;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.soft.storecore.api.util.ApiConstants.FE_HTTP_URI;

@RestController
@RequestMapping("api/sortingList")
@CrossOrigin(origins = FE_HTTP_URI)
public class SortingListController {

    @Resource
    private SortingFacade sortingFacade;

    @GetMapping("/{group}")
    public List<SortingData> findSortingListByGroup(@PathVariable("group") String group) {
        return sortingFacade.find(group);
    }

}

