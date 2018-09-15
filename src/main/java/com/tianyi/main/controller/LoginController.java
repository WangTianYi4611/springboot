package com.tianyi.main.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tianyi.main.dto.UserDto;
import com.tianyi.main.exception.SenseNoteCommonException;
import com.tianyi.main.po.BasicResult;
import com.tianyi.main.service.LoginService;
import com.tianyi.main.vo.UserVo;

@RestController
@RequestMapping("login")
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * 注册新用户接口
	 * @param userInfo
	 */
	@RequestMapping(value = "registerNewUser", method = RequestMethod.POST)
	public BasicResult<String> registerNewUser(@RequestBody UserVo userVo){
		BasicResult<String> result = new BasicResult<>();
		try{
			loginService.registerNewUser(userVo);
			result.setMsg("登录成功");
		}catch(SenseNoteCommonException e){
			result.setCode(BasicResult.FAIL);
			result.setMsg(e.getMessage());
		}catch(Exception e){
			logger.error("exception e {}",e);
			result.setCode(BasicResult.FAIL);
			result.setMsg("其他错误");			
		}
		return result;
	}
	/**
	 * 登录接口
	 */
	@RequestMapping(value = "userCheckIn",method = RequestMethod.POST)
	public BasicResult<String> userCheckIn(@RequestBody UserVo userVo){
		BasicResult<String> result = new BasicResult<>();
		try{
			String token = loginService.userCheckIn(userVo);
			result.setSingleResult(token);
			result.setMsg("登录成功");
		}catch(SenseNoteCommonException e){
			result.setCode(BasicResult.FAIL);
			result.setMsg(e.getMessage());
		}catch(Exception e){
			logger.error("exception e {}",e);
			result.setCode(BasicResult.FAIL);
			result.setMsg("其他错误");			
		}
		return result;
	}
	
	
}
