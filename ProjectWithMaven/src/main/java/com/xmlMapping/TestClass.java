package com.xmlMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Person person = new Person(1, "Savi", "Mumbai", "9876543210");

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(person);

        tx.commit();
        session.close();
        factory.close();
    }
}
