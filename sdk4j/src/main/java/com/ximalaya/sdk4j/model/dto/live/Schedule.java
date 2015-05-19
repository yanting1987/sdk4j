package com.ximalaya.sdk4j.model.dto.live;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;
import com.ximalaya.sdk4j.model.dto.profile.User;

/**
 * 直播节目时间表DTO
 * 
 * @author will
 *
 */
public class Schedule extends XimalayaResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2863359065879699665L;
	
	private Long id;                            // 节目时间表ID
	private String kind;                        // DTO实体类型
	private Long programID;                     // 节目ID
	private String programName;                 // 节目名称
	private String startTime;                   // 开始时间
	private String endTime;                     // 结束时间
	private Integer playType;                   // 播放类型，0-直播，1-重播，2-跨天，3-无流期
	private String listenBackUrl;               // 直播节目回听地址
	private List<Integer> supportBitRates;      // 支持的码率列表，如[24, 64]
	private List<RadioPlayUrl> radioPlayUrls;   // 电台在线播放地址列表
	private List<User> announcers;              // 主播列表 
	
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
	public Long getProgramID() {
		return programID;
	}
	public void setProgramID(Long programID) {
		this.programID = programID;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getPlayType() {
		return playType;
	}
	public void setPlayType(Integer playType) {
		this.playType = playType;
	}
	public String getListenBackUrl() {
		return listenBackUrl;
	}
	public void setListenBackUrl(String listenBackUrl) {
		this.listenBackUrl = listenBackUrl;
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
	public List<User> getAnnouncers() {
		return announcers;
	}
	public void setAnnouncers(List<User> announcers) {
		this.announcers = announcers;
	}
	
	public Schedule(HttpResponse response) throws XimalayaException {
		super(response);
		init(response.asJSONObject());
	}
	
	public Schedule(JSONObject json) throws XimalayaException {
		super();
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				id = json.getLong("id");
				kind = json.getString("kind");
				programID = json.getLong("program_id");
				programName = json.getString("program_name");
				startTime = json.getString("start_time");
				endTime = json.getString("end_time");
				playType = json.getInt("play_type");
				listenBackUrl = json.getString("listen_back_url");
				
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
				
				List<User> announcers = new ArrayList<User> ();
				JSONArray announcersJsonArray = json.getJSONArray("announcers");
				size = announcersJsonArray.length();
				for(int i = 0; i < size; i++) {
					announcers.add(new User(announcersJsonArray.getJSONObject(i)));
				}
				this.announcers = announcers;
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	public static ScheduleList constructScheduleList(HttpResponse response) throws XimalayaException {
		ScheduleList scheduleList = new ScheduleList();
		JSONObject scheduleListJsonObject = response.asJSONObject();
		try {
			scheduleList.setTotalPage(scheduleListJsonObject.getInt("total_page"));
			scheduleList.setTotalCount(scheduleListJsonObject.getInt("total_count"));
			
			List<Schedule> schedules = new ArrayList<Schedule> ();
			JSONArray schedulesJsonArray = scheduleListJsonObject.getJSONArray("schedules");
			int size = schedulesJsonArray.length();
			for(int i = 0; i < size; i++) {
				schedules.add(new Schedule(schedulesJsonArray.getJSONObject(i)));
			}
			scheduleList.setSchedules(schedules);
		} catch(JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return scheduleList;
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
		
		Schedule other = (Schedule) obj;
		if((id == null && other.id != null) 
			|| !id.equals(other.id)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Schedule {id: ");
		strBuilder.append(id);
		strBuilder.append(", kind: \"");
		strBuilder.append(kind);
		strBuilder.append("\", programID: \"");
		strBuilder.append(programID);
		strBuilder.append("\", programName: \"");
		strBuilder.append(programName);
		strBuilder.append("\", startTime: \"");
		strBuilder.append(startTime);
		strBuilder.append("\", endTime: \"");
		strBuilder.append(endTime);
		strBuilder.append("\", playType: ");
		strBuilder.append(playType);
		strBuilder.append(", listenBackUrl: \"");
		strBuilder.append(listenBackUrl);
		strBuilder.append("\", supportBitRates: ");
		strBuilder.append(supportBitRates);
		strBuilder.append(", radioPlayUrls: [");
		if(radioPlayUrls != null && !radioPlayUrls.isEmpty()) {
			for(RadioPlayUrl url: radioPlayUrls) {
				strBuilder.append(url.toString());
				strBuilder.append(", ");
			}
			strBuilder.deleteCharAt(strBuilder.lastIndexOf(","));
		}
		strBuilder.append("], announcers: [");
		if(announcers != null && !announcers.isEmpty()) {
			for(User announcer: announcers) {
				strBuilder.append(announcer.toString());
				strBuilder.append(", ");
			}
		}
		strBuilder.append("]");
		strBuilder.append("}");
		return strBuilder.toString();
	}
}
