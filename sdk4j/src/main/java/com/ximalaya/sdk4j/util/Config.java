package com.ximalaya.sdk4j.util;

import java.io.IOException;
import java.util.Properties;

public class Config {
	private static Properties props = new Properties(); 
	static{
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Config(){}
	
	public static String getValue(String key){
		return props.getProperty(key);
	}

	/**
	 * 更新内存中某项配置的值，注意调用该方法不会更新config.properties文件中对应配置项的值
	 * @param key
	 * @param value
	 */
    public static void updateProperty(String key,String value) {    
            props.setProperty(key, value); 
    } 
}
