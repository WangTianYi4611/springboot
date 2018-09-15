package com.tianyi.main.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tianyi.main.exception.SenseNoteCommonException;
import com.tianyi.main.po.BasicResult;
import com.tianyi.main.vo.UserVo;

@RestController
@RequestMapping("hello")
public class HelloController {
	/**
	 * 注册新用户接口
	 * @param userInfo
	 */
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public BasicResult<String> registerNewUser(){
		BasicResult<String> result = new BasicResult<>();
		try{

			result.setMsg("登录成功");
		}catch(SenseNoteCommonException e){
			result.setCode(BasicResult.FAIL);
			result.setMsg(e.getMessage());
		}catch(Exception e){
			result.setCode(BasicResult.FAIL);
			result.setMsg("其他错误");			
		}
		return result;
	}
}
