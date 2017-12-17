package com.gvnavin.guava.cache.loadonly;

import com.gvnavin.guava.cache.EmployeeCacheHelper;
import com.gvnavin.guava.cache.Util;

/**
 * Created by gnavin on 1/14/17.
 */
public class LoadOnlyMain {
    public static void main(String[] args) {
        //Util.getTest(EmployeeCacheHelper.CACHE_LOAD_ONLY);
        Util.getAllTest(EmployeeCacheHelper.CACHE_LOAD_ONLY);
    }

}
