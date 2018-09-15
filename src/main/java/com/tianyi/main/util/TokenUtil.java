package com.tianyi.main.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tianyi.main.dao.UserInfoDao;
import com.tianyi.main.dto.TokenDto;

@Component
public class TokenUtil {

	
	private static UserInfoDao userInfoDao;
	

	public static boolean checkTokenValid(HttpServletRequest request){
		
		String token = request.getHeader("Authorization");
		
		if(userInfoDao == null) return false;
		
		TokenDto tokenDto = userInfoDao.getTokenDto(token);
		
		if(tokenDto == null) return false;
		
		Long validEnd = tokenDto.getCreateTime().getTime() + tokenDto.getValidTime();
		
		if(validEnd < System.currentTimeMillis()) return false;
	
		return true;
	}

	
	public static void writeFailResponse(HttpServletResponse response){
		
		try {
			PrintWriter writer = response.getWriter();
			writer.println("wrong token");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
		
	}

	
	

	@Autowired
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		TokenUtil.userInfoDao = userInfoDao;
	}
	
	

	
	
}
