package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController    
@RequestMapping("/user")    
public class UserController {    
    @Autowired  
    private UserService userService;  
      
    @RequestMapping("/getUserInfo")  
    public List<User> getUserInfo() {  
        List<User> user = userService.getUserInfo();  
        System.out.println(user.toString());  
        return user;  
    }  
      
    @RequestMapping("/addUser")  
    public String addUser() {  
        User newUser = new User();
        int cardNo = (int) (Math.random() * 10000000);
        newUser.setAge(24);
        newUser.setBirthday(new Date());
        newUser.setName(cardNo + "用户");
        newUser.setCarNo(cardNo); 
        userService.save(newUser);
        return "success:"+newUser.getId();  
    }
    
    @RequestMapping("/findUser")
    @ResponseBody
    public User findUser(@RequestParam(required=true,defaultValue="") String name) {  
        User user = userService.selectByUsername(name);
        return user;  
    }
      
      
} 
