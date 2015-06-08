package com.ximalaya.sdk4j;

import java.util.Date;
import java.util.List;

import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.live.Program;
import com.ximalaya.sdk4j.model.dto.live.Province;
import com.ximalaya.sdk4j.model.dto.live.Radio;
import com.ximalaya.sdk4j.model.dto.live.RadioList;
import com.ximalaya.sdk4j.model.dto.live.Schedule;
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
		checkRadioTypeAndProvinceCode(radioType, provinceCode);
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
	 * 根据直播电台ID获取昨天、今天和明天共三天的节目时间表
	 * @param radioID 直播电台ID
	 * @return
	 * @throws XimalayaException
	 */
	@SuppressWarnings("deprecation")
	public List<Schedule> getSchedules(int radioID) throws XimalayaException {
		return getSchedules(radioID, new Date().getDay());
	}
	
	/**
	 * 根据直播电台ID获取昨天、今天（由weekday决定）和明天共三天的节目时间表
	 * @param radioID 直播电台ID
	 * @param weekday 0-星期天，1-星期一，...，6-星期六
	 * @return
	 * @throws XimalayaException
	 */
	public List<Schedule> getSchedules(int radioID, int weekday) throws XimalayaException {
		checkRadioID(radioID);
		checkWeekday(weekday);
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
	public Program getPlayingProgram(int radioID) throws XimalayaException {
		checkRadioID(radioID);
		return new Program(
				CLIENT.get(String.format("%s/live/get_playing_program", BASE_URL), 
				            assembleHttpParams(new HttpParameter[] { new HttpParameter("radio_id", radioID) })));
	}
	
	private void checkRadioTypeAndProvinceCode(int radioType, String provinceCode) {
		if(radioType < 1 || radioType > 3) {
			throw new IllegalArgumentException("radioType should >= 1 and <= 3");
		}
		if(radioType == 2 && StringUtil.isEmpty(provinceCode)) {
			throw new IllegalArgumentException("provinceCode should be specified when radioType equals to 2");
		}
	}
	
	private void checkRadioID(int radioID) {
		if(radioID <= 0) {
			throw new IllegalArgumentException("radio_id should > 0");
		}
	}
	
	private void checkWeekday(int weekday) {
		if(weekday < 0 || weekday > 6) {
			throw new IllegalArgumentException("weekday should >= 0 and <= 6");
		}
	}

}
