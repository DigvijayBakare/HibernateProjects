package com.geeks;

import org.hibernate.Session;
import java.util.Date;

public class GeekUserDetailsTest {
    public static void main(String[] args) {
        // open the session For doing any CRUD operation
//        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSessionFactory().openSession();

        // let us start a transaction
        session.beginTransaction();

        // Create an object of GeekUserDetails
        GeekUserDetails geekUser = new GeekUserDetails();

        // Set all the details required to insert into the table
        geekUser.setGeekUserId(3);
        geekUser.setGeekUsername("GeekUser3");
        geekUser.setNumberOfPosts(90);
        geekUser.setCreatedBy("GeekUser3");
        geekUser.setCreatedDate(new Date());

        // Just a save statement is enough which automatically creates an insert statement
        session.save(geekUser);

        // commit will help to complete the changes in the table
        session.getTransaction().commit();

        // close the session
        session.close();
    }
}
