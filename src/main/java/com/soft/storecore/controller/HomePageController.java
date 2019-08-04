package com.soft.storecore.controller;

import com.soft.storecore.facade.CategoryFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import static com.soft.storecore.controller.ControllerConstants.*;

@Controller
@RequestMapping(RequestMappings.HOME_PAGE)
public class HomePageController {

    @Resource
    private CategoryFacade categoryFacade;

    @GetMapping
    public String homePage(Model model){
        model.addAttribute(Attributes.CATEGORIES, categoryFacade.findAll());
        return Pages.HOME_PAGE;
    }
}
