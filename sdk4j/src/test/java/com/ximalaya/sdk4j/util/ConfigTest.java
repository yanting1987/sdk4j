package com.ximalaya.sdk4j.util;

import junit.framework.Assert;

import org.junit.Test;

public class ConfigTest {
	
	@Test
	public void testUpdateProperty() {
		Assert.assertEquals("abc", Config.getValue("app_key"));
	}

}
