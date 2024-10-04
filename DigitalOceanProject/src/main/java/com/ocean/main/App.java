package com.ocean.main;

import com.ocean.model.Employee;
import org.hibernate.Session;
import com.ocean.util.HibernateUtil;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Employee emp = new Employee();
        emp.setName("Pankaj");
        emp.setRole("CEO");
        emp.setInsertTime(new Date());

        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();

        //Save the Model object
        session.save(emp);

        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID = " + emp.getId());

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
    }
}
