package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMap {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        // Creating an object of question
        Question q1 = new Question();
        q1.setQuestion_id(1);
        q1.setQuestion("What is Java?");

        // Creating an object of answer
        Answer ans1 = new Answer();
        ans1.setAnswer_id(1);
        ans1.setAnswer("Java is a programming language.");
        ans1.setQuestion(q1);
//        q1.setAnswer(ans1);

        Question q2 = new Question();
        q2.setQuestion_id(2);
        q2.setQuestion("What is Collection Framework?");

        Answer ans2 = new Answer();
        ans2.setAnswer_id(2);
        ans2.setAnswer("API to work with objects in java");
        ans2.setQuestion(q2);
//        q2.setAnswer(ans2);

        // Creating a new session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // saving question and answer
        session.save(q1);
        session.save(q2);
        session.save(ans1);
        session.save(ans2);

        tx.commit();

        // fetching the data....
        Question newQue = session.get(Question.class, 1);
        System.out.println(newQue.getQuestion());
//        System.out.println(newQue.getAnswer().getAnswer());

        session.close();
        factory.close();
    }
}
