package com.example.demo.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    
    private Integer age;

    private Integer carNo;

    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCarNo() {
        return carNo;
    }

    public void setCarNo(Integer carNo) {
        this.carNo = carNo;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", carNo=" + carNo + ", birthday=" + birthday + "]";
    }
    
    
    

}
