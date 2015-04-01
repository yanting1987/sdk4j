package com.ximalaya.sdk4j.model.dto.album;

import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.DTOKind;
import com.ximalaya.sdk4j.model.dto.IKindAware;

public class AlbumTrackCount implements IKindAware {
	private Long id;           // ID
	private Long trackCount;   // 该专辑包含声音数
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTrackCount() {
		return trackCount;
	}
	public void setTrackCount(Long trackCount) {
		this.trackCount = trackCount;
	}
	
	@Override
	public String getKind() {
		return DTOKind.ALBUM_KIND;
	}
	
	public AlbumTrackCount(JSONObject json) throws XimalayaException {
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				id = json.getLong("id");
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
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("AlbumTrackCount {id: ");
		strBuilder.append(id);
		strBuilder.append(", trackCount: ");
		strBuilder.append(trackCount);
		strBuilder.append("}");
		return strBuilder.toString();
	}
}
