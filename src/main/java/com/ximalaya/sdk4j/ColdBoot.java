package com.ximalaya.sdk4j;

import java.util.List;

import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.model.DTOValidateUtil;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.coldboot.ColdBootDetail;
import com.ximalaya.sdk4j.model.dto.coldboot.ColdBootTag;
import com.ximalaya.sdk4j.util.StringUtil;

/**
 * 喜马拉雅内容分类
 * @author will
 *
 */
public class ColdBoot extends Ximalaya {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5338362069555289938L;
	
	/**
	 * 获取喜马拉雅冷启动一级分类
	 * 
	 * @return
	 * @throws XimalayaException
	 */
	public List<String> getColdBootGenres() throws XimalayaException {
		return ColdBootTag.constructColdBootTags(
				CLIENT.get(String.format("%s/coldboot/genres", BASE_URL), assembleHttpParams()));
	}

	/**
	 * 获取喜马拉雅冷启动二级分类
	 * @return
	 * @throws XimalayaException
	 */
	public List<String> getColdBootSubGenres() throws XimalayaException {
		return ColdBootTag.constructColdBootTags(
				CLIENT.get(String.format("%s/coldboot/sub_genres", BASE_URL), assembleHttpParams()));
	}
	
	/**
	 * 根据冷启动一级分类和冷启动二级分类获取相应类别下的冷启动标签列表
	 * @param	coldbootGenre		必填		一级分类标签
	 * @param	coldbootSubGenre		必填		二级分类标签
	 * @return
	 * @throws XimalayaException
	 */
	public ColdBootTag getColdBootTag(String coldbootGenre, String coldbootSubGenre) throws XimalayaException {
		DTOValidateUtil.validateColdbootGenre(coldbootGenre);
		DTOValidateUtil.validateColdbootSubGenre(coldbootSubGenre);
        HttpParameter[] specificParams = new HttpParameter[2];
        specificParams[0] = new HttpParameter("coldboot_genre", coldbootGenre);
        specificParams[1] = new HttpParameter("coldboot_sub_genre", coldbootSubGenre);
		return new ColdBootTag(CLIENT.get(String.format("%s/coldboot/tags",
				BASE_URL), assembleHttpParams(specificParams)).asJSONObject());
	}
	
	/**
	 * 提交用户感兴趣的和设备相关的冷启动标签
	 * @param	coldbootGenre		必填		一级分类标签
	 * @param	coldbootSubGenre		必填		二级分类标签
	 * @param 	deviceType 				必填		1-ios，2-android，3-pc
	 * @param 	deviceId				必填  		设备唯一标识
	 * @param	tags					必填		用户勾选的感兴趣的冷启动标签列表
	 * @return
	 * @throws XimalayaException
	 */
	public void submitColdBootTag(String coldbootGenre, String coldbootSubGenre,
			Integer deviceType, String deviceId, String[] tags) throws XimalayaException {
		DTOValidateUtil.validateColdbootGenre(coldbootGenre);
		DTOValidateUtil.validateColdbootSubGenre(coldbootSubGenre);
		DTOValidateUtil.validateDeviceType(deviceType);
		DTOValidateUtil.validateDeviceId(deviceId);
		if (tags == null || tags.length == 0) {
			throw new IllegalArgumentException("tags should be specified");
        }
        HttpParameter[] specificParams = new HttpParameter[5];
        specificParams[0] = new HttpParameter("coldboot_genre", coldbootGenre);
        specificParams[1] = new HttpParameter("coldboot_sub_genre", coldbootSubGenre);
        specificParams[2] = new HttpParameter("device_type", deviceType);
        specificParams[3] = new HttpParameter("device_id", deviceId);
        specificParams[4] = new HttpParameter("coldboot_tags", StringUtil.join(tags, ","));
        CLIENT.post(String.format("%s/coldboot/submit_tags", BASE_URL), assembleHttpParams(specificParams));
	}
	
	
	/**
	 * 获取用户提交的冷启动标签详情
	 * @param deviceType 	必填		1-ios，2-android，3-pc
	 * @param deviceId		必填  		设备唯一标识
	 * @return
	 * @throws XimalayaException
	 */
	public ColdBootDetail getColdBootDetail(Integer deviceType, String deviceId) throws XimalayaException {
		DTOValidateUtil.validateDeviceType(deviceType);
		DTOValidateUtil.validateDeviceId(deviceId);
        HttpParameter[] specificParams = new HttpParameter[2];
        specificParams[0] = new HttpParameter("device_type", deviceType);
        specificParams[1] = new HttpParameter("device_id", deviceId);
		return new ColdBootDetail(CLIENT.get(String.format("%s/coldboot/detail",
				BASE_URL), assembleHttpParams(specificParams)).asJSONObject());
	}
}
