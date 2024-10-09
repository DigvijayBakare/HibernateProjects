package com.state;

import com.tut.Certificate;
import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ObjStates {
    public static void main(String[] args) {
        // Hibernate Object States
        System.out.println("Example: ");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // Creating student object
        Student student = new Student();
        student.setId(127);
        student.setName("Tukaram Bahir");
        student.setCity("Bid");
        student.setCertificate(new Certificate("Full Stack", "5 months"));
        // Student : Transient

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        // Student : Persistence -session and database

        tx.commit();
        session.close();

        // Student : Detached
//        student.setName("ASD");
//        System.out.println(student);
        factory.close();
    }
}
