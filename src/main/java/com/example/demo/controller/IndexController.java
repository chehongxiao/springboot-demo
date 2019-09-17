package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.utils.RedisUtil;

@Controller
@CrossOrigin
public class IndexController {
    
    @Autowired
    private RedisUtil redisUtil;
    
    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("hello2", "hello2 Thymeleaf!");
        map.addAttribute("hello", "hello Thymeleaf!");
        return "index";
    }
    
    @RequestMapping("/test")
    @ResponseBody
    public String redis(ModelMap map) {
        redisUtil.set("testRedis", "测试redis");
        String value = (String) redisUtil.get("testRedis");
        return value;
    }


}
