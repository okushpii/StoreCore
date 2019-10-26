package com.soft.storecore.storefront.controller.page;

import com.soft.storecore.facade.user.data.UserData;
import com.soft.storecore.facade.user.facade.UserFacade;
import com.soft.storecore.storefront.config.StorefrontConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import static com.soft.storecore.storefront.config.StorefrontConstants.Attributes.REDIRECT_PREFIX;
import static com.soft.storecore.storefront.config.StorefrontConstants.RequestMappings.REGISTRATION;

@Controller
@RequestMapping(REGISTRATION)
public class RegistrationPageController {

    @Resource
    private UserFacade userFacade;

    @GetMapping
    public String registration() {
        return StorefrontConstants.Pages.REGISTRATION_PAGE;
    }


    @PostMapping("add")
    public String addAccount(@ModelAttribute UserData userData) {
        userFacade.addUser(userData);
        return REDIRECT_PREFIX + REGISTRATION;
    }
}
