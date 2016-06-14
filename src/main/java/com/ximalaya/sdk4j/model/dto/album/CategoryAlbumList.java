package com.ximalaya.sdk4j.model.dto.album;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;


public class CategoryAlbumList extends XimalayaResponse {
	private static final long serialVersionUID = -9041226364045191970L;

	private Long categoryID;
	private String displayCategoryName;
	private String categoryName;
	private List<Album> albums;
	
	public CategoryAlbumList() {
	}
	
	public CategoryAlbumList(JSONObject json) throws XimalayaException {
		super();
		init(json);
	}
	
	public CategoryAlbumList(HttpResponse response) throws XimalayaException {
		init(response.asJSONObject());
	}
	
	public static List<CategoryAlbumList> constructCategoryAlbumList(HttpResponse response) throws XimalayaException {
		List<CategoryAlbumList> categoryAlbumLists = new ArrayList<CategoryAlbumList>();
		if(response != null) {
			JSONArray categoryAlbumListJsonArray = response.asJSONArray();
			for(int i = 0; i < categoryAlbumListJsonArray.size(); i++) {
				categoryAlbumLists.add(new CategoryAlbumList(categoryAlbumListJsonArray.getJSONObject(i)));
			}
		}
		return categoryAlbumLists;
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			categoryID = json.getLong("category_id");
			displayCategoryName = json.getString("display_category_name");
			categoryName = json.getString("category_name");
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

	public String getDisplayCategoryName() {
		return displayCategoryName;
	}

	public void setDisplayCategoryName(String displayCategoryName) {
		this.displayCategoryName = displayCategoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "CategoryAlbumList {categoryID=" + categoryID + ", displayCategoryName=" + displayCategoryName + ", categoryName=" + categoryName
				+ ", albums=" + albums + "}";
	}

}
