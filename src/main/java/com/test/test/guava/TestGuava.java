package com.test.test.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.Date;
//
//import java.util.Date;

/**
 * Created by zhengying on 15/12/9.
 */
public class TestGuava {

    @Test
    public void TestLoadingCache() throws Exception {
        LoadingCache<String, String> cahceBuilder = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                String strProValue = "没找到key:" + key;
                return strProValue;
            }
        });
        cahceBuilder.put("asd", new Date().toString());
        System.out.println(cahceBuilder.get("asd"));
        System.out.println(cahceBuilder.get("xxxx"));
    }

    @Test
    public void testCollections(){


    }
}
