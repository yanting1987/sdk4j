package com.ximalaya.sdk4j.model.dto.profile;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;

/**
 * 
 * @author william.zhang
 *
 */
public class Announcer extends User {
	private static final long serialVersionUID = 7534355346514586516L;
	
	private Long vcategoryID;   			// 主播所属分类ID
	private String vdesc;   				// 主播简介
	private String vsignature;   			// 主播签名
	private String announcerPosition;   	// 主播定位
	private Integer followerCount;   		// 主播粉丝数
	private Integer followingCount;  	  	// 主播关注数
	private Integer releasedAlbumCount;   	// 主播发布的专辑数
	private Integer releasedTrackCount;   	// 主播发布的声音数

	public Announcer() {
	}
	
	public Long getVcategoryID() {
		return vcategoryID;
	}
	public void setVcategoryID(Long vcategoryID) {
		this.vcategoryID = vcategoryID;
	}
	public String getVdesc() {
		return vdesc;
	}
	public void setVdesc(String vdesc) {
		this.vdesc = vdesc;
	}
	public String getVsignature() {
		return vsignature;
	}
	public void setVsignature(String vsignature) {
		this.vsignature = vsignature;
	}
	public String getAnnouncerPosition() {
		return announcerPosition;
	}
	public void setAnnouncerPosition(String announcerPosition) {
		this.announcerPosition = announcerPosition;
	}
	public Integer getFollowerCount() {
		return followerCount;
	}
	public void setFollowerCount(Integer followerCount) {
		this.followerCount = followerCount;
	}
	public Integer getFollowingCount() {
		return followingCount;
	}
	public void setFollowingCount(Integer followingCount) {
		this.followingCount = followingCount;
	}
	public Integer getReleasedAlbumCount() {
		return releasedAlbumCount;
	}
	public void setReleasedAlbumCount(Integer releasedAlbumCount) {
		this.releasedAlbumCount = releasedAlbumCount;
	}
	public Integer getReleasedTrackCount() {
		return releasedTrackCount;
	}
	public void setReleasedTrackCount(Integer releasedTrackCount) {
		this.releasedTrackCount = releasedTrackCount;
	}

	public Announcer(HttpResponse response) throws XimalayaException {
		super(response);
		init(response.asJSONObject());
	}
	
	public Announcer(JSONObject json) throws XimalayaException {
		super(json);
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			vcategoryID = json.getLong("vcategory_id");
			vdesc = json.getString("vdesc");
			vsignature = json.getString("vsignature");
			announcerPosition = json.getString("announcer_position");
			followerCount = json.getInteger("follower_count");
			followingCount = json.getInteger("following_count");
			releasedAlbumCount = json.getInteger("released_album_count");
			releasedTrackCount = json.getInteger("released_track_count");
		}
	}

	public static AnnouncerList constructAnnouncerList(HttpResponse response) throws XimalayaException {
		AnnouncerList announcerList = new AnnouncerList();
		JSONObject announcerJsonObject = response.asJSONObject();
 		try {
 			announcerList.setTotalPage(announcerJsonObject.getIntValue("total_page"));
 	 		announcerList.setTotalCount(announcerJsonObject.getIntValue("total_count"));
 	 		announcerList.setCurrentPage(announcerJsonObject.getIntValue("current_page"));
 	 		announcerList.setVcategoryID(announcerJsonObject.getLong("vcategory_id"));

 	 		List<Announcer> announcers = new ArrayList<Announcer> ();
 	 		JSONArray announcerJsonArray = announcerJsonObject.getJSONArray("announcers");
 	 		if(announcerJsonArray != null) {
 	 			for(int i = 0; i < announcerJsonArray.size(); i++) {
 	 	 			announcers.add(new Announcer(announcerJsonArray.getJSONObject(i)));
 	 	 		}
 	 		}
 	 		announcerList.setAnnouncers(announcers);		
 	 	} catch(JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return announcerList;
	}
	
}
