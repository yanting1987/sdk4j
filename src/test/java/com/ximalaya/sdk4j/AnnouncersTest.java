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

	@Test
	public void testGetAnnouncerAlbums() throws XimalayaException {
		Assert.assertTrue(announcerService.getAnnouncerAlbums(2629294, new Paging()) != null);
	}
	
	@Test
	public void testBatchGetAnnouncers() throws XimalayaException {
		Assert.assertTrue(announcerService.batchGetAnnouncers(new long[]{2629294}).size() > 0);
	}
}
