package com.tut;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.*;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Project Started...");

        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        // Alternative for creating sessionFactory object
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Creating student object
        Student st = new Student();
        st.setId(103);
        st.setName("Hemant");
        st.setCity("Pune");
//        System.out.println(st);

        // Creating object of address class
        Address ad = new Address();
        ad.setStreet("street6");
        ad.setCity("Lakhnow");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setxVar(10.10254);
//        ad.setImage();

        // Reading image
        FileInputStream fis = new FileInputStream(new File("D:\\Coding\\JAVA\\Codes\\ProjectWithMaven\\src\\main\\resources\\Shiva_resized.jpg"));
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);

        // Creating a session
        Session session = factory.openSession();
        session.beginTransaction();             // to begin the transactions in the database
//        session.save(st);                         // to save the data in the database
        session.save(ad);
        session.getTransaction().commit();      // to commit the changes in the physical database

        // Closing the session
        session.close();

        // Printing done statement
        System.out.println("Done.....");
    }
}
