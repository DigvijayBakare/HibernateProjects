package com.caching;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCache {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // first level cached is by default enabled - always
        Student student = session.get(Student.class, 125);
        System.out.println(student);
        System.out.println("Working on something.....");

        Student student1 = session.get(Student.class, 125);
        System.out.println(student1);

        System.out.println("Is the student1 object available in the first level cache: "+session.contains(student1));

        session.close();

       /* Session session1 = factory.openSession();
        Student student2 = session1.get(Student.class, 125);
        System.out.println(student2);
        session1.close();
        // for other session it will fire a query again in the first level cache*/


        factory.close();
    }
}
