package com.ximalaya.sdk4j.util;

import junit.framework.Assert;

import org.junit.Test;

public class StringUtilTest {
	
	@Test
	public void testJoin() {
		Assert.assertEquals("1,2,3", StringUtil.join(new long[] {1, 2, 3}, ","));
	}

}
