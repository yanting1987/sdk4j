package com.ximalaya.sdk4j.model.dto.album;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;

import java.util.ArrayList;
import java.util.List;


public class LikeAlbum extends Album {
	private static final long serialVersionUID = 1L;
	
	private String recommendSrc;     // 用于统计，推荐来源
    private String recommendTrace;   // 推荐跟踪
    private long basedRelativeAlbumId;  //相关专辑的id
    
	public LikeAlbum() {
	}
    
    public String getRecommendSrc() {
        return recommendSrc;
    }

    public void setRecommendSrc(String recommendSrc) {
        this.recommendSrc = recommendSrc;
    }

    public String getRecommendTrace() {
        return recommendTrace;
    }

    public void setRecommendTrace(String recommendTrace) {
        this.recommendTrace = recommendTrace;
    }

    public long getBasedRelativeAlbumId() {
        return basedRelativeAlbumId;
    }

    public void setBasedRelativeAlbumId(long basedRelativeAlbumId) {
        this.basedRelativeAlbumId = basedRelativeAlbumId;
    }

    public LikeAlbum(JSONObject json) throws XimalayaException {
    	super(json);
        init(json);
    }

    private void init(JSONObject json) throws XimalayaException {
        if (json != null) {
            recommendSrc = json.getString("recommend_src");
            recommendTrace = json.getString("recommend_trace");
            basedRelativeAlbumId=json.getLong("based_relative_album_id");
        }
    }

    public static List<LikeAlbum> constructPerferedAlbums(HttpResponse response) throws XimalayaException {
        List<LikeAlbum> reletiveAlbums=new ArrayList<LikeAlbum>();
         JSONArray albumsJsonArray=  response.asJSONArray();
        for (int i = 0; i < albumsJsonArray.size(); i++) {
            reletiveAlbums.add(new LikeAlbum(albumsJsonArray.getJSONObject(i)));
        }
        return reletiveAlbums;
    }
}
