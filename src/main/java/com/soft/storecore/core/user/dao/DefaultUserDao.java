package com.soft.storecore.core.user.dao;

import com.soft.storecore.core.common.dao.util.SessionProvider;
import com.soft.storecore.core.user.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class DefaultUserDao implements UserDao{

    @Resource
    private SessionProvider sessionProvider;


    @Override
    public void addUser(User user) {
        sessionProvider.getSession().save(user);
    }
}
