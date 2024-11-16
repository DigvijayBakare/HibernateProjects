package com.validations.validate;

/**
 * @Author - Digvijay Bakare
 **/

import com.validations.entity.Person;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class PersonValidation {
    public static void main(String[] args) {
        // Create a validator factory and validator
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        // **Check for invalid user data**
        System.out.println("Checking for invalid user data...");
        System.out.println("-----------------------------------");

        // Create an invalid user object with various errors
        Person invalid = new Person(1, "", "asdfgh", "852963", "");

        Set<ConstraintViolation<Person>> violations = validator.validate(invalid);

        if (violations.isEmpty()) {
            System.out.println("Valid user data provided.");
        } else {
            System.out.println("Invalid user data found:");
            for (ConstraintViolation<Person> violation : violations) {
                System.out.println(violation.getMessage());
            }
        }
        System.out.println("-----------------------------------");
        System.out.println();

        // **Check for valid user data**
        System.out.println("Checking for valid user data...");
        System.out.println("-----------------------------------");

        // Create a valid user object
        Person valid = new Person(2, "Shree Pethkar", "shree@gmail.com", "9874563210", " at peth maharashtra");

        violations = validator.validate(valid);

        if (violations.isEmpty()) {
            System.out.println("Valid user data provided.");
        } else {
            System.out.println("Invalid user data found:");
            for (ConstraintViolation<Person> violation : violations) {
                System.out.println(violation.getMessage());
            }
        }

        System.out.println("-----------------------------------");
    }
}
