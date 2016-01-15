package com.test.test.ehcache;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @author zhengying
 */
public class EhcacheTest {
    //一些配置参数
    private static CacheManager cacheManager;
    static String cacheName = "cache1";

    public static void main(String[] args) {
        ehcacheSetUp();
        ehcacheUse();
    }

    private static void ehcacheSetUp() {
        cacheManager = CacheManager.create();
        cacheManager.addCache(cacheName);
    }

    private static void ehcacheUse() {
        Cache cache1 = cacheManager.getCache(cacheName);
        String key = "key1";
        String value = "value1";

        writeSomeData(cache1, key, value);

        Element element = readSomeData(cache1, key, value);

        System.out.println(element);

        return;
    }

    private static void writeSomeData(Cache cache, String key, String value) {
        cache.put(new Element(key, value));
    }

    private static Element readSomeData(Cache cache, String key, String value) {
        return cache.get(key);
    }
}
