package com.test.test.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhengying on 15/11/17.
 */
@Component
public class TestQuartz {

    private static final Logger LOG = LoggerFactory.getLogger(TestQuartz.class);
    public void run(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(new Date());
        System.out.println(str);
        LOG.info("数据转换任务线程开始执行");
    }

}
