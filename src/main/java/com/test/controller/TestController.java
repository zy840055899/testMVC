package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhengying on 15/9/29.
 */
@Controller
@RequestMapping("test")
public class TestController {


    @RequestMapping("index")
    public String detail(Model model) {
        model.addAttribute("aaa", 88888);
        model.addAttribute("aaa", 123);
        return "test/index";
    }
}
