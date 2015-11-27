package com.test.controller;

import com.test.dao.TestDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by zhengying on 15/9/29.
 */
@Controller
@RequestMapping("test")
public class TestController {

//    @Resource
//    private TestDao testDao;
//
//    @RequestMapping("testSql.do")
//    @ResponseBody
//    public List testSql() {
//        return testDao.testSql();
//    }


}
