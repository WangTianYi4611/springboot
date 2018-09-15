package com.tianyi.main.dto;

import java.util.Date;

public class TokenDto {
	
	public static final int validTimeConst = 86400000;//24*60*60*1000ms
	
	private Integer id;
	private String token;
	private String userName;
	private Date createTime;
	private Integer validTime = validTimeConst;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getValidTime() {
		return validTime;
	}
	public void setValidTime(Integer validTime) {
		this.validTime = validTime;
	}
	@Override
	public String toString() {
		return "tokenDto [id=" + id + ", token=" + token + ", userName=" + userName + ", createTime=" + createTime
				+ ", validTime=" + validTime + "]";
	}
	
	
	
}
