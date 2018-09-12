package com.tianyi.main.po;

public class Student {
	private Integer id;
	private String studentName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + "]";
	}
	
	
}
