package com.ximalaya.sdk4j.model.dto.tag;

import java.util.List;

/**
 * 标签列表DTO
 * @author will
 *
 */
public class TagList {
	
	private long categoryID;      // 标签所属分类ID
	private String categoryName;   // 标签所属分类名称
	private List<Tag> tags;        // 标签列表
	
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
}
