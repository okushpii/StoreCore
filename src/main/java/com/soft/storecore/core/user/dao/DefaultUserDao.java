package com.soft.storecore.core.user.dao;

import com.soft.storecore.core.common.dao.util.SessionProvider;
import com.soft.storecore.core.user.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Optional;

@Repository
public class DefaultUserDao implements UserDao{

    private static final String FIND_BY_EMAIL_QUERY = "SELECT u FROM User u WHERE :email = u.email";

    @Resource
    private SessionProvider sessionProvider;

    @Override
    public void addUser(User user) {
        sessionProvider.getSession().save(user);
    }

    @Override
    public Optional<User> find(String email) {
        return Optional.ofNullable(sessionProvider.getSession().createQuery(FIND_BY_EMAIL_QUERY, User.class)
                .setParameter("email", email).uniqueResult());
    }
}
