package com.tianyi.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.xml.internal.ws.developer.Serialization;
import com.tianyi.main.dao.StudentDao;
import com.tianyi.main.po.Student;
import com.tianyi.main.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Student findStudentById(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.findStudentById(id);
	}

}
