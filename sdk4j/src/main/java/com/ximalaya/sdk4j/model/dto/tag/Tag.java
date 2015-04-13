package com.ximalaya.sdk4j.model.dto.tag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.DTOKind;
import com.ximalaya.sdk4j.model.dto.IKindAware;

/**
 * 标签DTO
 * 
 * @author will
 *
 */
public class Tag implements IKindAware, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3639856295998431047L;
		
	private String tagName;          // 标签名
	private String coverUrlSmall;    // 封面小图
	private String coverUrlMiddle;   // 封面中图
	private String coverUrlLarge;    // 封面大图
	
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getCoverUrlSmall() {
		return coverUrlSmall;
	}
	public void setCoverUrlSmall(String coverUrlSmall) {
		this.coverUrlSmall = coverUrlSmall;
	}
	public String getCoverUrlMiddle() {
		return coverUrlMiddle;
	}
	public void setCoverUrlMiddle(String coverUrlMiddle) {
		this.coverUrlMiddle = coverUrlMiddle;
	}
	public String getCoverUrlLarge() {
		return coverUrlLarge;
	}
	public void setCoverUrlLarge(String coverUrlLarge) {
		this.coverUrlLarge = coverUrlLarge;
	}
	
	@Override
	public String getKind() {
		return DTOKind.TAG_KIND;
	}
	
	public Tag(JSONObject json) throws XimalayaException {
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				tagName = json.getString("tag_name");
				if(json.has("cover_url_small")) {
					coverUrlSmall = json.getString("cover_url_small");
				}
				if(json.has("cover_url_middle")) {
					coverUrlMiddle = json.getString("cover_url_middle");
				}
				if(json.has("cover_url_large")) {
					coverUrlLarge = json.getString("cover_url_large");
				}
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	public static List<Tag> constructTags(HttpResponse response) throws XimalayaException {
		List<Tag> tags = new ArrayList<Tag> ();
		JSONArray tagsJsonArray = response.asJSONArray();
		try {
			int size = tagsJsonArray.length();
			for(int i = 0; i < size; i++) {
				tags.add(new Tag(tagsJsonArray.getJSONObject(i)));
			}
		} catch (JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return tags;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
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
		
		Tag other = (Tag) obj;
		if((tagName == null && other.tagName != null) 
			|| !tagName.equals(other.tagName)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Tag {tagName: \"");
		strBuilder.append(tagName);
		strBuilder.append("\", coverUrlSmall: ");
		strBuilder.append(coverUrlSmall == null ? null : ("\"" + coverUrlSmall + "\""));
		strBuilder.append(", coverUrlMiddle: ");
		strBuilder.append(coverUrlMiddle == null ? null : ("\"" + coverUrlMiddle + "\""));
		strBuilder.append(", coverUrlLarge: ");
		strBuilder.append(coverUrlLarge == null ? null : ("\"" + coverUrlLarge + "\""));
		strBuilder.append("}");
		return strBuilder.toString();
	}
	
}
