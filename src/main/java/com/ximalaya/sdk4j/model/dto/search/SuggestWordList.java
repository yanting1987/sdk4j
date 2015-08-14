package com.ximalaya.sdk4j.model.dto.search;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;

public class SuggestWordList extends XimalayaResponse{
	private static final long serialVersionUID = 2721436489197473333L;
	
	private int albumResultNum;
	private List<AlbumWord> albumResultList;
	
	private int queryResultNum;
	private List<QueryWord> queryResultList;
	
	public SuggestWordList() {
	}
	
	public int getAlbumResultNum() {
		return albumResultNum;
	}
	public void setAlbumResultNum(int albumResultNum) {
		this.albumResultNum = albumResultNum;
	}
	public List<AlbumWord> getAlbumResultList() {
		return albumResultList;
	}
	public void setAlbumResultList(List<AlbumWord> albumResultList) {
		this.albumResultList = albumResultList;
	}
	public int getQueryResultNum() {
		return queryResultNum;
	}
	public void setQueryResultNum(int queryResultNum) {
		this.queryResultNum = queryResultNum;
	}
	public List<QueryWord> getQueryResultList() {
		return queryResultList;
	}
	public void setQueryResultList(List<QueryWord> queryResultList) {
		this.queryResultList = queryResultList;
	}
	
	public SuggestWordList(JSONObject json) throws XimalayaException {
		super();
		init(json);
	}
	
	public SuggestWordList(HttpResponse response) throws XimalayaException {
		init(response.asJSONObject());
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			albumResultNum = json.getIntValue("album_result_num");
			albumResultList = parseAlbumWordList(json.getJSONArray("album_result_list"));
			queryResultNum = json.getIntValue("query_result_num");
			queryResultList = parseQueryWordList(json.getJSONArray("query_result_list"));
		}
	}
	
	private List<AlbumWord> parseAlbumWordList(JSONArray jsonArray) 
			throws XimalayaException {
		List<AlbumWord> albumWords = new ArrayList<AlbumWord>();
		for(int i = 0; i < jsonArray.size(); i++) {
			albumWords.add(jsonArray.getObject(i, AlbumWord.class));
 	 	}
		return albumWords;
	}
	
	private List<QueryWord> parseQueryWordList(JSONArray jsonArray) 
			throws XimalayaException {
		List<QueryWord> queryWords = new ArrayList<QueryWord>();
		for(int i = 0; i < jsonArray.size(); i++) {
			queryWords.add(jsonArray.getObject(i, QueryWord.class));
 	 	}
		return queryWords;
	}
}
