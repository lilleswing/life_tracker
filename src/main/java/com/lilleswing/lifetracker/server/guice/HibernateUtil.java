package com.lilleswing.lifetracker.server.guice;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.lilleswing.lifetracker.server.db.model.AppUser;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@Singleton
public class HibernateUtil {

    private final SessionFactory sessionFactory;

    @Inject
    public HibernateUtil() {
        destroy();
        sessionFactory= buildSessionFactory();
    }


    private static SessionFactory buildSessionFactory() {
        try {
            final Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(AppUser.class);
            cfg.configure();
            final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties()).build();
            return cfg.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private void destroy() {
    }
}
