package com.test.test.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhengying on 15/12/3.
 */
public class Provider {
    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/dubbo.xml");

        ctx.start();

        System.out.println("xxxxxx");

        System.in.read(); // 按任意键退出
    }

}
