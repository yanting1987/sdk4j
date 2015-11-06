package com.ximalaya.sdk4j.model.dto.album;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PerferedAlbum implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String kind;
	private String recommendSrc;     // 用于统计，推荐来源
    private String recommendTrace;   // 推荐跟踪
    private long basedRelativeAlbumId;  //相关专辑的id
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public PerferedAlbum() {
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

    public PerferedAlbum(JSONObject json) throws XimalayaException {
        init(json);
    }

    private void init(JSONObject json) throws XimalayaException {
        if (json != null) {
        	id = json.getLong("id");
        	kind = json.getString("kind");
            recommendSrc = json.getString("recommend_src");
            recommendTrace = json.getString("recommend_trace");
            basedRelativeAlbumId=json.getLong("based_relative_album_id");
        }
    }

    public static List<PerferedAlbum> constructPerferedAlbums(HttpResponse response) throws XimalayaException {
        List<PerferedAlbum> reletiveAlbums=new ArrayList<PerferedAlbum>();
         JSONArray albumsJsonArray=  response.asJSONArray();
        for (int i = 0; i < albumsJsonArray.size(); i++) {
            reletiveAlbums.add(new PerferedAlbum(albumsJsonArray.getJSONObject(i)));
        }
        return reletiveAlbums;
    }
}
