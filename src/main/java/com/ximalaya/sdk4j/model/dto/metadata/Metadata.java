package com.ximalaya.sdk4j.model.dto.metadata;

import java.util.List;

import com.ximalaya.sdk4j.model.XimalayaResponse;

/**
 * 元数据Model
 */
public class Metadata extends XimalayaResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4427271126129296571L;
	private String displayName;           // 元数据显示名称
	private List<Attribute> attributes;   // 元数据下的属性列表
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public List<Attribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
}
