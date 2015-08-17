package com.ximalaya.sdk4j;

import java.util.List;

import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.banner.Banner;

public class Banners extends Ximalaya {
	private static final long serialVersionUID = -8651526987345601726L;

	/**
	 * 获取喜马拉雅PC端Web站点焦点图列表。
	 * @return
	 * @throws XimalayaException
	 */
	public List<Banner> getVehicleBanners() throws XimalayaException {
		return Banner.constructBanners(
			CLIENT.get(String.format("%s/banners/vehicle_banners", BASE_URL), 
					assembleHttpParams()));
	}
}
