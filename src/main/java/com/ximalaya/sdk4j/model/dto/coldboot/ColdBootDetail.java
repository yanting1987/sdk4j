package com.ximalaya.sdk4j.model.dto.coldboot;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ximalaya.sdk4j.model.XimalayaException;

/**
 * 
 * @author william.zhang
 *
 */
public class ColdBootDetail implements Serializable {
	private static final long serialVersionUID = 4120264478983675595L;

	private String kind;
	private String coldBootGenre;
	private String coldBootSubGenre;
	private Integer deviceType;
	private String deviceId;
	private List<String> coldBootTags;

	public ColdBootDetail(JSONObject json) throws XimalayaException {
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			kind = json.getString("kind");
			coldBootGenre = json.getString("coldboot_genre");
			coldBootSubGenre = json.getString("coldboot_sub_genre");
			deviceType = json.getInteger("device_type");
			deviceId = json.getString("device_id");
			coldBootTags = ColdBootTag.constructColdBootTags(
					json.getJSONArray("coldboot_tags"));
		}
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getColdBootGenre() {
		return coldBootGenre;
	}

	public void setColdBootGenre(String coldBootGenre) {
		this.coldBootGenre = coldBootGenre;
	}

	public String getColdBootSubGenre() {
		return coldBootSubGenre;
	}

	public void setColdBootSubGenre(String coldBootSubGenre) {
		this.coldBootSubGenre = coldBootSubGenre;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public List<String> getColdBootTags() {
		return coldBootTags;
	}

	public void setColdBootTags(List<String> coldBootTags) {
		this.coldBootTags = coldBootTags;
	}

	@Override
	public String toString() {
		return "ColdBootDetail {kind=" + kind + ", coldBootGenre=" + coldBootGenre + ", coldBootSubGenre=" + coldBootSubGenre + ", deviceType="
				+ deviceType + ", deviceId=" + deviceId + ", coldBootTags=" + coldBootTags + "}";
	}
	
}
