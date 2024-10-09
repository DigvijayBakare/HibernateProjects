package com.nativeQuery.dao;

import java.util.List;

import com.nativeQuery.entity.Product;
import org.hibernate.Session;
import com.nativeQuery.util.HibernateUtil;
import org.hibernate.query.Query;

public class ProductDAO {
    public List<String> getDistinctProductNames() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "select distinct p.name from Product p";
            Query<String> query = session.createQuery(hql, String.class);
            return query.list();
        }
    }

    public void insertSampleData() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(new Product("Laptop", 1000.00));
            session.persist(new Product("Laptop", 1100.00)); // Duplicate name, different price
            session.persist(new Product("Phone", 500.00));
            session.persist(new Product("Tablet", 300.00));
            session.getTransaction().commit();
        }
    }

    public List<Product> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Product", Product.class).list();
        }
    }
}
