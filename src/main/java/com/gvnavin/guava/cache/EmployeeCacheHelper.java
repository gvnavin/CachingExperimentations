package com.gvnavin.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * Created by gnavin on 1/14/17.
 */
public class EmployeeCacheHelper {

    private final LoadingCache<String, Employee> loadingCache;

    private static final EmployeeCacheHelper LOADER_LOAD_ONLY = new EmployeeCacheHelper(CacheLoaderWithLoad.INSTANCE);

    private static final EmployeeCacheHelper LOADER_LOAD_ALL = new EmployeeCacheHelper(CacheLoaderWithLoadAll.INSTANCE);

    public static final EmployeeCache CACHE_LOAD_ONLY = new EmployeeCache(LOADER_LOAD_ONLY.getLoadingCache());

    public static final EmployeeCache CACHE_LOAD_ALL = new EmployeeCache(LOADER_LOAD_ALL.getLoadingCache());

    private EmployeeCacheHelper(final CacheLoader<String, Employee> loader) {
        loadingCache = CacheBuilder.newBuilder()
                .maximumSize(100) // maximum 100 records can be cached
                .expireAfterAccess(30, TimeUnit.MINUTES) // loadingCache will expire after 30 minutes of access
                .build(loader);
    }

    private LoadingCache<String, Employee> getLoadingCache() {
        return loadingCache;
    }

}
