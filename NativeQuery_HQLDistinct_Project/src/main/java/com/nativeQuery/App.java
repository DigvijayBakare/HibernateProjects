package com.nativeQuery;

import com.nativeQuery.dao.ProductDAO;
import com.nativeQuery.entity.Product;
import com.nativeQuery.service.EmployeeService;
import com.nativeQuery.util.HibernateUtil;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void employeeService() {
        System.out.println("Hello World!");
        EmployeeService employeeService = new EmployeeService();

        employeeService.insertEmployee(1L, "Rohit Patel", 6500.00, "IT Sector");

        //update the salary of employee with id 1
        employeeService.updateEmployeeSalary(1L, 7500.00);
    }

    public static void productDAO() {
        ProductDAO productDAO = new ProductDAO();

        // Insert sample data
        productDAO.insertSampleData();

        // Display all products
        System.out.println("All Products:");
        List<Product> products = productDAO.getAllProducts();
        products.forEach(product -> System.out.println(product.getName() + " - " + product.getPrice()));

        // Perform HQL DISTINCT query
        List<String> distinctProductNames = productDAO.getDistinctProductNames();

        System.out.println("Distinct Product Names:");
        distinctProductNames.forEach(System.out::println);

        // Shut down the SessionFactory
        HibernateUtil.shutdown();
    }

    public static void main(String[] args) {
        employeeService();
//        productDAO();
    }
}
