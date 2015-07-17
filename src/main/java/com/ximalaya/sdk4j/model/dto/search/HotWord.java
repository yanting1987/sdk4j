package com.ximalaya.sdk4j.model.dto.search;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;

public class HotWord extends XimalayaResponse {
	private static final long serialVersionUID = 4791604041419033940L;
	
	private String searchword;
	private int degree;
	private int count;
	
	public String getSearchword() {
		return searchword;
	}
	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public HotWord(JSONObject json) throws XimalayaException {
		super();
		init(json);
	}
	
	public HotWord(HttpResponse response) throws XimalayaException {
		super(response);
		init(response.asJSONObject());
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				searchword = json.getString("search_word");
				degree = json.getInt("degree");
				count = json.getInt("count");
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	public static HotWordList constructHotWords(HttpResponse response) throws XimalayaException {
		HotWordList hotWordList = new HotWordList();
		JSONObject albumListJsonObject = response.asJSONObject();
	 	try {
	 	 	List<HotWord> hotWords = new ArrayList<HotWord> ();
	 	 	JSONArray albumsJsonArray = albumListJsonObject.getJSONArray("hot_words");
	 	 	for(int i = 0; i < albumsJsonArray.length(); i++) {
	 	 		hotWords.add(new HotWord(albumsJsonArray.getJSONObject(i)));
	 	 	}
	 	 	hotWordList.setHotWords(hotWords);
		} catch(JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return hotWordList;
	}
	
	@Override
	public String toString() {
		return "HotWord {searchword=" + searchword + ", degree=" + degree
				+ ", count=" + count + "}";
	}
}