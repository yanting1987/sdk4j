package com.ximalaya.sdk4j.http;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.XimalayaException;

public class HttpClientTest {
	
	HttpClient httpClient = new HttpClient();
	
	@Test
	public void testGet() throws XimalayaException {
		String responseStr = httpClient.get("http://baidu.com").asString();
		Assert.assertTrue(responseStr != null && responseStr.contains("http://www.baidu.com/"));
	}

}
