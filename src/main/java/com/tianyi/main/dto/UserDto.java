package com.tianyi.main.dto;

import java.util.Date;

public class UserDto {
	
	private Integer id;
	private String userName;
	private String userPassword;
	private Date createTime;
	private String userEmail;
	private Date updateTime;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
	
	
}
