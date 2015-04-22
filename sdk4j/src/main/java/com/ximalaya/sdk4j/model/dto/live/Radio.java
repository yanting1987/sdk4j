package com.ximalaya.sdk4j.model.dto.live;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;
import com.ximalaya.sdk4j.model.dto.IKindAware;

/**
 * 直播电台DTO
 * 
 * @author will
 *
 */
public class Radio extends XimalayaResponse implements IKindAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8588679252699226797L;
	
	private Long id;                // 电台ID
	private String radioName;       // 电台名称
	private Long scheduleID;        // 正在直播的节目时间表ID
	private Long  radioPlayCount;   // 电台累计被收听次数
	private String rate24AacUrl;    // 24码率aac格式播放地址
	private String rate24TsUrl;     // 24码率ts格式播放地址
	private String rate64AacUrl;    // 64码率aac格式播放地址
	private String rate64TsUrl;     // 64码率ts格式播放地址
	private String coverUrlSmall;   // 电台封面小图
	private String coverUrlLarge;   // 电台封面大图
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(Long scheduleID) {
		this.scheduleID = scheduleID;
	}
	public Long getRadioPlayCount() {
		return radioPlayCount;
	}
	public void setRadioPlayCount(Long radioPlayCount) {
		this.radioPlayCount = radioPlayCount;
	}
	public String getRate24AacUrl() {
		return rate24AacUrl;
	}
	public void setRate24AacUrl(String rate24AacUrl) {
		this.rate24AacUrl = rate24AacUrl;
	}
	public String getRate24TsUrl() {
		return rate24TsUrl;
	}
	public void setRate24TsUrl(String rate24TsUrl) {
		this.rate24TsUrl = rate24TsUrl;
	}
	public String getRate64AacUrl() {
		return rate64AacUrl;
	}
	public void setRate64AacUrl(String rate64AacUrl) {
		this.rate64AacUrl = rate64AacUrl;
	}
	public String getRate64TsUrl() {
		return rate64TsUrl;
	}
	public void setRate64TsUrl(String rate64TsUrl) {
		this.rate64TsUrl = rate64TsUrl;
	}
	public String getRadioName() {
		return radioName;
	}
	public void setRadioName(String radioName) {
		this.radioName = radioName;
	}
	public String getCoverUrlSmall() {
		return coverUrlSmall;
	}
	public void setCoverUrlSmall(String coverUrlSmall) {
		this.coverUrlSmall = coverUrlSmall;
	}
	public String getCoverUrlLarge() {
		return coverUrlLarge;
	}
	public void setCoverUrlLarge(String coverUrlLarge) {
		this.coverUrlLarge = coverUrlLarge;
	}

	@Override
	public String getKind() {
		return "radio";
	}
	
	public Radio(HttpResponse response) throws XimalayaException {
		super(response);
		init(response.asJSONObject());
	}
	
	public Radio(JSONObject json) throws XimalayaException {
		super();
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				id = json.getLong("id");
				radioName = json.getString("radio_name");
				scheduleID = json.getLong("schedule_id");
				radioPlayCount = json.getLong("radio_play_count");
				rate24AacUrl = json.getString("rate24_aac_url");
				rate24TsUrl = json.getString("rate24_ts_url");
				rate64AacUrl = json.getString("rate64_aac_url");
				rate64TsUrl = json.getString("rate64_ts_url");
				coverUrlSmall = json.getString("cover_url_small");
				coverUrlLarge = json.getString("cover_url_large");
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	public static RadioList constructRadioList(HttpResponse response) throws XimalayaException {
		RadioList radioList = new RadioList();
		JSONObject radioListJsonObject = response.asJSONObject();
		try {
			radioList.setTotalPage(radioListJsonObject.getInt("total_page"));
			radioList.setTotalCount(radioListJsonObject.getInt("total_count"));
			
			List<Radio> radios = new ArrayList<Radio> ();
			JSONArray radiosJsonArray = radioListJsonObject.getJSONArray("radios");
			int size = radiosJsonArray.length();
			for(int i = 0; i < size; i++) {
				radios.add(new Radio(radiosJsonArray.getJSONObject(i)));
			}
			radioList.setRadios(radios);
		} catch(JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return radioList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		Radio other = (Radio) obj;
		if((id == null && other.id != null) 
			|| !id.equals(other.id)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Radio {id: ");
		strBuilder.append(id);
		strBuilder.append(", radioName: \"");
		strBuilder.append(radioName);
		strBuilder.append("\", scheduleID: ");
		strBuilder.append(scheduleID);
		strBuilder.append(", radioPlayCount: ");
		strBuilder.append(radioPlayCount);
		strBuilder.append(", rate24AacUrl: \"");
		strBuilder.append(rate24AacUrl);
		strBuilder.append("\", rate24TsUrl: \"");
		strBuilder.append(rate24TsUrl);
		strBuilder.append("\", rate64AacUrl: \"");
		strBuilder.append(rate64AacUrl);
		strBuilder.append("\", rate64TsUrl: \"");
		strBuilder.append(rate64TsUrl);
		strBuilder.append("\", coverUrlSmall: \"");
		strBuilder.append(coverUrlSmall);
		strBuilder.append("\", coverUrlLarge: \"");
		strBuilder.append(coverUrlLarge);
		strBuilder.append("\"}");
		return strBuilder.toString();
	}

}
