package co.com.ceiba.model.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import co.com.ceiba.model.Customer;

public class HibernateUtil {
    private static HibernateUtil instance = null;

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;

    private HibernateUtil() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}