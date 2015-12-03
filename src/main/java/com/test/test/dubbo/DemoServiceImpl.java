package com.test.test.dubbo;

/**
 * Created by zhengying on 15/12/3.
 */
public class DemoServiceImpl implements DemoService {
    public String build(String name) throws Exception {
        System.out.println("name is === " + name);
        return "你好 名称是 ------------- >>>> " + name;
    }
}