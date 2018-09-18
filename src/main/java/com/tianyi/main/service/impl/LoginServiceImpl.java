package com.tianyi.main.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.main.dao.UserInfoDao;
import com.tianyi.main.dto.TokenDto;
import com.tianyi.main.dto.UserDto;
import com.tianyi.main.exception.SenseNoteCommonException;
import com.tianyi.main.service.LoginService;
import com.tianyi.main.vo.UserInfoVo;
import com.tianyi.main.vo.UserRequestVo;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserInfoDao userInfoDao;
	
	/**
	 * 注册新用户
	 */
	@Override
	public String registerNewUser(UserRequestVo userVo) {
		StringBuffer result = new StringBuffer("注册成功");
		
		//查看用户是否存在 目前只校验用户名
		UserDto user = userInfoDao.getUserDtoInfo(userVo.getUserName());
		
		if(user != null){
			throw new SenseNoteCommonException("用户名已存在");
		}
		
		UserDto newUser = new UserDto();
		BeanUtils.copyProperties(userVo, newUser);
		newUser.setCreateTime(new Date());
		newUser.setUpdateTime(new Date());
		
		userInfoDao.insertUserDtoInfo(newUser);
		
		return result.toString();
	}

	@Override
	public UserInfoVo userCheckIn(UserRequestVo userVo) {
		// TODO Auto-generated method stub
		String token = null;
		
		UserDto user = userInfoDao.getUserDtoInfo(userVo.getUserName());
		
		checkUserLogin(user,userVo);
		
		token = UUID.randomUUID().toString();
		
		TokenDto tokenDto = createTokenDto(token,userVo);
		userInfoDao.insertTokenDto(tokenDto);
		
		UserInfoVo userInfoVo = new UserInfoVo();
		userInfoVo.setToken(token);
		userInfoVo.setUserEmail(user.getUserEmail());
		userInfoVo.setUserName(user.getUserName());
		
		return userInfoVo;
	}

	private TokenDto createTokenDto(String token,UserRequestVo user) {
		// TODO Auto-generated method stub
		TokenDto tokenDto = new TokenDto();
		tokenDto.setUserName(user.getUserName());
		tokenDto.setToken(token);
		tokenDto.setCreateTime(new Date());
		tokenDto.setValidTime(TokenDto.validTimeConst);
		return tokenDto;
	}

	private void checkUserLogin(UserDto user,UserRequestVo submitUser) {
		// TODO Auto-generated method stub
		if(user == null) 
			throw new SenseNoteCommonException("用户名不存在");
		if(!user.getUserPassword().equals(submitUser.getUserPassword()))
			throw new SenseNoteCommonException("密码不正确");
	}

	
	
	
}
