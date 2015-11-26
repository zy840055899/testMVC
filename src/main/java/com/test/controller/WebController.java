package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengying on 15/9/29.
 */
@Controller
@RequestMapping("web")
public class WebController {

    @RequestMapping("toIndex.do")
    public String toLogin() {
        return "test/index";
    }

    @RequestMapping("getToken.do")
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

}
