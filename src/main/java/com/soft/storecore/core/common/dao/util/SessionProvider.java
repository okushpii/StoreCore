package com.soft.storecore.core.common.dao.util;

import org.hibernate.Session;

public interface SessionProvider {

    Session getSession();
}
