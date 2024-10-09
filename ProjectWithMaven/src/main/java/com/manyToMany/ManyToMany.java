package com.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class ManyToMany {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        // creating employee objects
        Employee e1 = new Employee();
        Employee e2 = new Employee();

        e1.seteId(101);
        e1.seteName("Ram");
        e2.seteId(105);
        e2.seteName("Sham");

        // creating projects object
        Project p1 = new Project();
        Project p2 = new Project();

        p1.setpId(201);
        p1.setpName("Library Management System");
        p2.setpId(205);
        p2.setpName("CHATBOT");

        // creating list objects
        ArrayList<Employee> list1 = new ArrayList<>();
        ArrayList<Project> list2 = new ArrayList<>();

        list1.add(e1);
        list1.add(e2);
        list2.add(p1);
        list2.add(p2);

        e1.setProjectList(list2);
        p1.setEmpList(list1);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);

        tx.commit();


        session.close();
        factory.close();
    }
}
