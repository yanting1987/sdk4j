package com.ximalaya.sdk4j.model.dto.live;

import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.model.XimalayaException;


/**
 * 电台在线播放地址
 * @author will
 *
 */
public class RadioPlayUrl {
	private int bitrate;      // 码率
	private String format;    // 声音格式，aac或ts
	private String playUrl;   // 在线播放地址
	
	public int getBitrate() {
		return bitrate;
	}
	public void setBitrate(int bitrate) {
		this.bitrate = bitrate;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getPlayUrl() {
		return playUrl;
	}
	public void setPlayUrl(String playUrl) {
		this.playUrl = playUrl;
	}
	
	public RadioPlayUrl(JSONObject json) throws XimalayaException {
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				bitrate = json.getInt("bitrate");
				format = json.getString("format");
				playUrl = json.getString("play_url");
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("RadioPlayUrl {bitrate: ");
		strBuilder.append(bitrate);
		strBuilder.append(", format: \"");
		strBuilder.append(format);
		strBuilder.append("\", playUrl: \"");
		strBuilder.append(playUrl);
		strBuilder.append("\"}");
		return strBuilder.toString();
	}
}
