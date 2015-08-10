package com.lilleswing.lifetracker.server.db.dao;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DaoProvider {

    private final AppUserDao appUserDao;
    private final TaskDao taskDao;

    @Inject
    public DaoProvider(final AppUserDao appUserDao,
                       final TaskDao taskDao) {
        this.appUserDao = appUserDao;
        this.taskDao = taskDao;
    }

    public AppUserDao getAppUserDao() {
        return appUserDao;
    }

    public TaskDao getTaskDao() {
        return taskDao;
    }
}
