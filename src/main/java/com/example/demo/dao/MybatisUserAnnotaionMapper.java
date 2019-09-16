package com.example.demo.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.User;

@Mapper
public interface MybatisUserAnnotaionMapper {

    @Insert("INSERT INTO tp_user(tel,password,nickname,secret) VALUES (#{tel},md5(#{pwd}),#{tel},'')")
    void createUser(Map<String, Object> reqMap);

    @Select("select tel,nickname,password FROM tp_user WHERE user_id = #{id}")
    User getUser(@Param("id") Integer id);

    @Update("UPDATE tp_user SET nickname = #{nickName} WHERE user_id = #{userId}")
    void updateUser(@Param("userId") String user_id, @Param("nickName") String nickName);

    @Delete("DELETE FROM tp_user WHERE tel = #{tel}")
    void deleteUserByUserId(User userInfo);
}