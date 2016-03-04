package com.ximalaya.sdk4j.model.dto.upload;


/**
 * 
 * @author william.zhang
 *
 */
public class TrackRecord {

	private Integer trackId;			//必填	声音ID
	private Double duration;			//必填	播放时长，单位秒。即播放一个音频过程中，真正处于播放中状态的总时间。
	private Double playedSecs;			//必填	播放第几秒或最后播放到的位置，是相对于这个音频开始位置的一个值。
												//如果没有拖动播放条、快进、快退、暂停、单曲循环等操作，played_secs的值一般和duration一致。
	private Long startedAt;				//选填	播放开始时刻，Unix毫秒数时间戳
	private Integer playType;			//必填	0：联网播放，1：断网播放
	
	
	public TrackRecord() {
	}
	
	public Integer getTrackId() {
		return trackId;
	}
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public Double getPlayedSecs() {
		return playedSecs;
	}
	public void setPlayedSecs(Double playedSecs) {
		this.playedSecs = playedSecs;
	}
	public Long getStartedAt() {
		return startedAt;
	}
	public void setStartedAt(Long startedAt) {
		this.startedAt = startedAt;
	}
	public Integer getPlayType() {
		return playType;
	}
	public void setPlayType(Integer playType) {
		this.playType = playType;
	}

	@Override
	public String toString() {
		return "TrackRecord {trackId=" + trackId + ", duration=" + duration 
				+ ", playedSecs=" + playedSecs + ", startedAt=" + startedAt
				+ ", playType=" + playType + "}";
	}
	
}
