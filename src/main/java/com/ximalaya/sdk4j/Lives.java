package com.ximalaya.sdk4j;

import java.util.Date;
import java.util.List;

import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.DTOValidateUtil;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.live.*;
import com.ximalaya.sdk4j.util.StringUtil;

/**
 * 直播相关接口
 * @author will
 *
 */
public class Lives extends Ximalaya {

	/**
	 * 
	 */
	private static final long serialVersionUID = 523186493386608032L;
	
	/**
	 * 获取直播省市列表
	 * @return
	 * @throws XimalayaException
	 */
	public List<Province> getProvinces() throws XimalayaException {
		return Province.constructProvinces(
				CLIENT.get(String.format("%s/live/provinces", BASE_URL), assembleHttpParams()));
	}
	
	/**
	 * 根据电台类型、省份代码（由上面的<code>getProvinces()</code>获得）
	 * 获取直播电台列表
	 * @param radioType 1-国家台，2-省市台，3-网络台
	 * @param provinceCode 省市代码，如果radioType为2则必须指定该参数
	 * @param paging 分页参数
	 * @return
	 * @throws XimalayaException
	 */
	public RadioList getRadioList(int radioType, String provinceCode, Paging paging) throws XimalayaException {
		DTOValidateUtil.validateRadioTypeAndProvinceCode(radioType, provinceCode);
		paging = paging == null ? new Paging(): paging;
		
		HttpParameter[] specificParams = null;
		if(!StringUtil.isEmpty(provinceCode)) {
			specificParams = new HttpParameter[4];
			specificParams[0] = new HttpParameter("radio_type", radioType);
			specificParams[1] = new HttpParameter("province_code", provinceCode);
			specificParams[2] = new HttpParameter("page", paging.getPage());
			specificParams[3] = new HttpParameter("count", paging.getCount());
		}
		else {
			specificParams = new HttpParameter[3];
			specificParams[0] = new HttpParameter("radio_type", radioType);
			specificParams[1] = new HttpParameter("page", paging.getPage());
			specificParams[2] = new HttpParameter("count", paging.getCount());
		}
		return Radio.constructRadioList(
				CLIENT.get(String.format("%s/live/radios", BASE_URL),
						assembleHttpParams(specificParams)));
	}
	
	/**
	 * 根据直播电台ID获取当天节目时间表
	 * @param radioID 直播电台ID
	 * @return
	 * @throws XimalayaException
	 */
	@SuppressWarnings("deprecation")
	public List<Schedule> getSchedules(long radioID) throws XimalayaException {
		return getSchedules(radioID, new Date().getDay());
	}
	
	/**
	 * 获取某个直播电台某一天的节目排期的列表。
	 * @param radioID 直播电台ID
	 * @param weekday 0-星期天，1-星期一，...，6-星期六
	 * @return
	 * @throws XimalayaException
	 */
	public List<Schedule> getSchedules(long radioID, int weekday) throws XimalayaException {
		DTOValidateUtil.validateRadioID(radioID);
		DTOValidateUtil.validateWeekday(weekday);
		HttpParameter[] specificParameters = new HttpParameter[2];
		specificParameters[0] = new HttpParameter("radio_id", radioID);
		specificParameters[1] = new HttpParameter("weekday", weekday);
		return Schedule.constructSchedules(CLIENT.get(String.format("%s/live/schedules", BASE_URL),
				assembleHttpParams(specificParameters)));
	}
	
	/**
	 * 根据直播电台ID获取对应直播电台正在直播的节目详情
	 * @param radioID 直播电台ID
	 * @return
	 * @throws XimalayaException
	 */
	public Program getPlayingProgram(long radioID) throws XimalayaException {
		DTOValidateUtil.validateRadioID(radioID);
		return new Program(
				CLIENT.get(String.format("%s/live/get_playing_program", BASE_URL), 
				            assembleHttpParams(new HttpParameter[] { new HttpParameter("radio_id", radioID) })));
	}


	public List<City> getCityByProvince(int provinceCode)throws XimalayaException{
		HttpParameter[] specificParameters = new HttpParameter[1];
		specificParameters[0] = new HttpParameter("province_code", provinceCode);
	    HttpResponse response= CLIENT.get(String.format("%s/live/cities", BASE_URL),assembleHttpParams(specificParameters) );
		return City.constructCities(response);
	}


	public RadioList getRadiosByCity(int cityCode,int page,int count)throws XimalayaException{
		HttpParameter[] specificParameters = new HttpParameter[3];
		specificParameters[0] = new HttpParameter("city_code", cityCode);
		specificParameters[1] = new HttpParameter("page", page);
		specificParameters[2] = new HttpParameter("count", count);
		HttpResponse response= CLIENT.get(String.format("%s/live/get_radios_by_city", "http://127.0.0.1:8084/openapi-gateway-app"),assembleHttpParams(specificParameters) );
		return Radio.constructRadioList(response);
	}
	
}
