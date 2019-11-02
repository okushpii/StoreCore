package com.soft.storecore.core.user.service;

import com.soft.storecore.core.user.dao.UserDao;
import com.soft.storecore.core.user.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DefaultUserService implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public boolean isExists(String email) {
        return userDao.find(email).isPresent();
    }
}
