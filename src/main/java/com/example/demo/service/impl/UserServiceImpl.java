package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Autowired  
    private UserMapper userMapper;
    
    public List<User> getUserInfo() {
        return userMapper.findUserInfo();
    }

    @Override
    public User selectByUsername(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name", "%"+username+"%");
        List<User> list = selectByExample(example);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

}
