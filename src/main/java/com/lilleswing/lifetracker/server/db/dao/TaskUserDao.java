package com.lilleswing.lifetracker.server.db.dao;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.lilleswing.lifetracker.server.db.model.AppUser;
import com.lilleswing.lifetracker.server.db.model.TaskUser;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

@Singleton
public class TaskUserDao implements Dao<TaskUser> {

    private final SessionFactory sessionFactory;

    @Inject
    public TaskUserDao(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<TaskUser> getAll() {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria criteria = session.createCriteria(TaskUser.class);
        return criteria.list();
    }

    public List<TaskUser> getForUser(final AppUser appUser) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria criteria = session.createCriteria(TaskUser.class);
        criteria.add(Restrictions.eq("appUser", appUser));
        return criteria.list();
    }

    @Override
    public TaskUser getById(final long id) {
        return (TaskUser) sessionFactory.getCurrentSession().get(TaskUser.class, id);
    }

    @Override
    public TaskUser add(final TaskUser taskUser) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
