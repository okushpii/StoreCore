package com.soft.storecore.facade.user.populator;

import com.soft.storecore.core.common.service.IdGenarationService;
import com.soft.storecore.core.user.entity.User;
import com.soft.storecore.facade.user.data.UserData;
import com.soft.storecore.facade.util.populator.Populator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserPopulator implements Populator<UserData, User> {

    @Resource
    private IdGenarationService idGenarationService;
    @Resource
    private PasswordEncoder bCryptPasswordEncoder;


    @Override
    public void populate(UserData userData, User user) {
       user.setCode(idGenarationService.generate());
       user.setFirstName(userData.getFirstName());
       user.setLastName(userData.getLastName());
       user.setEmail(userData.getEmail());
       user.setPassword(bCryptPasswordEncoder.encode(userData.getPassword()));
    }
}
