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
	
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
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
		strBuilder.append("\"}");
		return strBuilder.toString();
	}
	
}
