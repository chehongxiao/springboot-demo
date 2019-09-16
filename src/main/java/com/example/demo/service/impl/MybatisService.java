package com.example.demo.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MybatisUserAnnotaionMapper;
import com.example.demo.entity.User;

@Service
public class MybatisService {

    @Autowired
    private MybatisUserAnnotaionMapper annotaionMapper;


    public void updateUser(String user_id, String nickName) {
        annotaionMapper.updateUser(user_id,nickName);
    }

    public User getUser(Integer id) {
        return annotaionMapper.getUser(id);
    }

    public void deleteUserByUserId(User userInfo) {
        annotaionMapper.deleteUserByUserId(userInfo);
    }

    public void createUser(Map<String, Object> reqMap) {
        annotaionMapper.createUser(reqMap);
    }
}
