package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import javax.jws.WebService;

@WebService(serviceName = "UserService",//对外发布的服务名
        targetNamespace = "http://service.demo.example.com",//指定你想要的名称空间，通常使用使用包名反转
        endpointInterface = "com.example.demo.service.UserService")//服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
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
