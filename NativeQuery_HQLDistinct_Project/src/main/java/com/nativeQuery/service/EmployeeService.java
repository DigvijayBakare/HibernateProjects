package com.nativeQuery.service;

import com.nativeQuery.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeService {
    public void insertEmployee(long id, String name, double salary, String department) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Native SQL query to insert employee with name, id, salary, and department
            String sql = "INSERT INTO Employee (id, name, salary, department) VALUES (:id, :name, :salary, :department)";

            // Execute the query with parameters for id, name, salary, and department
            session.createNativeQuery(sql)
                    .setParameter("id", id)
                    .setParameter("name", name)
                    .setParameter("salary", salary)
                    .setParameter("department", department)
                    .executeUpdate();  // Use executeUpdate() for data modification

            transaction.commit();
            System.out.println("Employee inserted successfully");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateEmployeeSalary(long id, double newSalary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            String sql = "UPDATE Employee SET salary = :salary WHERE id = :id";
            session.createNativeQuery(sql)
                    .setParameter("salary", newSalary)
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
            System.out.println("Employee salary updated successfully");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
