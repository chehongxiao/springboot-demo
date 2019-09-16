package com.example.demo.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.impl.MybatisService;

@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private MybatisService service;

    /**
     * 更新用户信息
     * @param user_id 用户ID
     * @param nickName 昵称
     */
    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable("id") String user_id, @RequestParam("nickName") String nickName){
        service.updateUser(user_id,nickName);
    }

    /**
     * http://localhost:8080/mybatis//getUser/1
     * 获取用户信息
     * @param id 用户Id
     * @return
     */
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id")  Integer id){
        return service.getUser(id);
    }

    /**
     * 删除用户
     * @param tel
     */
    @DeleteMapping("/deleteUserByUserId/{tel}")
    public void deleteUserByUserId(@PathVariable("tel")  String tel){
        User user  = new User();
        service.deleteUserByUserId(user);
    }

    /**
     * 使用@RequestBody获取参数，用map类型接收，再取出
     * @param reqMap
     */
    @PostMapping("/createUserByMap")
    public void createUserByMap(@RequestBody Map<String,Object> reqMap){
        service.createUser(reqMap);
    }


}
