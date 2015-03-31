package com.ximalaya.sdk4j.model.dto.album;

import java.util.List;

import com.ximalaya.sdk4j.model.dto.AbstractPageResult;
import com.ximalaya.sdk4j.model.dto.track.Track;

/**
 * 专辑内的声音DTO
 * @author will
 *
 */
public class AlbumTracks extends AbstractPageResult {

	private Long albumID;            // 专辑ID
	private String albumTitle;       // 专辑名称
	private String coverUrlSmall;    // 专辑封面小图
	private String coverUrlMiddle;   // 专辑封面中图
	private String coverUrlLarge;    // 专辑封面大图
	private List<Track> tracks;      // 专辑下的声音（一页）
	
	public Long getAlbumID() {
		return albumID;
	}
	public void setAlbumID(Long albumID) {
		this.albumID = albumID;
	}
	public String getAlbumTitle() {
		return albumTitle;
	}
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
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
	public List<Track> getTracks() {
		return tracks;
	}
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
}
