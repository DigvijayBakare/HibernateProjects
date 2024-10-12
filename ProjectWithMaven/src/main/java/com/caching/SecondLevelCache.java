package com.caching;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCache {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session1 = factory.openSession();
        Student student1 = session1.get(Student.class, 125);
        System.out.println(student1);
        session1.close();

        Session session2 = factory.openSession();
        Student student2 = session2.get(Student.class, 125);
        System.out.println(student2);
        session2.close();

        // for every session it can provide the cache from the session factory object enabling the second level cache

        factory.close();
    }
}
