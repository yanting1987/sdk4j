package com.ximalaya.sdk4j;

import java.util.List;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.live.City;

public class LiveTestMain {
	
	private static final Lives liveService = new Lives();
	
	public static void main(String[] args) throws XimalayaException {
//		liveService.getProvinces();
//		List<City> cities = liveService.getCityByProvince("140000");
//		for(City c: cities) {
//		liveService.getRadioList(2, null, new Paging());
//			liveService.getRadioList(2, String.valueOf(c.getCityCode()), new Paging());
////		}
		
		
		
//		liveService.getProvinces();
//		liveService.getRadioList(3, null, new Paging());
		
//		liveService.getSchedules(1078);
//		liveService.getSchedules(12);
//		liveService.getSchedules(3000);
		
//		liveService.getPlayingProgram(12);
//		liveService.getPlayingProgram(12000);
		
		liveService.getRadiosByCity(1401, new Paging());
		
//		liveService.getProvinces();
		// 130000 河北 110000 北京
//		liveService.getCityByProvince("130000");
//		liveService.getRadiosByCity(1100, new Paging());
//		liveService.getRadiosByCity(110000, new Paging());
//		liveService.getRadiosByCity(1301, new Paging());
//		liveService.getRadiosByCity(1333, new Paging());
		
//		liveService.batchGetRadios(new long[] { 12, 1078, 190000 });
	}

}
