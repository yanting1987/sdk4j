package com.ximalaya.sdk4j.model.dto.track;

import java.io.Serializable;

import com.ximalaya.sdk4j.model.DTOKind;
import com.ximalaya.sdk4j.model.dto.IKindAware;

/**
 * 声音DTO
 * @author will
 *
 */
public class Track implements IKindAware, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4324052388239950724L;
	
	private Long id;          // ID
	private String trackTitle;               // 声音标题
	private String trackTags;                // 声音标签列表字符串，以英文逗号分隔
	private String trackIntro;               // 声音简介
	private String coverUrlSmall;            // 声音封面小图
	private String coverUrlMiddle;           // 声音封面中图
	private String coverUrlLarge;            // 声音封面大图
	private String nickname;                 // 声音所属主播用户名
	private String avatarUrl;                // 声音所属主播头像
	private Double duration;                // 声音时长
	private Long playCount;                  // 声音播放次数
	private Integer favoriteCount;           // 声音喜欢数
	private String playUrl32;                // 声音32位播放地址
	private String playUrl64;                // 声音64位播放地址
	private Long subordinatedAlbumID;        // 声音所属专辑ID
	private Long updatedAt;   // 更新时间
	private Long createdAt;   // 更新时间
	
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
	public Integer getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
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
	
}
