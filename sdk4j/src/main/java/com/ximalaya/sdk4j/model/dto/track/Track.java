package com.ximalaya.sdk4j.model.dto.track;

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
 * 声音DTO
 * @author will
 *
 */
public class Track extends XimalayaResponse implements IKindAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4324052388239950724L;
	
	private Long id;                    // ID
	private String trackTitle;          // 声音标题
	private String trackTags;           // 声音标签列表字符串，以英文逗号分隔
	private String trackIntro;          // 声音简介
	private String coverUrlSmall;       // 声音封面小图
	private String coverUrlMiddle;      // 声音封面中图
	private String coverUrlLarge;       // 声音封面大图
	private Long uid;                   // 声音所属主播用户ID
	private String nickname;            // 声音所属主播用户名
	private String avatarUrl;           // 声音所属主播头像
	private Double duration;            // 声音时长
	private Long playCount;             // 声音播放次数
	private Long favoriteCount;         // 声音喜欢数
	private Long commentCount;          // 声音评论数
	private String playUrl32;           // 声音32位播放地址
	private String playUrl64;           // 声音64位播放地址
	private Long subordinatedAlbumID;   // 声音所属专辑ID
	private Long updatedAt;             // 更新时间
	private Long createdAt;             // 更新时间
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTrackTitle() {
		return trackTitle;
	}
	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}
	public String getTrackTags() {
		return trackTags;
	}
	public void setTrackTags(String trackTags) {
		this.trackTags = trackTags;
	}
	public String getTrackIntro() {
		return trackIntro;
	}
	public void setTrackIntro(String trackIntro) {
		this.trackIntro = trackIntro;
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
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
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
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public Long getPlayCount() {
		return playCount;
	}
	public void setPlayCount(Long playCount) {
		this.playCount = playCount;
	}
	public Long getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(Long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	public Long getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}
	public String getPlayUrl32() {
		return playUrl32;
	}
	public void setPlayUrl32(String playUrl32) {
		this.playUrl32 = playUrl32;
	}
	public String getPlayUrl64() {
		return playUrl64;
	}
	public void setPlayUrl64(String playUrl64) {
		this.playUrl64 = playUrl64;
	}
	public Long getSubordinatedAlbumID() {
		return subordinatedAlbumID;
	}
	public void setSubordinatedAlbumID(Long subordinatedAlbumID) {
		this.subordinatedAlbumID = subordinatedAlbumID;
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
		return DTOKind.TRACK_KIND;
	}
	
	public Track(JSONObject json) throws XimalayaException {
		super();
		init(json);
	}
	
	public Track(HttpResponse response) throws XimalayaException {
		super();
		init(response.asJSONObject());
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				id = json.getLong("id");
				trackTitle = json.getString("track_title");
				trackTags = json.getString("track_tags");
				trackIntro = json.getString("track_intro");
				coverUrlSmall = json.getString("cover_url_small");
				coverUrlMiddle = json.getString("cover_url_middle");
				coverUrlLarge = json.getString("cover_url_large");
				uid = json.getLong("uid");
				nickname = json.getString("nickname");
				avatarUrl = json.getString("avatar_url");
				duration = json.getDouble("duration");
				playCount = json.getLong("play_count");
				favoriteCount = json.getLong("favorite_count");
				commentCount = json.getLong("comment_count");
				playUrl32 = json.getString("play_url_32");
				playUrl64 = json.getString("play_url_64");
				subordinatedAlbumID = json.getLong("subordinated_album_id");
				updatedAt = json.getLong("updated_at");
				createdAt = json.getLong("created_at");
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	public static TrackList constructTrackList(HttpResponse response) throws XimalayaException {
		TrackList trackList = new TrackList();
		JSONObject trackListJsonObject = response.asJSONObject();
		try {
			if(trackListJsonObject.has("category_id")) {
				trackList.setCategoryID(trackListJsonObject.getLong("category_id"));
			}
			if(trackListJsonObject.has("category_name")) {
				trackList.setCategoryName(trackListJsonObject.getString("category_name"));
			}
			if(trackListJsonObject.has("tag_name")) {
				trackList.setTagName(trackListJsonObject.getString("tag_name"));
			}
			trackList.setTotalPage(trackListJsonObject.getInt("total_page"));
			trackList.setTotalCount(trackListJsonObject.getInt("total_count"));
			
			List<Track> tracks = new ArrayList<Track> ();
			JSONArray tracksJsonArray = trackListJsonObject.getJSONArray("tracks");
			int size = tracksJsonArray.length();
			for(int i = 0; i < size; i++) {
				tracks.add(new Track(tracksJsonArray.getJSONObject(i)));
			}
			trackList.setTracks(tracks);
		} catch(JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return trackList;
	}
	
	public static List<Track> constructTracks(HttpResponse response) throws XimalayaException {
		List<Track> tracks = new ArrayList<Track> ();
		JSONArray tracksJsonArray = response.asJSONArray();
		try {
			int size = tracksJsonArray.length();
			for(int i = 0; i < size; i++) {
				tracks.add(new Track(tracksJsonArray.getJSONObject(i)));
			}
		} catch (JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return tracks;
	}
	
	public static List<DownloadTrack> constructDownTracks(HttpResponse response) throws XimalayaException {
		List<DownloadTrack> downloadTracks = new ArrayList<DownloadTrack> ();
		JSONArray downloadTracksJsonArray = response.asJSONArray();
		try {
			int size = downloadTracksJsonArray.length();
			for(int i = 0; i < size; i++) {
				downloadTracks.add(new DownloadTrack(downloadTracksJsonArray.getJSONObject(i)));
			}
		} catch (JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return downloadTracks;
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
		
		Track other = (Track) obj;
		if((id == null && other.id != null) 
			|| !id.equals(other.id)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Track {id: ");
		strBuilder.append(id);
		strBuilder.append(", trackTitle: \"");
		strBuilder.append(trackTitle);
		strBuilder.append("\", trackTags: \"");
		strBuilder.append(trackTags);
		strBuilder.append("\", trackIntro: \"");
		strBuilder.append(trackIntro);
		strBuilder.append("\", coverUrlSmall: \"");
		strBuilder.append(coverUrlSmall);
		strBuilder.append("\", coverUrlMiddle: \"");
		strBuilder.append(coverUrlMiddle);
		strBuilder.append("\", coverUrlLarge: \"");
		strBuilder.append(coverUrlLarge);
		strBuilder.append("\", uid: ");
		strBuilder.append(uid);
		strBuilder.append(", nickname: \"");
		strBuilder.append(nickname);
		strBuilder.append("\", avatarUrl: \"");
		strBuilder.append(avatarUrl);
		strBuilder.append("\", duration: ");
		strBuilder.append(duration);
		strBuilder.append(", playCount: ");
		strBuilder.append(playCount);
		strBuilder.append(", favoriteCount: ");
		strBuilder.append(favoriteCount);
		strBuilder.append(", commentCount: ");
		strBuilder.append(commentCount);
		strBuilder.append(", playUrl32: ");
		strBuilder.append(playUrl32);
		strBuilder.append(", playUrl64: ");
		strBuilder.append(playUrl64);
		strBuilder.append(", subordinatedAlbumID: ");
		strBuilder.append(subordinatedAlbumID);
		strBuilder.append(", updatedAt: ");
		strBuilder.append(updatedAt);
		strBuilder.append(", createdAt: ");
		strBuilder.append(createdAt);
		strBuilder.append("}");
		return strBuilder.toString();
	}
	
}
