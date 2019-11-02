package com.soft.storecore.api.controller;

import com.soft.storecore.facade.user.data.UserData;
import com.soft.storecore.facade.user.facade.UserFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Resource
    private UserFacade userFacade;

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    public UserData addUser(@Valid @RequestBody UserData userData){
        userFacade.addUser(userData);
        return userData;
    }
}
