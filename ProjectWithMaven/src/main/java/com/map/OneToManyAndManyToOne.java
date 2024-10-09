package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToManyAndManyToOne {
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

        Answer ans2 = new Answer();
        ans2.setAnswer_id(2);
        ans2.setAnswer("With the help of java we can create software's");
        ans2.setQuestion(q1);

        Answer ans3 = new Answer();
        ans3.setAnswer_id(3);
        ans3.setAnswer("Java has different types of framework");
        ans3.setQuestion(q1);

        List<Answer> list = new ArrayList<>();
        list.add(ans1);
        list.add(ans2);
        list.add(ans3);

        q1.setAnswers(list);

        // Creating a new session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // saving question and answer
//        session.save(q1);
//        session.save(ans1);
//        session.save(ans2);
//        session.save(ans3);

//        tx.commit();

        // fetching the data....
        Question newQue = session.get(Question.class, 1);

        System.out.println(newQue.getQuestion_id() + " " + newQue.getQuestion());

        // lazy loading
        System.out.println(newQue.getAnswers().size ());

        // for eager loading we are adding another parameter to the OneToMany annotation as fetch type as eager

//        for (Answer a : newQue.getAnswers()) {
//            System.out.println(a.getAnswer());
//        }

        session.close();
        factory.close();
    }
}
