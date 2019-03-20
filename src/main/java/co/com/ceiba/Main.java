package co.com.ceiba;

import co.com.ceiba.model.util.HibernateUtil;
import co.com.ceiba.model.Customer;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        /* Creation of the statement instance */
        //DatabaseSingletonService.getInstance()

        Customer customer = new Customer(1, "Jorge", "Muñoz");

        HibernateUtil.getInstance();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(customer);

        session.getTransaction().commit();

        System.out.println("Connected: " + session.isConnected());
        System.out.println("Open: " + session.isOpen());

        session.close();
        System.out.println("Connected: " + session.isConnected());
        System.out.println("Open: " + session.isOpen());

    }

}