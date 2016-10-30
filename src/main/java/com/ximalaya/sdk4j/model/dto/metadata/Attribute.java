package com.ximalaya.sdk4j.model.dto.metadata;

import java.util.List;

import com.ximalaya.sdk4j.model.XimalayaResponse;

/**
 * Metadata元数据的属性Model
 */

public class Attribute extends XimalayaResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1893860886134170634L;
	
	private Long attrKey;                    // 元数据属性名
	private String attrValue;                // 元数据属性值
	private String displayName;              // 元数据属性显示名称
	private List<Metadata> childMetadatas;   // 该元数据属性下的子元数据列表
	
	public Attribute() {
		
	}
	
	public Long getAttrKey() {
		return attrKey;
	}
	public void setAttrKey(Long attrKey) {
		this.attrKey = attrKey;
	}
	public String getAttrValue() {
		return attrValue;
	}
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public List<Metadata> getChildMetadatas() {
		return childMetadatas;
	}
	public void setChildMetadatas(List<Metadata> childMetadatas) {
		this.childMetadatas = childMetadatas;
	}
	
}
