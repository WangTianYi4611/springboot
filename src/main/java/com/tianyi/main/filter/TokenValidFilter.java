package com.tianyi.main.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import com.tianyi.main.controller.LoginController;
import com.tianyi.main.util.TokenUtil;


@Order(1)
//重点
@WebFilter(filterName = "tokenValidFilter", urlPatterns = "/*")
public class TokenValidFilter implements Filter{

	private Logger logger = LoggerFactory.getLogger(TokenValidFilter.class);
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		logger.info("filter test");
		
		String uri = servletRequest.getRequestURI();
		logger.info("request url is{}",uri);
		if(uri.contains("login")){
			chain.doFilter(request, response);
			return;
		}
		
		//token验证
		boolean isValid = TokenUtil.checkTokenValid(servletRequest);
		if(!isValid){
			logger.error("not allow");
			TokenUtil.writeFailResponse(servletResponse);
			return;
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
