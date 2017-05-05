package com.test.controller;

import com.test.dao.TestDao;
import com.test.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhengying on 15/9/29.
 */
@Controller
@RequestMapping("test")
public class TestController {

    @Resource
    private TestDao testDao;

    @RequestMapping("testSql")
    @ResponseBody
    public List testSql() {
        return testDao.testSql();
    }

    @RequestMapping("testSqlJsp")
    public String testSqlJsp(Model model) {
        List<Student> students = testDao.testSql();
        model.addAttribute("students", students);
        return "sql/students";
    }

    @RequestMapping("detail")
    public String detail(Model model, int id) {
        Student stu = testDao.getStuById(id);
        model.addAttribute("stu", stu);
        return "sql/detail";
    }
}
