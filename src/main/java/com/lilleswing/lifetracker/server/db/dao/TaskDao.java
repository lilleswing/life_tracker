package com.lilleswing.lifetracker.server.db.dao;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.lilleswing.lifetracker.server.db.model.Task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Singleton
public class TaskDao implements Dao<Task> {

    private final SessionFactory sessionFactory;

    @Inject
    public TaskDao(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<? extends Task> getAll() {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria criteria = session.createCriteria(Task.class);
        return criteria.list();
    }

    @Override
    public Task getById(long id) {
        return (Task) sessionFactory.getCurrentSession().get(Task.class, id);
    }

    @Override
    public Task add(Task task) {
        return null;
    }
}
