package com.test.test.quartz;

import com.test.dao.TestDao;
import com.test.entity.Student;
import com.test.test.spider.TestSpider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhengying on 15/11/17.
 */
@Component
public class TestQuartz {
    private static final Logger LOG = LoggerFactory.getLogger(TestQuartz.class);

    @Resource
    private TestDao dao;

    public void run() {
        // 查询所有updateTime晚于staticTime或staticTime为空的学生信息
        List<Student> stus = dao.getNeedStaticStus();
        String detailPath = "http://127.0.0.1:7001/test/detail.do?id=";
        for (int i = 0; i < stus.size(); i++) {
            int id = stus.get(i).getId();
            try {
                // 静态化
                if (TestSpider.downloadPage(detailPath + id, id + ".html")) {
                    // 成功的话修改数据的静态化时间
                    dao.updateStaticTime(id);
                }
            } catch (Exception e) {
                LOG.error("静态化页面异常");
            }
        }
    }
}
