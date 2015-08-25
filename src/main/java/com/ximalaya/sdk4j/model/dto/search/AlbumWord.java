package com.ximalaya.sdk4j.model.dto.search;

import com.alibaba.fastjson.JSONObject;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;


public class AlbumWord extends XimalayaResponse{
	private static final long serialVersionUID = -8121832465530680886L;
	
	private long id;
	private String keyword;
	private String highlightKeyword;
	private String categoryName;
	private String coverUrlSmall;
	
	public AlbumWord() {
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getHighlightKeyword() {
		return highlightKeyword;
	}
	public void setHighlightKeyword(String highlightKeyword) {
		this.highlightKeyword = highlightKeyword;
	}
	public String getCategory() {
		return categoryName;
	}
	public void setCategory(String category) {
		this.categoryName = category;
	}
	public String getImgPath() {
		return coverUrlSmall;
	}
	public void setImgPath(String imgPath) {
		this.coverUrlSmall = imgPath;
	}
	
	public AlbumWord(JSONObject json) throws XimalayaException {
		super();
		init(json);
	}
	
	public AlbumWord(HttpResponse response) throws XimalayaException {
		super(response);
		init(response.asJSONObject());
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			id = json.getLong("id");
			keyword = json.getString("keyword");
			highlightKeyword = json.getString("highlight_keyword");
			categoryName = json.getString("category_name");
			coverUrlSmall = json.getString("cover_url_small");
		}
	}
	
	@Override
	public String toString() {
		return "AlbumWord {id=" + id + ", keyword=" + keyword
				+ ", highlightKeyword=" + highlightKeyword + ", categoryName="
				+ categoryName + ", coverUrlSmall=" + coverUrlSmall + "}";
	}
}
