package com.soft.storecore.core.dao;

import org.hibernate.Session;

public interface SessionProvider {

    Session getSession();
}
