package com.ximalaya.sdk4j.model.dto.search;

import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;


public class AlbumWord extends XimalayaResponse{
	private static final long serialVersionUID = -8121832465530680886L;
	
	private long id;
	private String keyword;
	private String highlightKeyword;
	private String category;
	private String imgPath;
	
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
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
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
			try {
				id = json.getLong("id");
				keyword = json.getString("keyword");
				highlightKeyword = json.getString("highlight_keyword");
				category = json.getString("category");
				imgPath = json.getString("img_path");
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	@Override
	public String toString() {
		return "AlbumWord {id=" + id + ", keyword=" + keyword
				+ ", highlightKeyword=" + highlightKeyword + ", category="
				+ category + ", imgPath=" + imgPath + "}";
	}
}
