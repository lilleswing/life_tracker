package com.lilleswing.lifetracker.server.db.dao;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DaoProvider {

    private final AppUserDao appUserDao;

    @Inject
    public DaoProvider(final AppUserDao appUserDao) {
        this.appUserDao = appUserDao;
    }

    public AppUserDao getAppUserDao() {
        return appUserDao;
    }
}
