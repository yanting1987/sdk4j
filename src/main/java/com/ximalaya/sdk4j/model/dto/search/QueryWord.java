package com.ximalaya.sdk4j.model.dto.search;

import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;

public class QueryWord extends XimalayaResponse {
	private static final long serialVersionUID = 9220526859859093511L;

	private long id;
	private String keyword;
	private String highlightKeyword;
	
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
	
	public QueryWord(JSONObject json) throws XimalayaException {
		super();
		init(json);
	}
	
	public QueryWord(HttpResponse response) throws XimalayaException {
		super(response);
		init(response.asJSONObject());
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				id = json.getLong("id");
				keyword = json.getString("key_word");
				highlightKeyword = json.getString("highlight_keyword");
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	@Override
	public String toString() {
		return "QueryWord {id=" + id + ", keyword=" + keyword
				+ ", highlightKeyword=" + highlightKeyword + "}";
	}
}
