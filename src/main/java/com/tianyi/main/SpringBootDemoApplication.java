package com.tianyi.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@MapperScan("com.tianyi.main.dao")
@ServletComponentScan
public class SpringBootDemoApplication {


	public static void main(String[] args) throws Exception {

		new SpringApplication(SpringBootDemoApplication.class).run(args);

	}
}
