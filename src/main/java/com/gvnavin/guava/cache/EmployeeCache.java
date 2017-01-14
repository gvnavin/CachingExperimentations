package com.gvnavin.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by gnavin on 1/14/17.
 */
public class EmployeeCache {

    private final LoadingCache<String, Employee> employeeCache;

    public EmployeeCache() {

        final EmployeeDatabase employeeDatabase = new EmployeeDatabase();

        //create a cache for employees based on their employee id
        employeeCache =
                CacheBuilder.newBuilder()
                        .maximumSize(100) // maximum 100 records can be cached
                        .expireAfterAccess(30, TimeUnit.MINUTES) // cache will expire after 30 minutes of access
                        .build(new CacheLoader<String, Employee>() { // build the cacheloader
                            @Override
                            public Employee load(String empId) throws Exception {
                                System.out.println("EmployeeCache.load");

                                return employeeDatabase.getFromDatabase(empId);
                            }

                            @Override
                            public Map<String, Employee> loadAll(Iterable<? extends String> empIds) throws Exception {

                                System.out.println("EmployeeCache.loadAll");

                                final ImmutableList<String> empIdList = ImmutableList.<String>builder().addAll(empIds).build();

                                final List<Employee> allFromDatabase = employeeDatabase.getAllFromDatabase(empIdList);
                                final ImmutableMap.Builder<String, Employee> builder = ImmutableMap.builder();
                                for (final Employee employee : allFromDatabase) {
                                    builder.put(employee.getEmplD(), employee);
                                }
                                return builder.build();
                            }
                        });
    }

    public Employee get(final String empId) throws ExecutionException {

        System.out.println("EmployeeCache.getEmployee empId : " + empId);
        final Employee employee = employeeCache.get(empId);
        System.out.println("employee = " + employee);
        System.out.println();
        return employee;
    }

    public ImmutableMap<String, Employee> getAll(final List<String> empIds) throws ExecutionException {

        System.out.println("EmployeeCache.getAllEmployee empIds : " + empIds.stream().collect(Collectors.joining(", ")) );
        final ImmutableMap<String, Employee> all = employeeCache.getAll(empIds);

        for (Employee employee : all.values()) {
            System.out.println("employee = " + employee);
        }

        return all;
    }
}
