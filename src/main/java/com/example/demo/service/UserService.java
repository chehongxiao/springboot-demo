package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://service.demo.example.com")
public interface UserService extends IService<User>{

    public List<User> getUserInfo();  

    @WebMethod
    User selectByUsername(@WebParam(name = "username") String username);
    
}
