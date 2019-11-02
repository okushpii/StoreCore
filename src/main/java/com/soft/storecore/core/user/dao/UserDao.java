package com.soft.storecore.core.user.dao;

import com.soft.storecore.core.user.entity.User;

import java.util.Optional;

public interface UserDao {

    void addUser(User user);

    Optional<User> find(String email);
}
