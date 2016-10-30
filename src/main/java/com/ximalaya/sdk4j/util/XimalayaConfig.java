package com.ximalaya.sdk4j.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class XimalayaConfig {
	private static Properties props = new Properties();
	private static final String CONFIG_FILE_NAME = "config.properties";
	private static final String BASE_URL_CONFIG_KEY = "ximalaya.openapi.baseURL";
	private static final String APP_KEY_CONFIG_KEY = "ximalaya.openapi.appKey";
	private static final String APP_SECRET_CONFIG_KEY = "ximalaya.openapi.appSecret";
	private static final String SERVER_AUTHENTICATE_STATIC_KEY_CONFIG_KEY = "ximalaya.openapi.serverAuthenticateStaticKey";
	
	static{
		InputStream configStream = ClassLoader.getSystemClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
		if(configStream == null) {
			configStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
		}
		try {
			props.load(configStream);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getValue(String key){
		return props.getProperty(key);
	}
	
	public static String getBaseUrl() {
		return getValue(BASE_URL_CONFIG_KEY);
	}
	
	public static String getAppKey() {
		return getValue(APP_KEY_CONFIG_KEY);
	}
	
	public static String getAppSecret() {
		return getValue(APP_SECRET_CONFIG_KEY);
	}
	
	public static String getServerAuthenticateStaticKey() {
		return getValue(SERVER_AUTHENTICATE_STATIC_KEY_CONFIG_KEY);
	}
	
	public static void switchConfig(String newConfigFilePath) {
		InputStream configStream = ClassLoader.getSystemClassLoader().getResourceAsStream(newConfigFilePath);
		if(configStream == null) {
			configStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(newConfigFilePath);
		}
		try {
			props.load(configStream);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
}
