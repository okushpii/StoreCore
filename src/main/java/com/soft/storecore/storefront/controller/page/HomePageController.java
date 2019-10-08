package com.soft.storecore.storefront.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.soft.storecore.storefront.config.StorefrontConstants.Pages;
import static com.soft.storecore.storefront.config.StorefrontConstants.RequestMappings;

@Controller
@RequestMapping(RequestMappings.HOME_PAGE)
public class HomePageController {

    @GetMapping
    public String homePage(Model model){
        return Pages.HOME_PAGE;
    }
}
