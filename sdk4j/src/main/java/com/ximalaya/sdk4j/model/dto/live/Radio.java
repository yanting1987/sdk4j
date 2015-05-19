package com.ximalaya.sdk4j.model.dto.live;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;

/**
 * 直播电台DTO
 * 
 * @author will
 *
 */
public class Radio extends XimalayaResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8588679252699226797L;
	
	private Long id;                            // 电台ID
	private String kind;                        // DTO实体类型
	private String radioName;                   // 电台名称
	private String radioDesc;                   // 电台简介
	private String programName;                 // 正在直播的节目名称
	private Long scheduleID;                    // 正在直播的节目时间表ID
	private List<Integer> supportBitRates;      // 支持的码率列表，如[24, 64]
	private List<RadioPlayUrl> radioPlayUrls;   // 电台在线播放地址列表
	private Long  radioPlayCount;               // 电台累计被收听次数
	private String coverUrlSmall;               // 电台封面小图
	private String coverUrlLarge;               // 电台封面大图
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getRadioName() {
		return radioName;
	}
	public void setRadioName(String radioName) {
		this.radioName = radioName;
	}
	public String getRadioDesc() {
		return radioDesc;
	}
	public void setRadioDesc(String radioDesc) {
		this.radioDesc = radioDesc;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public Long getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(Long scheduleID) {
		this.scheduleID = scheduleID;
	}
	public List<Integer> getSupportBitRates() {
		return supportBitRates;
	}
	public void setSupportBitRates(List<Integer> supportBitRates) {
		this.supportBitRates = supportBitRates;
	}
	public List<RadioPlayUrl> getRadioPlayUrls() {
		return radioPlayUrls;
	}
	public void setRadioPlayUrls(List<RadioPlayUrl> radioPlayUrls) {
		this.radioPlayUrls = radioPlayUrls;
	}
	public Long getRadioPlayCount() {
		return radioPlayCount;
	}
	public void setRadioPlayCount(Long radioPlayCount) {
		this.radioPlayCount = radioPlayCount;
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
				kind = json.getString("kind");
				radioName = json.getString("radio_name");
				radioDesc = json.getString("radioDesc");
				programName = json.getString("program_name");
				scheduleID = json.getLong("schedule_id");
				
				supportBitRates = new ArrayList<Integer> ();
				JSONArray supportBitRatesJsonArray = json.getJSONArray("support_bitrates");
				int size = supportBitRatesJsonArray.length();
				for(int i = 0; i < size; i++) {
					supportBitRates.add(supportBitRatesJsonArray.getInt(i));
				}
				
				radioPlayUrls = new ArrayList<RadioPlayUrl> ();
				JSONArray radioPlayUrlsJsonArray = json.getJSONArray("radio_play_urls");
				size = radioPlayUrlsJsonArray.length();
				for(int i = 0; i < size; i++) {
					radioPlayUrls.add(new RadioPlayUrl(radioPlayUrlsJsonArray.getJSONObject(i)));
				}
				
				radioPlayCount = json.getLong("radio_play_count");
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
		strBuilder.append(", kind: \"");
		strBuilder.append(kind);
		strBuilder.append("\", radioName: \"");
		strBuilder.append(radioName);
		strBuilder.append("\", radioDesc: ");
		strBuilder.append(radioDesc);
		strBuilder.append("\", programName: \"");
		strBuilder.append(programName);
		strBuilder.append("\", scheduleID: ");
		strBuilder.append(scheduleID);
		strBuilder.append(", supportBitRates: ");
		strBuilder.append(supportBitRates);
		strBuilder.append(", radioPlayUrls: [");
		if(radioPlayUrls != null && !radioPlayUrls.isEmpty()) {
			for(RadioPlayUrl url: radioPlayUrls) {
				strBuilder.append(url.toString());
				strBuilder.append(", ");
			}
			strBuilder.deleteCharAt(strBuilder.lastIndexOf(","));
		}
		strBuilder.append("], radioPlayCount: ");
		strBuilder.append(radioPlayCount);
		strBuilder.append(", coverUrlSmall: \"");
		strBuilder.append(coverUrlSmall);
		strBuilder.append("\", coverUrlLarge: \"");
		strBuilder.append(coverUrlLarge);
		strBuilder.append("\"}");
		return strBuilder.toString();
	}

}
