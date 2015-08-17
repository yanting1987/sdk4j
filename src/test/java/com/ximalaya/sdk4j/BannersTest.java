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
	public void testGetVehicleBanners() throws XimalayaException {
		List<Banner> banners = bannerService.getVehicleBanners();
		Assert.assertTrue(banners != null && banners.size() > 0);
	}
	
	@Test
	public void testGetRankBanners() throws XimalayaException {
		List<Banner> banners = bannerService.getRankBanners("ios-dev", "3.1.37", 2);
		Assert.assertTrue(banners != null && banners.size() > 0);
	}
}
