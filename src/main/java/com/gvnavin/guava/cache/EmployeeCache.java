package com.gvnavin.guava.cache;

import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * Created by gnavin on 1/14/17.
 */
public class EmployeeCache {

    private final LoadingCache<String, Employee> employeeCache;

    public EmployeeCache(final LoadingCache<String, Employee> employeeCache) {

        //create a cache for employees based on their employee id
        this.employeeCache = employeeCache;

    }

    public Employee get(final String empId) throws ExecutionException {

        System.out.println("EmployeeCache.getEmployee empId : " + empId);
        final Employee employee = employeeCache.get(empId);
        //System.out.println("employee = " + employee);
        //System.out.println();
        return employee;
    }

    public ImmutableMap<String, Employee> getAll(final List<String> empIds) throws ExecutionException {

        System.out.println("EmployeeCache.getAllEmployee empIds : " + empIds.stream().collect(Collectors.joining(", ")) );
        final ImmutableMap<String, Employee> all = employeeCache.getAll(empIds);

        /*for (Employee employee : all.values()) {
            System.out.println("employee = " + employee);
        }*/

        return all;
    }
}
