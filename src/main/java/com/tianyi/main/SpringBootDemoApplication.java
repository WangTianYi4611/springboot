package com.tianyi.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.*;

import com.tianyi.main.service.StudentService;

@SpringBootApplication
@MapperScan("com.tianyi.main.dao")
public class SpringBootDemoApplication {


	public static void main(String[] args) throws Exception {
		//SpringApplication.run(SpringBootTestController.class, args);
		new SpringApplication(SpringBootDemoApplication.class).run(args);
		//System.out.println("hah");
	}
}
