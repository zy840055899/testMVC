package com.test.test.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Random;

/**
 * Created by zhengying on 15/12/10.
 */
public class TestLog {

    static Logger logger = LoggerFactory.getLogger(TestLog.class);

    public static void main(String[] args) throws Exception {
        Random random = new Random();
        // 记录error信息
//        logger.error("88888888888888");
        // 记录info，还可以传入参数
//        logger.info("[info message]{},{},{}", "abc", "aaaaaaaa", 123);

        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            logger.info("log2, id:{}, name:{}, age{}", i, "xxx", random.nextInt(20));
        }

        // 记录deubg信息
        logger.debug("[debug message]");
        // 记录trace信息
        logger.trace("[trace message]");
    }

}
