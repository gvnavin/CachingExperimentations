package com.gvnavin.guava.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gnavin on 1/14/17.
 */
public class EmployeeDatabase {

    private final HashMap<String, Employee> database;

    public EmployeeDatabase() {
        Employee e1 = new Employee("Mahesh", "Finance", "100");
        Employee e101 = new Employee("Mahesh101", "Finance", "101");
        Employee e102 = new Employee("Mahesh102", "Finance", "102");
        Employee e2 = new Employee("Rohan", "IT", "103");
        Employee e3 = new Employee("Sohan", "Admin", "110");

        database = new HashMap<String, Employee>();

        database.put("100", e1);
        database.put("101", e101);
        database.put("102", e102);
        database.put("103", e2);
        database.put("110", e3);
    }

    public Employee getFromDatabase(String empId) {

        System.out.println("EmployeeDatabase.getFromDatabase Database hit for : " + empId);
        return database.get(empId);
    }

    public List<Employee> getAllFromDatabase(final List<String> empIds) {

        final List<Employee> employeeList = new ArrayList<Employee>();
        for (final String empId : empIds) {
            System.out.println("EmployeeDatabase.getAllFromDatabase Database hit for : " + empId);
            employeeList.add(database.get(empId));
        }
        return employeeList;
    }
}