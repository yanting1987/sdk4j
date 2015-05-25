package com.ximalaya.sdk4j.model.dto.album;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.model.XimalayaException;

public class AlbumTrackCount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4350343495118789469L;
	
	private Long id;           // ID
	private String kind;       // DTO实体类型
	private Long trackCount;   // 该专辑包含声音数
	
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
	public Long getTrackCount() {
		return trackCount;
	}
	public void setTrackCount(Long trackCount) {
		this.trackCount = trackCount;
	}
	
	public AlbumTrackCount(JSONObject json) throws XimalayaException {
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				id = json.getLong("id");
				kind = json.getString("kind");
				trackCount = json.getLong("track_count");
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
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
		
		AlbumTrackCount other = (AlbumTrackCount) obj;
		if((id == null && other.id != null) 
			|| !id.equals(other.id)) {
			return false;
		}
		
		return true;
	}
}
