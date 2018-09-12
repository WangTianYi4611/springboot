package com.tianyi.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tianyi.main.service.StudentService;


@RestController
@RequestMapping("")
public class HelloController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("hello")
	String home() {
		return "Hello World!";
	}
	
	@RequestMapping("getStudent")
	public String getStudentByid(){
		return studentService.findStudentById(1).toString();
	}
}
