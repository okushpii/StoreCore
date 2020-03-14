package com.soft.storecore.api.controller;

import com.soft.storecore.facade.sorting.data.SortingData;
import com.soft.storecore.facade.sorting.facade.SortingFacade;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.soft.storecore.api.util.ApiConstants.FE_HTTP_URI;

@RestController
@RequestMapping("api/sorting")
@CrossOrigin(origins = FE_HTTP_URI)
public class SortingController {

    @Resource
    private SortingFacade sortingFacade;

    @GetMapping("/group/{groupCode}")
    public List<SortingData> findSortingListByGroup(@PathVariable("groupCode") String groupCode) {
        return sortingFacade.find(groupCode);
    }

}

