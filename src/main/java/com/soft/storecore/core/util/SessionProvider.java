package com.soft.storecore.core.util;

import org.hibernate.Session;

public interface SessionProvider {

    Session getSession();
}
