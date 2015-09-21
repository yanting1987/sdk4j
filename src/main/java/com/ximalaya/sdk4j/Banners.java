package com.ximalaya.sdk4j;

import java.util.List;

import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.model.DTOValidateUtil;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.Album;
import com.ximalaya.sdk4j.model.dto.banner.Banner;
import com.ximalaya.sdk4j.model.dto.track.Track;

public class Banners extends Ximalaya {
	private static final long serialVersionUID = -8651526987345601726L;

	/**
	 * 获取喜马拉雅PC端Web站点焦点图列表。
	 * @return
	 * @throws XimalayaException
	 */
	public List<Banner> getVehicleBanners() throws XimalayaException {
		return Banner.constructVehicleBanners(
			CLIENT.get(String.format("%s/banners/vehicle_banners", BASE_URL), 
					assembleHttpParams()));
	}
	
	/**
	 * 获取榜单的焦点图列表。
	 * @param channel	 app的渠道号（对应渠道焦点图配置）
	 * @param appVersion app版本号
	 * @param imageScale 控制焦点图图片大小参数，scale=2为iphone适配类型，scale=3为iphone6适配机型，对于Android一般设为2
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
	
	/**
	 * 获取分类推荐焦点图列表。内容类型：暂时仅专辑(album)
	 * @param channel	 app的渠道号（对应渠道焦点图配置）
	 * @param appVersion app版本号
	 * @param imageScale 控制焦点图图片大小参数，scale=2为iphone适配类型，scale=3为iphone6适配机型，对于Android一般设为2
	 * @param categoryId 分类ID
	 * @return
	 * @throws XimalayaException
	 */
	public List<Banner> getCategoryBanners(String channel, String appVersion, int imageScale, long categoryId)
			throws XimalayaException {
		DTOValidateUtil.validateChannel(channel);
		DTOValidateUtil.validateAppVersion(appVersion);
		DTOValidateUtil.validateImageScale(imageScale);
		DTOValidateUtil.validateCategoryID(categoryId);
		HttpParameter[] specificParams = new HttpParameter[5];
		specificParams[0] = new HttpParameter("channel", channel);
		specificParams[1] = new HttpParameter("app_version", appVersion);
		specificParams[2] = new HttpParameter("image_scale", imageScale);
		specificParams[3] = new HttpParameter("category_id", categoryId);
		specificParams[4] = new HttpParameter("content_type", "album");
		return Banner.constructBanners(
			CLIENT.get(String.format("%s/banners/category_banners", BASE_URL), 
					assembleHttpParams(specificParams)));
	}
	
	/**
	 * 获取发现页的焦点图列表。
	 * @param channel	 app的渠道号（对应渠道焦点图配置）
	 * @param appVersion app版本号
	 * @param imageScale 控制焦点图图片大小参数，scale=2为iphone适配类型，scale=3为iphone6适配机型，对于Android一般设为2
	 * @return
	 * @throws XimalayaException
	 */
	public List<Banner> getDiscoveryBanners(String channel, String appVersion, int imageScale) throws XimalayaException {
		DTOValidateUtil.validateChannel(channel);
		DTOValidateUtil.validateAppVersion(appVersion);
		DTOValidateUtil.validateImageScale(imageScale);
		HttpParameter[] specificParams = new HttpParameter[3];
		specificParams[0] = new HttpParameter("channel", channel);
		specificParams[1] = new HttpParameter("app_version", appVersion);
		specificParams[2] = new HttpParameter("image_scale", imageScale);
		return Banner.constructBanners(
			CLIENT.get(String.format("%s/banners/discovery_banners", BASE_URL), 
					assembleHttpParams(specificParams)));
	}
	
	/**
	 * 获取分类推荐焦点声音图列表
	 * @param channel	 app的渠道号（对应渠道焦点图配置）
	 * @param appVersion app版本号
	 * @param imageScale 控制焦点图图片大小参数，scale=2为iphone适配类型，scale=3为iphone6适配机型，对于Android一般设为2
	 * @param categoryId 分类ID
	 * @param count      返回的声音焦点图个数
	 * @return
	 * @throws XimalayaException
	 */
	public List<Banner> getCategoryTrackBanners(String channel, String appVersion, int imageScale, long categoryId, int count)
			throws XimalayaException {
		DTOValidateUtil.validateCategoryID(categoryId);
		DTOValidateUtil.validateCount(count);
		HttpParameter[] specificParams = new HttpParameter[5];
		specificParams[0] = new HttpParameter("channel", channel);
		specificParams[1] = new HttpParameter("app_version", appVersion);
		specificParams[2] = new HttpParameter("image_scale", imageScale);
		specificParams[3] = new HttpParameter("category_id", categoryId);
		specificParams[4] = new HttpParameter("count", count);
		return Banner.constructBanners(
			CLIENT.get(String.format("%s/banners/category_track_banners", BASE_URL), 
					assembleHttpParams(specificParams)));
	}
	
	/**
	 * 获取发现页的声音焦点图列表。
	 * @param channel	 app的渠道号（对应渠道焦点图配置）
	 * @param appVersion app版本号
	 * @param imageScale 控制焦点图图片大小参数，scale=2为iphone适配类型，scale=3为iphone6适配机型，对于Android一般设为2
	 * @param count  	  返回的声音焦点图个数
	 * @return
	 * @throws XimalayaException
	 */
	public List<Banner> getDiscoveryTrackBanners(String channel, String appVersion, int imageScale, int count) throws XimalayaException {
		DTOValidateUtil.validateCount(count);
		HttpParameter[] specificParams = new HttpParameter[4];
		specificParams[0] = new HttpParameter("channel", channel);
		specificParams[1] = new HttpParameter("app_version", appVersion);
		specificParams[2] = new HttpParameter("image_scale", imageScale);
		specificParams[3] = new HttpParameter("count", count);
		return Banner.constructBanners(
			CLIENT.get(String.format("%s/banners/discovery_track_banners", BASE_URL), 
					assembleHttpParams(specificParams)));
	}
	
	/**
	 * 根据多声音焦点图ID获取声音列表。
	 * @param trackBannerID	多声音焦点图ID
	 * @return
	 * @throws XimalayaException
	 */
	public List<Track> getBannerTracks(int trackBannerID) throws XimalayaException {
		DTOValidateUtil.validateBannerID(trackBannerID);
		HttpParameter[] specificParams = new HttpParameter[2];
		specificParams[0] = new HttpParameter("banner_id", trackBannerID);
		specificParams[1] = new HttpParameter("banner_content_type", 7);
		return Track.constructTrackContents(
			CLIENT.get(String.format("%s/banners/get_content_list", BASE_URL), 
					assembleHttpParams(specificParams)));
	}
	
	/**
	 * 根据多专辑焦点图ID专辑列表。
	 * @param albumBannerID 多专辑焦点图ID
	 * @return
	 * @throws XimalayaException
	 */
	public List<Album> getBannerAlbums(int albumBannerID) throws XimalayaException {
		DTOValidateUtil.validateBannerID(albumBannerID);
		HttpParameter[] specificParams = new HttpParameter[2];
		specificParams[0] = new HttpParameter("banner_id", albumBannerID);
		specificParams[1] = new HttpParameter("banner_content_type", 6);
		return Album.constructAlbums(
			CLIENT.get(String.format("%s/banners/get_content_list", BASE_URL), 
					assembleHttpParams(specificParams)));
	}
}
