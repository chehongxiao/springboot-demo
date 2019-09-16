package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService extends IService<User>{

    public List<User> getUserInfo();  
    
    User selectByUsername(String username);
    
}
