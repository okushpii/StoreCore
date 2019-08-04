package com.soft.storecore.model.dao.util;

import org.hibernate.Session;

public interface SessionProvider {

    Session getSession();
}
