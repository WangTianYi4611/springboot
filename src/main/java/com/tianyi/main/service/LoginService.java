package com.tianyi.main.service;

import com.tianyi.main.dto.UserDto;
import com.tianyi.main.vo.UserVo;

public interface LoginService {
	
	 String registerNewUser(UserVo userVo); 
	 
	 String userCheckIn(UserVo userVo);
	
}
