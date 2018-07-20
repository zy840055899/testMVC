package com.test.test.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhengying on 15/11/17.
 */
@Component
public class TestQuartz {
    private static final Logger LOG = LoggerFactory.getLogger(TestQuartz.class);

    public void run() {
        // 查询所有updateTime晚于staticTime或staticTime为空的学生信息
    }
}
