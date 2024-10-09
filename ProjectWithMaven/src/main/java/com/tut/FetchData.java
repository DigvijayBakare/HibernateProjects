package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // get method -> getting student info
        Student student = (Student)session.get(Student.class, 106);
        System.out.println(student);

        // load method -> loading student address
        Address ad = (Address) session.load(Address.class, 1);
        System.out.println(ad.getAddressId() + " : " + ad.getStreet() + " : " + ad.getCity());

        session.close();
        sessionFactory.close();
    }
}
