package com.ximalaya.sdk4j.model.dto.coldboot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;

/**
 * 
 * @author william.zhang
 *
 */
public class ColdBootTag implements Serializable {
	private static final long serialVersionUID = 2377615616899290373L;

	private String kind;
	private String coldBootGenre;
	private String coldBootSubGenre;
	private List<String> coldBootTags;
	
	public static List<String> constructColdBootTags(
			HttpResponse httpResponse) throws XimalayaException {
		JSONArray jsonArray = httpResponse.asJSONArray();
		return parseTags(jsonArray);
	}
	
	public static List<String> constructColdBootTags(JSONArray jsonArray) 
			throws XimalayaException {
		return parseTags(jsonArray);
	}
	
	public ColdBootTag(JSONObject json) throws XimalayaException {
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			kind = json.getString("kind");
			coldBootGenre = json.getString("coldboot_genre");
			coldBootSubGenre = json.getString("coldboot_sub_genre");
			coldBootTags = parseTags(json.getJSONArray("coldboot_tags"));
		}
	}
	
	private static List<String> parseTags(JSONArray jsonArray) {
		List<String> tags = new ArrayList<String>();
		if(jsonArray != null) {
			for(int i = 0; i < jsonArray.size(); i++) {
				tags.add(jsonArray.getString(i));
			}
		}
		return tags;
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

	public List<String> getColdBootTags() {
		return coldBootTags;
	}

	public void setColdBootTags(List<String> coldBootTags) {
		this.coldBootTags = coldBootTags;
	}

	@Override
	public String toString() {
		return "ColdBootTag {kind=" + kind + ", coldBootGenre=" + coldBootGenre + ", coldBootSubGenre=" + coldBootSubGenre + ", coldBootTags="
				+ coldBootTags + "}";
	}
	
}
