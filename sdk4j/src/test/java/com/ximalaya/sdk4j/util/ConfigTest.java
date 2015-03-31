package com.ximalaya.sdk4j.util;

import junit.framework.Assert;

import org.junit.Test;

public class ConfigTest {
	
	@Test
	public void testUpdateProperty() {
		String appKey = XimalayaConfig.getValue("ximalaya.openapi.app_key");
		Assert.assertNotNull(appKey);
		Assert.assertTrue(appKey.length() == 32);
	}

}
