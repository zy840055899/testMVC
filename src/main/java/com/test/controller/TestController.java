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

    @Resource
    private TestDao testDao;

    @RequestMapping("testSql.do")
    @ResponseBody
    public List testSql() {
        return testDao.testSql();
    }

    @RequestMapping("toIndex.do")
    public String toLogin() {
        return "test/upload";
    }


    @RequestMapping("uploadimg.do")
    @ResponseBody
    public String uploadimg(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {

        System.out.println("开始...........");
//        String path = request.getSession().getServletContext().getRealPath("upload");
        String path = "/Users/zhengying/downloads";
        String fileName = file.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success:" + request.getContextPath() + "/upload/" + fileName;
    }
}
