package com.ximalaya.sdk4j;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.Banners;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.banner.Banner;


public class BannersTest {

	Banners bannerService = new Banners();
	
	@Test
	public void testGetRankBanners() throws XimalayaException {
		List<Banner> banners = bannerService.getRankBanners("and-f5", "4.3.2.2", 2);
		Assert.assertTrue(banners != null && banners.size() > 0);
	}
	
	@Test
	public void testGetCategoryBanners() throws XimalayaException {
		List<Banner> banners = bannerService.getCategoryBanners("and-f5", "3.2.2", 2, 3);
		Assert.assertTrue(banners != null && banners.size() > 0);
	}
	
	@Test
	public void testGetDiscoveryBanners() throws XimalayaException {
		List<Banner> banners = bannerService.getDiscoveryBanners("and-f5", "4.3.2.2", 2);
		Assert.assertTrue(banners != null && banners.size() > 0);
	}
}
