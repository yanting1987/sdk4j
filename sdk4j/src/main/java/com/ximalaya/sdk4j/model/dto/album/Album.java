package com.ximalaya.sdk4j.model.dto.album;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;
import com.ximalaya.sdk4j.model.dto.DTOKind;
import com.ximalaya.sdk4j.model.dto.IKindAware;

/**
 * 专辑DTO
 * @author will
 *
 */
public class Album extends XimalayaResponse implements IKindAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 989057998224528965L;
	
	private Long id;                  // ID
	private String albumTitle;        // 专辑标题
	private String albumTags;         // 专辑标签字符串，以英文逗号分隔
	private String albumIntro;        // 专辑简介
	private String coverUrlSmall;     // 专辑封面小图
	private String coverUrlMiddle;    // 专辑封面中图
	private String coverUrlLarge;     // 专辑封面大图
	private String nickname;          // 专辑所属主播名
	private String avatarUrl;         // 专辑所属主播头像
	private Long playCount;           // 专辑播放次数
	private Long includeTrackCount;   // 专辑包含声音数
	private Long lastUptrackAt;       // 专辑中最新一条声音上传时间
	private Long updatedAt;           // 更新时间
	private Long createdAt;           // 更新时间
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAlbumTitle() {
		return albumTitle;
	}
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	public String getAlbumTags() {
		return albumTags;
	}
	public void setAlbumTags(String albumTags) {
		this.albumTags = albumTags;
	}
	public String getAlbumIntro() {
		return albumIntro;
	}
	public void setAlbumIntro(String albumIntro) {
		this.albumIntro = albumIntro;
	}
	public String getCoverUrlSmall() {
		return coverUrlSmall;
	}
	public void setCoverUrlSmall(String coverUrlSmall) {
		this.coverUrlSmall = coverUrlSmall;
	}
	public String getCoverUrlMiddle() {
		return coverUrlMiddle;
	}
	public void setCoverUrlMiddle(String coverUrlMiddle) {
		this.coverUrlMiddle = coverUrlMiddle;
	}
	public String getCoverUrlLarge() {
		return coverUrlLarge;
	}
	public void setCoverUrlLarge(String coverUrlLarge) {
		this.coverUrlLarge = coverUrlLarge;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public Long getPlayCount() {
		return playCount;
	}
	public void setPlayCount(Long playCount) {
		this.playCount = playCount;
	}
	public Long getIncludeTrackCount() {
		return includeTrackCount;
	}
	public void setIncludeTrackCount(Long includeTrackCount) {
		this.includeTrackCount = includeTrackCount;
	}
	public Long getLastUptrackAt() {
		return lastUptrackAt;
	}
	public void setLastUptrackAt(Long lastUptrackAt) {
		this.lastUptrackAt = lastUptrackAt;
	}
	public Long getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String getKind() {
		return DTOKind.ALBUM_KIND;
	}
	
	public Album(JSONObject json) throws XimalayaException {
		super();
		init(json);
	}
	
	public Album(HttpResponse response) throws XimalayaException {
		super(response);
		init(response.asJSONObject());
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				id = json.getLong("id");
				albumTitle = json.getString("album_title");
				albumTags = json.getString("album_tags");
				albumIntro = json.getString("album_intro");
				coverUrlSmall = json.getString("cover_url_small");
				coverUrlMiddle = json.getString("cover_url_middle");
				coverUrlLarge = json.getString("cover_url_large");
				nickname = json.getString("nickname");
				avatarUrl = json.getString("avatar_url");
				playCount = json.getLong("play_count");
				includeTrackCount = json.getLong("include_track_count");
				lastUptrackAt = json.getLong("last_uptrack_at");
				updatedAt = json.getLong("updated_at");
				createdAt = json.getLong("created_at");
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	public static List<Album> constructAlbums(HttpResponse response) throws XimalayaException {
		List<Album> albums = new ArrayList<Album> ();
		try {
			JSONArray list = response.asJSONArray();
			int size = list.length();
			for(int i = 0; i < size; i++) {
				albums.add(new Album(list.getJSONObject(i)));
			}
		} catch (JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return albums;
	}
	
	public static AlbumList constructAlbumList(HttpResponse response) throws XimalayaException {
		AlbumList albumList = new AlbumList();
		JSONObject albumListJsonObject = response.asJSONObject();
 		try {
 			if(albumListJsonObject.has("category_id")) {
 				albumList.setCategoryID(albumListJsonObject.getLong("category_id"));
 			}
 			if(albumListJsonObject.has("category_name")) {
 				albumList.setCategoryName(albumListJsonObject.getString("category_name"));
 			}
 			if(albumListJsonObject.has("tag_name")) {
 				albumList.setTagName(albumListJsonObject.getString("tag_name"));
 			}
 			albumList.setTotalPage(albumListJsonObject.getInt("total_page"));
 			albumList.setTotalCount(albumListJsonObject.getInt("total_count"));
 			
 			List<Album> albums = new ArrayList<Album> ();
 			JSONArray list = albumListJsonObject.getJSONArray("albums");
 			int size = list.length();
 			for(int i = 0; i < size; i++) {
 				albums.add(new Album(list.getJSONObject(i)));
 			}
 			albumList.setAlbums(albums);
		} catch(JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return albumList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		Album other = (Album) obj;
		if((id == null && other.id != null) 
			|| !id.equals(other.id)) {
			return false;
		}
		
		return true;
	}
	
}
