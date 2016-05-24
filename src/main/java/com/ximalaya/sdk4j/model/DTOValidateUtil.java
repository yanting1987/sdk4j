package com.ximalaya.sdk4j.model;

import java.util.List;

import com.ximalaya.sdk4j.model.dto.upload.LiveRecord;
import com.ximalaya.sdk4j.model.dto.upload.TrackRecord;
import com.ximalaya.sdk4j.util.StringUtil;

public class DTOValidateUtil {
	
	public static void validateCategoryID(long categoryID) {
		if(categoryID < 0) {
			throw new IllegalArgumentException("categoryID should >= 0");
		}
	}
	
	public static void validateCount(long count) {
		if(count < 0) {
			throw new IllegalArgumentException("count should >= 0");
		}
	}
	
	public static void validateBannerID(long BannerID) {
		if(BannerID < 0) {
			throw new IllegalArgumentException("BannerID should >= 0");
		}
	}
	
	public static void validateCalcDimension(long calcDimension) {
		if(calcDimension < 0) {
			throw new IllegalArgumentException("calcDimension should >= 0");
		}
	}
	
	public static void validateRankType(int rankType) {
		if(!(rankType == 1 || rankType == 2)) {
			throw new IllegalArgumentException("This rankType is not supported");
		}
	}
	
	public static void validateRankKey(String rankKey) {
		if(StringUtil.isEmpty(rankKey)) {
			throw new IllegalArgumentException("RankKey should not be empty");
		}
	}
	
	public static void validateImageScale(int imageScale) {
		if(!(imageScale == 2 || imageScale == 3)) {
			throw new IllegalArgumentException("This imageScale is not supported");
		}
	}
	
	public static void validateChannel(String channel) {
		if(StringUtil.isEmpty(channel)) {
			throw new IllegalArgumentException("Channel should not be empty");
		}
	}
	
	public static void validateAppVersion(String appVersion) {
		if(StringUtil.isEmpty(appVersion)) {
			throw new IllegalArgumentException("AppVersion should not be empty");
		}
	}
	
	public static void validateColumnID(long columnID) {
		if(columnID < 0) {
			throw new IllegalArgumentException("ColumnID should >= 0");
		}
	}
	
	public static void validateRadioCount(int radioCount) {
		if(radioCount < 0) {
			throw new IllegalArgumentException("RadioCount should >= 0");
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

	public static void validateProvinceCode(String provinceCode) {
		if(StringUtil.isEmpty(provinceCode)) {
			throw new IllegalArgumentException("provinceCode should be specified");
		}
	}

	public static void validateDeviceType(int deviceType) {
		if(deviceType != 1 && deviceType != 2 && deviceType != 3) {
    		throw new IllegalArgumentException("device_type must be 1-ios or 2-android or 3-pc");
    	}
	}

	public static void validateDeviceId(String deviceId) {
		if(StringUtil.isEmpty(deviceId)) {
    		throw new IllegalArgumentException("deviceId cannot be empty");
    	}
	}

	public static void validateAnnouncerId(int aid) {
		if(aid <= 0) {
			throw new IllegalArgumentException("aid should > 0");
		}
	}

	public static void validateColdbootGenre(String coldbootGenre) {
		if(StringUtil.isEmpty(coldbootGenre)) {
			throw new IllegalArgumentException("coldbootGenre should not be empty");
		}
	}
	
	public static void validateColdbootSubGenre(String coldbootSubGenre) {
		if(StringUtil.isEmpty(coldbootSubGenre)) {
			throw new IllegalArgumentException("coldbootSubGenre should not be empty");
		}
	}

	public static void validateIconSetID(int iconSetId) {
		if(iconSetId <= 0) {
			throw new IllegalArgumentException("iconSetId should > 0");
		}
	}

	public static void validateTracklistID(int tracklistId) {
		if(tracklistId <= 0) {
			throw new IllegalArgumentException("tracklistId should > 0");
		}
	}

	public static void validateLiveRecord(LiveRecord liveRecord) {
		if(liveRecord == null) {
			throw new IllegalArgumentException("liveRecord should not be null");
		}
		if(liveRecord.getRadio_id() == null) {
			throw new IllegalArgumentException("liveRecord.radioId should not be null");
		}
		if(liveRecord.getDuration() == null) {
			throw new IllegalArgumentException("liveRecord.duration should not be null");
		}
		if(liveRecord.getPlayed_secs() == null) {
			throw new IllegalArgumentException("liveRecord.playedSecs should not be null");
		}
	}

	public static void validateTrackRecord(TrackRecord trackRecord) {
		if(trackRecord == null) {
			throw new IllegalArgumentException("trackRecord should not be null");
		}
		if(trackRecord.getTrack_id() == null) {
			throw new IllegalArgumentException("trackRecord.trackId should not be null");
		}
		if(trackRecord.getDuration() == null) {
			throw new IllegalArgumentException("trackRecord.duration should not be null");
		}
		if(trackRecord.getPlayed_secs() == null) {
			throw new IllegalArgumentException("trackRecord.playedSecs should not be null");
		}
		if(trackRecord.getPlay_type() == null) {
			throw new IllegalArgumentException("trackRecord.playType should not be null");
		}
	}

	private static final int BATCH_UPLOAD_MAX_COUNT = 200;
	
	public static void validateLiveRecords(List<LiveRecord> liveRecords) {
		if(liveRecords == null) {
			throw new IllegalArgumentException("liveRecords should not be null");
		}
		int size = liveRecords.size();
		if(size > BATCH_UPLOAD_MAX_COUNT) {
			throw new IllegalArgumentException("liveRecords size should be less than " + BATCH_UPLOAD_MAX_COUNT);
		}
		for(int i = 0; i < liveRecords.size(); i++) {
			validateLiveRecord(liveRecords.get(i));
		}
	}

	public static void validateTrackRecords(List<TrackRecord> trackRecords) {
		if(trackRecords == null) {
			throw new IllegalArgumentException("trackRecords should not be null");
		}
		int size = trackRecords.size();
		if(size > BATCH_UPLOAD_MAX_COUNT) {
			throw new IllegalArgumentException("trackRecords size should be less than " + BATCH_UPLOAD_MAX_COUNT);
		}
		for(int i = 0; i < size; i++) {
			validateTrackRecord(trackRecords.get(i));
		}
	}
}
