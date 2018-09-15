package com.tianyi.main.dao;

import com.tianyi.main.dto.TokenDto;
import com.tianyi.main.dto.UserDto;



public interface UserInfoDao {
	
	void insertUserDtoInfo(UserDto userInfo);
	
	UserDto getUserDtoInfo(String userName);
	
	void insertTokenDto(TokenDto tokenDto);
	
	TokenDto getTokenDto(String token);
	
	
}
