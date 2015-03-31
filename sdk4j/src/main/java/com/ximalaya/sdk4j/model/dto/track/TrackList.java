package com.ximalaya.sdk4j.model.dto.track;

import java.util.List;

import com.ximalaya.sdk4j.model.dto.AbstractPageResult;

/**
 * 声音列表DTO
 * @author will
 *
 */
public class TrackList extends AbstractPageResult {
	
	private Long categoryID;       // 声音所属分类ID
	private String categoryName;   // 声音所属分类名
	private String tagName;        // 选填的声音所属标签名，无则返回空
	private List<Track> tracks;    // 声音列表
	
	public Long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public List<Track> getTracks() {
		return tracks;
	}
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
}
