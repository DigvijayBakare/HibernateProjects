package com.pagination;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPagination {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("from Student");

        // implementing pagination using hibernate
        query.setFirstResult(0);
        query.setMaxResults(10);

        List<Student> list = query.list();
        for (Student s : list) {
            System.out.println(s.getId() + " : " + s.getName() + " : " + s.getCity());
        }

        session.close();
        factory.close();
    }
}
