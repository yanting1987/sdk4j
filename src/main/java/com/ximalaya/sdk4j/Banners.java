package com.ximalaya.sdk4j;

import java.util.List;

import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.model.DTOValidateUtil;
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
	
	/**
	 * 获取榜单的焦点图列表。
	 * @param channel
	 * @param appVersion
	 * @param imageScale
	 * @return
	 * @throws XimalayaException
	 */
	public List<Banner> getRankBanners(String channel, String appVersion, int imageScale) throws XimalayaException {
		DTOValidateUtil.validateChannel(channel);
		DTOValidateUtil.validateAppVersion(appVersion);
		DTOValidateUtil.validateImageScale(imageScale);
		HttpParameter[] specificParams = new HttpParameter[3];
		specificParams[0] = new HttpParameter("channel", channel);
		specificParams[1] = new HttpParameter("app_version", appVersion);
		specificParams[2] = new HttpParameter("image_scale", imageScale);
		return Banner.constructBanners(
			CLIENT.get(String.format("%s/banners/rank_banners", BASE_URL), 
					assembleHttpParams(specificParams)));
	}
}
