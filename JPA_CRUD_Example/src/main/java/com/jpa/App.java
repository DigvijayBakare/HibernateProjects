package com.jpa;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        CRUDOperations crudOperations = new CRUDOperations();
        crudOperations.insertEntity();
        crudOperations.findEntity();
//        crudOperations.updateEntity();
//        crudOperations.removeEntity();
    }
}
