package com.lilleswing.lifetracker.server.db.dao;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DaoProvider {

    private final AppUserDao appUserDao;
    private final TaskDao taskDao;
    private final TaskUserDao taskUserDao;

    @Inject
    public DaoProvider(final AppUserDao appUserDao,
                       final TaskDao taskDao,
                       final TaskUserDao taskUserDao) {
        this.appUserDao = appUserDao;
        this.taskDao = taskDao;
        this.taskUserDao = taskUserDao;
    }

    public AppUserDao getAppUserDao() {
        return appUserDao;
    }

    public TaskDao getTaskDao() {
        return taskDao;
    }

    public TaskUserDao getTaskUserDao() {
        return taskUserDao;
    }
}
