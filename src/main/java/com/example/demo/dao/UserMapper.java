package com.example.demo.dao;

import java.util.List;




import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.User;
import com.example.demo.utils.TkMapper;

/*@Mapper*/
public interface UserMapper extends TkMapper<User> {

    public List<User> findUserInfo();  
    public int addUserInfo(User user);  
    public int delUserInfo(int id);
}
