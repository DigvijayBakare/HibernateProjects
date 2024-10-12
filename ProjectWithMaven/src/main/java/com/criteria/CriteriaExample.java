package com.criteria;

import com.tut.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CriteriaExample {
    public static void main(String[] args) {
        Session session = new Configuration().configure().buildSessionFactory().openSession();

        Criteria criteria = session.createCriteria(Student.class);

//        criteria.add(Restrictions.eq("certificate.course", "Android"));
        criteria.add(Restrictions.lt("id", 130));
        List<Student> list = criteria.list();

        list.forEach(System.out::println);


        session.close();
    }
}
