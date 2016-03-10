package com.ximalaya.sdk4j;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.DTOValidateUtil;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;
import com.ximalaya.sdk4j.model.dto.upload.LiveRecord;
import com.ximalaya.sdk4j.model.dto.upload.TrackRecord;

/**
 * 
 * @author william.zhang
 *
 */
public class DataUpload extends Ximalaya {
	private static final long serialVersionUID = -5640100416487728247L;
	private static final String ORIGINAL_PROJECT_NAME = "openapi-gateway-app";
	private static final String DATA_UPLOAD_PROJECT_NAME = "openapi-collector-app";
	private static String DATA_UPLOAD_URL;

	static {
		if(!BASE_URL.contains(ORIGINAL_PROJECT_NAME)) {
			DATA_UPLOAD_URL = BASE_URL.concat("/").concat(DATA_UPLOAD_PROJECT_NAME);
		}
		else {
			DATA_UPLOAD_URL = BASE_URL.replace(ORIGINAL_PROJECT_NAME, DATA_UPLOAD_PROJECT_NAME);
		}
	}
	
	/**
	 * 	上传单条直播播放数据
	 * @throws XimalayaException 
	 * 
	 * @ liveRecord
	 */
	public UploadResponse uploadSingleLiveRecord(LiveRecord liveRecord) 
			throws XimalayaException {
		DTOValidateUtil.validateLiveRecord(liveRecord);
        HttpParameter[] specificParams = prepareLiveRecord(liveRecord);
        return new UploadResponse(CLIENT.post(String.format("%s/live_single_record", 
        		DATA_UPLOAD_URL), assembleHttpParams(specificParams)));
	}
	
	/**
	 * 	批量上传直播播放数据；（注意：每次上传的批量条数必须小于等于200条！）
	 * 
	 * @param liveRecords
	 * @throws XimalayaException 
	 */
	public UploadResponse uploadBatchLiveRecord(List<LiveRecord> liveRecords)
			throws XimalayaException {
		DTOValidateUtil.validateLiveRecords(liveRecords);
        HttpParameter[] specificParams = prepareLiveRecords(liveRecords);
        return new UploadResponse(CLIENT.post(String.format("%s/live_batch_records",
        		DATA_UPLOAD_URL), assembleHttpParams(specificParams)));
	}
	
	/**
	 * 	上传单条声音播放数据
	 * 
	 * @param trackRecord
	 * @throws XimalayaException 
	 */
	public UploadResponse uploadSingleTrackRecord(TrackRecord trackRecord)
			throws XimalayaException {
		DTOValidateUtil.validateTrackRecord(trackRecord);
        HttpParameter[] specificParams = prepareTrackRecord(trackRecord);
        return new UploadResponse(CLIENT.post(String.format("%s/track_single_record",
        		DATA_UPLOAD_URL), assembleHttpParams(specificParams)));
	}
	
	/**
	 *  批量上传声音播放数据；（注意：每次上传的批量条数必须小于等于200条）
	 * 
	 * @param trackRecords
	 * @throws XimalayaException 
	 */
	public UploadResponse uploadBatchTrackRecord(List<TrackRecord> trackRecords)
			throws XimalayaException {
		DTOValidateUtil.validateTrackRecords(trackRecords);
        HttpParameter[] specificParams = prepareTrackRecords(trackRecords);
        return new UploadResponse(CLIENT.post(String.format("%s/track_batch_records", 
        		DATA_UPLOAD_URL), assembleHttpParams(specificParams)));
	}
	
	private HttpParameter[] prepareLiveRecords(List<LiveRecord> liveRecords) {
		HttpParameter specificParam = new HttpParameter("live_records", JSON.toJSONString(liveRecords));
		return new HttpParameter[] {specificParam};
	}
	
	private HttpParameter[] prepareLiveRecord(LiveRecord liveRecord) {
		List<HttpParameter> specificParamList = new ArrayList<HttpParameter>();
		specificParamList.add(new HttpParameter("radio_id", liveRecord.getRadioId()));
		specificParamList.add(new HttpParameter("duration", liveRecord.getDuration()));
		if(liveRecord.getProgramScheduleId() != null) {
			specificParamList.add(new HttpParameter("program_schedule_id",
					liveRecord.getProgramScheduleId()));
		}
		if(liveRecord.getProgramId() != null) {
			specificParamList.add(new HttpParameter("program_id", liveRecord.getProgramId()));
		}
		if(liveRecord.getStartedAt() != null) {
			specificParamList.add(new HttpParameter("started_at", liveRecord.getStartedAt()));
		}
		specificParamList.add(new HttpParameter("played_secs", liveRecord.getPlayedSecs()));
		return specificParamList.toArray(new HttpParameter[specificParamList.size()]);
	}
	
	private HttpParameter[]  prepareTrackRecords(List<TrackRecord> trackRecords) {
		HttpParameter specificParam = new HttpParameter("track_records",
				JSON.toJSONString(trackRecords));
		return new HttpParameter[] {specificParam};
	}
	
	private HttpParameter[]  prepareTrackRecord(TrackRecord trackRecord) {
		HttpParameter[] specificParams = null;
		if(trackRecord.getStartedAt() == null) {
			specificParams = new HttpParameter[4];
			specificParams[0] = new HttpParameter("track_id", trackRecord.getTrackId());
	        specificParams[1] = new HttpParameter("duration", trackRecord.getDuration());
	        specificParams[2] = new HttpParameter("played_secs", trackRecord.getPlayedSecs());
	        specificParams[3] = new HttpParameter("play_type", trackRecord.getPlayType());
		}
		else {
			specificParams = new HttpParameter[5];
			specificParams[0] = new HttpParameter("track_id", trackRecord.getTrackId());
	        specificParams[1] = new HttpParameter("duration", trackRecord.getDuration());
	        specificParams[2] = new HttpParameter("played_secs", trackRecord.getPlayedSecs());
	        specificParams[3] = new HttpParameter("started_at", trackRecord.getStartedAt());
	        specificParams[4] = new HttpParameter("play_type", trackRecord.getPlayType());
		}
		return specificParams;
	}
	
	public static class UploadResponse extends XimalayaResponse {
		private static final long serialVersionUID = -5641815373670280547L;
		
		private Integer code;		//0-成功，1-失败
		private String message;		//成功或失败消息
		
		public UploadResponse() {
		}
		
		public UploadResponse(JSONObject json) throws XimalayaException {
			super();
			init(json);
		}
		
		public UploadResponse(HttpResponse response) throws XimalayaException {
			super();
			init(response.asJSONObject());
		}
		
		private void init(JSONObject json) throws XimalayaException {
			if(json != null) {
				code = json.getInteger("code");
				message = json.getString("message");
			}
		}

		public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return "UploadResponse {code=" + code + ", message=" + message + "}";
		}
		
	}
}
