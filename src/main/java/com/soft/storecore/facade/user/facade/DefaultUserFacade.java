package com.soft.storecore.facade.user.facade;

import com.soft.storecore.core.user.entity.User;
import com.soft.storecore.core.user.service.UserService;
import com.soft.storecore.facade.user.data.UserData;
import com.soft.storecore.facade.util.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DefaultUserFacade implements UserFacade {

    @Resource
    private UserService userService;

    @Resource
    private Converter<UserData, User > userDataConverter;

    @Override
    public void addUser(UserData userData) {
        userService.addUser(userDataConverter.convert(userData));
    }

    @Override
    public boolean isUserExist(String email) {
        return userService.isExists(email);
    }
}
