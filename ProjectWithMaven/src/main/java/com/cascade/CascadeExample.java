package com.cascade;

import com.map.Answer;
import com.map.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CascadeExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Question q1 = new Question();
        q1.setQuestion_id(123);
        q1.setQuestion("What is swing?");

        // Creating an object of answer
        Answer ans1 = new Answer(22, "In hibernate it is important topic");
        Answer ans2 = new Answer(24, "Second answer");
        Answer ans3 = new Answer(30, "Third answer");

        List<Answer> list = new ArrayList<>();
        list.add(ans1);
        list.add(ans2);
        list.add(ans3);

        q1.setAnswers(list);
        Transaction tx = session.beginTransaction();
//        session.save(q1);
//        session.save(ans1);
//        session.save(ans2);
//        session.save(ans3);

        // we use cascading to work with related entities we added cascade type on the data
        session.save(q1);

        tx.commit();
        session.close();
        factory.close();
    }
}
