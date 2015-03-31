package com.ximalaya.sdk4j;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.HttpParameter;

public class XimalayaTest {
	
	@Test
	public void testAssembleHttpParams() {
		Ximalaya ximalaya = new Ximalaya();
		HttpParameter[] httpParams = ximalaya.assembleHttpParams();
		Assert.assertTrue(httpParams != null && httpParams.length == 5);
	}

}
