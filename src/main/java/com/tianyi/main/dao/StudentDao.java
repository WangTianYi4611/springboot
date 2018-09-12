package com.tianyi.main.dao;

import org.apache.ibatis.annotations.Param;

import com.tianyi.main.po.Student;

public interface StudentDao {
	
	Student findStudentById(@Param("id") Integer id);
	
}
