package com.ximalaya.sdk4j.util;

import junit.framework.Assert;

import org.junit.Test;

public class CrypterUtilTest {
	
	@Test
	public void testGetRandKey() {
		String key = CrypterUtil.getRandKey();
		Assert.assertNotNull(key);
		Assert.assertFalse(key.isEmpty());
	}

}
