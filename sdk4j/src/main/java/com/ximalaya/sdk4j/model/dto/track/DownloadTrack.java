package com.ximalaya.sdk4j.model.dto.track;

import com.ximalaya.sdk4j.model.dto.DTOKind;
import com.ximalaya.sdk4j.model.dto.IKindAware;

/**
 * 下载声音DTO
 * @author will
 *
 */
public class DownloadTrack implements IKindAware {
	
	private Long id;             // ID
	private String trackTitle;   // 声音标题
	private String playUrl32;    // 声音32位播放地址
	private String playUrl64;    // 声音64位播放地址
	private String playUrlAac;   // aac格式音频下载地址
	
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
	public String getPlayUrlAac() {
		return playUrlAac;
	}
	public void setPlayUrlAac(String playUrlAac) {
		this.playUrlAac = playUrlAac;
	}
	@Override
	public String getKind() {
		return DTOKind.TRACK_KIND;
	}

}
