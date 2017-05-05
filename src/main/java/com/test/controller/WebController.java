package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengying on 15/9/29.
 */
@Controller
@RequestMapping("web")
public class WebController {

    @RequestMapping("toIndex")
    public String toLogin() {
        return "refactor/index";
    }

    @RequestMapping("getToken")
    @ResponseBody
    public Map getToken(String email) {
        Map map = new HashMap();
        if("123@qq.com".equals(email)){
            map.put("isUnique", false);
        }else{
            map.put("isUnique", true);
        }
        return map;
    }

    @RequestMapping("toUpload")
    public String toUpload() {
        return "refactor/upload";
    }


    @RequestMapping("uploadimg")
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
