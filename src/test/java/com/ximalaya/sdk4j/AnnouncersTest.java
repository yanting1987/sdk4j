package com.ximalaya.sdk4j;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;

public class AnnouncersTest {

	Announcers announcerService = new Announcers();

	@Test
	public void testGetAnnouncerCategories() throws XimalayaException {
		Assert.assertTrue(announcerService.getAnnouncerCategories().size() > 0);
	}

	@Test
	public void testGetColdBootSubCategories() throws XimalayaException {
		Assert.assertTrue(announcerService.getAnnouncerList(0, 1, new Paging()) != null);
	}

}
