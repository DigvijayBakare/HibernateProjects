package com.validations.validate;

import com.validations.entity.Person;
import com.validations.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class PersonSaving {
    public static void main(String[] args) {
        // Create a validator factory and validator
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        // Check for invalid user data
        System.out.println("Checking the user data...");
//        System.out.println("-----------------------------------");

        // Create an invalid user object with various errors
//        Person person1 = new Person(1, "", "asdfgh", "852963", "");
        Person person1 = new Person(2, "Shree Pethkar", "shree@gmail.com", "9874563210", " at peth maharashtra");
        Set<ConstraintViolation<Person>> violations = validator.validate(person1);

        if (violations.isEmpty()) {
            System.out.println("Valid user data provided.");
            // Get session
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(person1);
            tx.commit();
            System.out.println("Person: " + person1);

            HibernateUtil.getSessionFactory().close();
        } else {
            System.out.println("Invalid user data found:");
            for (ConstraintViolation<Person> violation : violations) {
                System.out.println(violation.getMessage());
            }
        }
        System.out.println("-----------------------------------");
        System.out.println();
    }
}
