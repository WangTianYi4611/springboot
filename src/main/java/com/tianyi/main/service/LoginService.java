package com.tianyi.main.service;

import com.tianyi.main.dto.UserDto;
import com.tianyi.main.vo.UserInfoVo;
import com.tianyi.main.vo.UserRequestVo;

public interface LoginService {
	
	 String registerNewUser(UserRequestVo userVo); 
	 
	 UserInfoVo userCheckIn(UserRequestVo userVo);
	
}
