package com.gvnavin.guava.cache;

import com.google.common.collect.ImmutableList;

import java.util.concurrent.ExecutionException;

/**
 * Created by gnavin on 1/14/17.
 */
public class Util {

    public static void getAllTest(final EmployeeCache employeeCache) {
        try {
            //on first invocation, cache will be populated with corresponding
            //employee record
            System.out.println("Invocation #1");
            System.out.println(employeeCache.getAll(ImmutableList.of("100", "103", "110")));

            System.out.println("------------------------------");

            //second invocation, data will be returned from cache
            System.out.println("Invocation #2");
            System.out.println(employeeCache.getAll(ImmutableList.of("100", "101", "102")));

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void getTest(final EmployeeCache employeeCache) {

        try {
            //on first invocation, cache will be populated with corresponding
            //employee record
            System.out.println("Invocation #1");
            System.out.println(employeeCache.get("100"));
            System.out.println();
            System.out.println(employeeCache.get("103"));
            System.out.println();
            System.out.println(employeeCache.get("110"));

            System.out.println("------------------------------");

            //second invocation, data will be returned from cache
            System.out.println("Invocation #2");
            System.out.println(employeeCache.get("100"));
            System.out.println();
            System.out.println(employeeCache.get("103"));
            System.out.println();
            System.out.println(employeeCache.get("110"));



        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
