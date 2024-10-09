package com.tut;
// Embedded demo class

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        Student student1 = new Student();
        student1.setId(123);
        student1.setName("Ankit Tiwari");
        student1.setCity("Delhi");

        Certificate certi = new Certificate();
        certi.setCourse("Android");
        certi.setDuration("2 months");
        student1.setCertificate(certi);

        Student student2 = new Student();
        student2.setId(456);
        student2.setName("Ravi Tiwari");
        student2.setCity("Agra");

        Certificate certi1 = new Certificate();
        certi1.setCourse("Hibernate");
        certi1.setDuration("2.5 months");
        student2.setCertificate(certi1);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);

        tx.commit();
        session.close();
        factory.close();

    }
}
