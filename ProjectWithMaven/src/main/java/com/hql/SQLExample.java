package com.hql;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class SQLExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // sql query
        String q = "select * from student";
        NativeQuery nq = session.createSQLQuery(q);

        List<Object[]> list = nq.list();
        for (Object[] s : list) {
//            System.out.println(Arrays.toString(s));
            System.out.println(s[0] + " : " + s[4] + " : " + s[3]);
        }

        session.close();
        factory.close();
    }
}
