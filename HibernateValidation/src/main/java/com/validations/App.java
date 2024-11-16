package com.validations;

import com.validations.entity.Person;
import com.validations.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @Author - Digvijay Bakare
 **/

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Person person1 = new Person(1, "Shree Kapur", "kapur@gmail.com", "9874523610", "Delhi");

        // Get session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(person1);
        tx.commit();
        System.out.println("Person: " + person1);

        HibernateUtil.getSessionFactory().close();
    }
}
