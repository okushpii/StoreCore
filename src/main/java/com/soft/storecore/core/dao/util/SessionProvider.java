package com.soft.storecore.core.dao.util;

import org.hibernate.Session;

public interface SessionProvider {

    Session getSession();
}
