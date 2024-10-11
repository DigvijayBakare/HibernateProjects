package com.hql;

import com.manyToMany.Employee;
import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;


public class HQLExample {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        // HQL syntax
//        String hqlQuery = "from Employee";
        String hqlQuery = "from Employee where id= 101";
        Query q = session.createQuery(hqlQuery);

        // multiple
        List<Employee> list = q.list();

        for (Employee e : list) {
            System.out.println(e.geteName());
        }

        String query = "from Student as s where s.city= :x and s.name= :n";
        Query q1 = session.createQuery(query);
        q1.setParameter("x", "Bid");
        q1.setParameter("n", "Tukaram Bahir");

        // multiple
        List<Student> list1 = q1.list();

        for (Student s : list1) {
            System.out.println(s.getName()+ " : " + s.getCertificate().getCourse());
        }
        System.out.println("_________________________________________________________________");

        Transaction tx = session.beginTransaction();

        //delete query
//        Query q2 = session.createQuery("delete from Student as s where s.city= :c");
//        q2.setParameter("c", "Kolhapur");
//        q2.executeUpdate();
//        System.out.println("Deleted ");

        // update query
        Query q2 = session.createQuery("update Student set city = :c where name= :n");
        q2.setParameter("c", "Kolhapur");
        q2.setParameter("n", "Ravi Tiwari");
        q2.executeUpdate();
        System.out.println("Updated.. ");



        tx.commit();

        // join query
        Query q3 = session.createQuery("select q.question_id, q.question, a.answer from Question as q INNER JOIN q.answers as a");
        List<Object[]> list2 = q3.getResultList();
        for (Object[] arr : list2) {
            System.out.println(Arrays.toString(arr));
        }


        session.close();
        factory.close();
    }
}
