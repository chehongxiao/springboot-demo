package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    
	@Test
	public void contextLoads() {
	}
	
	@Test
    public void insertOne() {
	    User newUser = new User();
        int cardNo = (int) (Math.random() * 10000000);
        newUser.setAge(24);
        newUser.setBirthday(new Date());
        newUser.setName(cardNo + "用户");
        newUser.setCarNo(cardNo);
        userMapper.insertSelective(newUser);
        System.out.println("插入成功");
    }
	
	   @Test
	    public void querybyPage() {
	        PageHelper.startPage(2, 10);
	        List<User> all = userMapper.selectAll();
	        System.out.println(all.size());
	        System.out.println(all.toString());
	        PageInfo<User> pageInfo = new PageInfo<>(all);
	    }

}
