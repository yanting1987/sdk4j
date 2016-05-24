package com.ximalaya.sdk4j.model.dto.upload;


/**
 * 
 * @author william.zhang
 *
 */
public class TrackRecord {

	private Integer track_id;			//必填	声音ID
	private Double duration;			//必填	播放时长，单位秒。即播放一个音频过程中，真正处于播放中状态的总时间。
	private Double played_secs;			//必填	播放第几秒或最后播放到的位置，是相对于这个音频开始位置的一个值。
										//如果没有拖动播放条、快进、快退、暂停、单曲循环等操作，played_secs的值一般和duration一致。
	private Long  started_at;			//选填	播放开始时刻，Unix毫秒数时间戳
	private Integer play_type;			//必填	0：联网播放，1：断网播放
	
	public TrackRecord() {
	}
	
	public Integer getTrack_id() {
		return track_id;
	}

	public void setTrack_id(Integer track_id) {
		this.track_id = track_id;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Double getPlayed_secs() {
		return played_secs;
	}

	public void setPlayed_secs(Double played_secs) {
		this.played_secs = played_secs;
	}

	public Long getStarted_at() {
		return started_at;
	}

	public void setStarted_at(Long started_at) {
		this.started_at = started_at;
	}

	public Integer getPlay_type() {
		return play_type;
	}

	public void setPlay_type(Integer play_type) {
		this.play_type = play_type;
	}

	@Override
	public String toString() {
		return "TrackRecord {track_id=" + track_id + ", duration=" + duration + ", played_secs=" 
				+ played_secs + ", started_at=" + started_at
				+ ", play_type=" + play_type + "}";
	}
	
}
