package com.ximalaya.sdk4j;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.ColdBoot;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.coldboot.ColdBootDetail;
import com.ximalaya.sdk4j.model.dto.coldboot.ColdBootTag;

public class ColdBootTest {

	ColdBoot coldbootService = new ColdBoot();

	@Test
	public void testGetColdBootCategories() throws XimalayaException {
		Assert.assertTrue(coldbootService.getColdBootGenres().size() > 0);
	}

	@Test
	public void testGetColdBootSubCategories() throws XimalayaException {
		Assert.assertTrue(coldbootService.getColdBootSubGenres().size() > 0);
	}

	@Test
	public void testGetColdBootTag() throws XimalayaException {
		ColdBootTag tag = coldbootService.getColdBootTag("帅哥", "上班族");
		Assert.assertTrue(tag != null && tag.getColdBootTags().size() > 0);
	}

	public void testSubmitColdBootTag() throws XimalayaException {
		String[] tags = new String[]{"资讯", "公开课", "动漫游戏", "音乐", "相声"};
		coldbootService.submitColdBootTag("帅哥", "上班族", 2, "your deviceId", tags);
	}
	
	public void testGetColdBootDetail() throws XimalayaException {
		ColdBootDetail detail = coldbootService.getColdBootDetail(2, "your deviceId");
		Assert.assertTrue(detail != null && detail.getColdBootTags().size() > 0);
	}
}
