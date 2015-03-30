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

    public static void updateProperty(String key,String value) {    
            props.setProperty(key, value); 
    } 
}
