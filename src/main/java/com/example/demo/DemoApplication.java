package com.example.demo;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages="com.example.demo.dao")
public class DemoApplication implements CommandLineRunner {

    @Autowired  
    DataSource dataSource;
    
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    public void run(String... arg0) throws Exception {
        System.out.println("DATASOURCE = " + dataSource); 
        
    }
}
