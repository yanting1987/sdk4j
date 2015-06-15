package com.ximalaya.sdk4j.model;

import com.ximalaya.sdk4j.util.StringUtil;

public class DTOValidateUtil {
	
	public static void validateCategoryID(long categoryID) {
		if(categoryID < 0) {
			throw new IllegalArgumentException("categoryID should >= 0");
		}
	}
	
	public static void validateAlbumID(long albumID) {
		if(albumID <= 0) {
			throw new IllegalArgumentException("albumID should > 0");
		}
	}
	
	public static void validateRadioTypeAndProvinceCode(int radioType, String provinceCode) {
		if(radioType < 1 || radioType > 3) {
			throw new IllegalArgumentException("radioType should >= 1 and <= 3");
		}
		if(radioType == 2 && StringUtil.isEmpty(provinceCode)) {
			throw new IllegalArgumentException("provinceCode should be specified when radioType equals to 2");
		}
	}
	
	public static void validateRadioID(long radioID) {
		if(radioID <= 0) {
			throw new IllegalArgumentException("radio_id should > 0");
		}
	}
	
	public static void validateWeekday(int weekday) {
		if(weekday < 0 || weekday > 6) {
			throw new IllegalArgumentException("weekday should >= 0 and <= 6");
		}
	}

}
