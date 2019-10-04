package com.soft.storecore.core.common.dao;

import org.hibernate.Session;

public interface SessionProvider {

    Session getSession();
}
