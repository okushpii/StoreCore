package com.soft.storecore.facade.user.converter;

import com.soft.storecore.core.user.entity.User;
import com.soft.storecore.facade.user.data.UserData;
import com.soft.storecore.facade.util.converter.impl.AbstractConverter;
import com.soft.storecore.facade.util.populator.Populator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class UserReverseConverter extends AbstractConverter<UserData, User> {

    @Resource
    private Populator<UserData, User> userReversePopulator;

    @Override
    public User convert(UserData userData) {
        User user = new User();
        userReversePopulator.populate(userData, user);
        return user;
    }
}
