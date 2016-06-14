package com.ximalaya.sdk4j.model.dto.album;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;

public class TagAlbumList extends XimalayaResponse {
	private static final long serialVersionUID = -9041226364045191970L;

	private Long categoryID;
	private Integer displayCount;
	private String displayTagName;
	private String tagName;
	private Boolean hasMore;
	private List<Album> albums;
	
	public TagAlbumList() {
	}
	
	public TagAlbumList(JSONObject json) throws XimalayaException {
		super();
		init(json);
	}
	
	public TagAlbumList(HttpResponse response) throws XimalayaException {
		init(response.asJSONObject());
	}
	
	public static List<TagAlbumList> constructTagAlbumList(HttpResponse response) throws XimalayaException {
		List<TagAlbumList> tagAlbumLists = new ArrayList<TagAlbumList>();
		if(response != null) {
			JSONArray tagAlbumListJsonArray = response.asJSONArray();
			for(int i = 0; i < tagAlbumListJsonArray.size(); i++) {
				tagAlbumLists.add(new TagAlbumList(tagAlbumListJsonArray.getJSONObject(i)));
			}
		}
		return tagAlbumLists;
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			categoryID = json.getLong("category_id");
			displayCount = json.getInteger("display_count");
			displayTagName = json.getString("display_tag_name");
			tagName = json.getString("tag_name");
			hasMore = json.getBoolean("has_more");
			albums = parseAlbumList(json.getJSONArray("albums"));
		}
	}
	
	private List<Album> parseAlbumList(JSONArray albumJSONArray) throws XimalayaException {
		List<Album> albums = new ArrayList<Album>();
		if(albumJSONArray != null) {
			for(int i = 0; i < albumJSONArray.size(); i++) {
				albums.add(new Album(albumJSONArray.getJSONObject(i)));
			}
		}
		return albums;
	}
	
	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public Integer getDisplayCount() {
		return displayCount;
	}
	public void setDisplayCount(Integer displayCount) {
		this.displayCount = displayCount;
	}
	public String getDisplayTagName() {
		return displayTagName;
	}
	public void setDisplayTagName(String displayTagName) {
		this.displayTagName = displayTagName;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public Boolean getHasMore() {
		return hasMore;
	}
	public void setHasMore(Boolean hasMore) {
		this.hasMore = hasMore;
	}
	public List<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	
	@Override
	public String toString() {
		return "CategoryAlbum {categoryID=" + categoryID + ", displayCount=" + displayCount + ", displayTagName=" + displayTagName + ", tagName="
				+ tagName + ", hasMore=" + hasMore + ", albums=" + albums + "}";
	}

}
