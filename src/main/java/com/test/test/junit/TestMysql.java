package com.test.test.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhengying on 15/11/27.
 */
public class TestMysql {

    @Test
    public void testMysql(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

//        TestDao dao = ctx.getBean("testDao", TestDao.class);
//
//
//        Student stu = dao.getStuById(100110);
//
//        System.out.println(stu);


    }

}
