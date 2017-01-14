package com.gvnavin.guava.cache;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;

/**
 * Created by gnavin on 1/14/17.
 */
public class CacheLoaderWithLoadAll extends CacheLoaderWithLoad {

    public static final CacheLoaderWithLoadAll INSTANCE = new CacheLoaderWithLoadAll();

    @Override
    public Map<String, Employee> loadAll(Iterable<? extends String> empIds) throws Exception {

        System.out.println("CacheLoader.loadAll");

        final ImmutableList<String> empIdList = ImmutableList.<String>builder().addAll(empIds).build();

        final List<Employee> allFromDatabase = EmployeeDatabase.get().getAllFromDatabase(empIdList);
        final ImmutableMap.Builder<String, Employee> builder = ImmutableMap.builder();

        for (final Employee employee : allFromDatabase) {
            builder.put(employee.getEmplD(), employee);
        }

        return builder.build();
    }
}
