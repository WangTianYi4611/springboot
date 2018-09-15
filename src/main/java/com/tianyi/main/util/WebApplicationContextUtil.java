package com.tianyi.main.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

public class WebApplicationContextUtil {

	private static ApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
	
    public static Object getBean(String name) throws BeansException {  
        return applicationContext.getBean(name);  
    }  
	
	
}
