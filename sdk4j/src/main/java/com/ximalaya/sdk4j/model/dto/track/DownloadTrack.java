package com.ximalaya.sdk4j.model.dto.track;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.DTOKind;
import com.ximalaya.sdk4j.model.dto.IKindAware;

/**
 * 下载声音DTO
 * @author will
 *
 */
public class DownloadTrack implements IKindAware, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3784342948490045616L;
	
	private Long id;             // ID
	private String trackTitle;   // 声音标题
	private String playUrl32;    // 声音32位播放地址
	private String playUrl64;    // 声音64位播放地址
	private String playUrlAac;   // aac格式音频下载地址
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTrackTitle() {
		return trackTitle;
	}
	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}
	public String getPlayUrl32() {
		return playUrl32;
	}
	public void setPlayUrl32(String playUrl32) {
		this.playUrl32 = playUrl32;
	}
	public String getPlayUrl64() {
		return playUrl64;
	}
	public void setPlayUrl64(String playUrl64) {
		this.playUrl64 = playUrl64;
	}
	public String getPlayUrlAac() {
		return playUrlAac;
	}
	public void setPlayUrlAac(String playUrlAac) {
		this.playUrlAac = playUrlAac;
	}
	@Override
	public String getKind() {
		return DTOKind.TRACK_KIND;
	}
	
	public DownloadTrack(JSONObject json) throws XimalayaException {
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				id = json.getLong("id");
				trackTitle = json.getString("track_title");
				playUrl32 = json.getString("play_url_32");
				playUrl64 = json.getString("play_url_64");
				playUrlAac = json.getString("play_url_aac");
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
		
		DownloadTrack other = (DownloadTrack) obj;
		if((id == null && other.id != null) 
			|| !id.equals(other.id)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("DownTrack {id: ");
		strBuilder.append(id);
		strBuilder.append(", trackTitle: \"");
		strBuilder.append(trackTitle);
		strBuilder.append("\", playUrl32: \"");
		strBuilder.append(playUrl32);
		strBuilder.append("\", playUrl64: \"");
		strBuilder.append(playUrl64);
		strBuilder.append("\", playUrlAac: \"");
		strBuilder.append(playUrlAac);
		strBuilder.append("}");
		return strBuilder.toString();
	}

}
