package com.tianyi.main.po;

import java.util.List;

import org.springframework.http.HttpEntity;

public class BasicResult<T> {
	
	public static final int SUCCESS = 200; //成功
	public static final int FAIL = 500;//失败
	
	private int code = SUCCESS; //状态码
	
	private String msg = "请求成功"; // 信息
	
	private String errorMsg;
	
	private T singleResult; //单个结果值得时候返回这个
	
	private List<T> multipleResult; //多个结果值

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getSingleResult() {
		return singleResult;
	}

	public void setSingleResult(T singleResult) {
		this.singleResult = singleResult;
	}

	public List<T> getMultipleResult() {
		return multipleResult;
	}

	public void setMultipleResult(List<T> multipleResult) {
		this.multipleResult = multipleResult;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
	
	
}
