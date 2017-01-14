package com.gvnavin.guava.cache;


import com.google.common.cache.CacheLoader;

/**
 * Created by gnavin on 1/14/17.
 */
public class CacheLoaderWithLoad extends CacheLoader<String, Employee> {

    public static final CacheLoaderWithLoad INSTANCE = new CacheLoaderWithLoad();

    @Override
    public Employee load(String empId) throws Exception {
        System.out.println("CacheLoader.load");
        return EmployeeDatabase.get().getFromDatabase(empId);
    }
};

