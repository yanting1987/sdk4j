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
	
	private Long id;                  // 节目时间表ID
	private String kind;              // DTO实体类型
	private String startTime;         // 开始时间
	private String endTime;           // 结束时间
	private Integer updatedAt;		  // 创建时间，Unix毫秒数时间戳
	private Program relatedProgram;   // 关联的直播节目
	
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
	public Integer getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Integer updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Program getRelatedProgram() {
		return relatedProgram;
	}
	public void setRelatedProgram(Program relatedProgram) {
		this.relatedProgram = relatedProgram;
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
				startTime = json.getString("start_time");
				endTime = json.getString("end_time");
				updatedAt = json.getInt("updated_at");
				relatedProgram = new Program(json.getJSONObject("related_program"));
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	public static List<Schedule> constructSchedules(HttpResponse response) throws XimalayaException {
		JSONArray schedulesJsonArray = response.asJSONArray();
		List<Schedule> schedules = new ArrayList<Schedule> ();
		try {
			int size = schedulesJsonArray.length();
			for(int i = 0; i < size; i++) {
				schedules.add(new Schedule(schedulesJsonArray.getJSONObject(i)));
			}
		} catch(JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return schedules;
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
			|| !id.equals(other.id) || !relatedProgram.equals(other.getRelatedProgram())) {
			return false;
		}
		
		return true;
	}
}
