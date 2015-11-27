package com.test.test.junit;

import com.google.gson.Gson;
import com.test.dao.TestDao;
import com.test.entity.TestEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by zhengying on 15/11/27.
 */
public class TestMysql {

    @Test
    public void testMysql(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        TestDao dao = ctx.getBean("testDao", TestDao.class);

        List<TestEntity> objs = dao.testSql();

        Gson gson = new Gson();

        System.out.println(gson.toJson(objs));
    }

}
