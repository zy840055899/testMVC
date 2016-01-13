package com.test.test.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by zhengying on 15/12/10.
 */
public class TestLog {

    static Logger logger = LoggerFactory.getLogger(TestLog.class);

    public static void main(String[] args) throws IOException {
        // 记录error信息
        logger.error("88888888888888");
//        // 记录info，还可以传入参数
//        logger.info("[info message]{},{},{}", "abc", "aaaaaaaa", 123);
//        // 记录deubg信息
//        logger.debug("[debug message]");
//        // 记录trace信息
//        logger.trace("[trace message]");
    }

}
