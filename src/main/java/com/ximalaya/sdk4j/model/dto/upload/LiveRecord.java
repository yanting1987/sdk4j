package com.ximalaya.sdk4j.model.dto.upload;

/**
 * 
 * @author william.zhang
 *
 */
public class LiveRecord {

	private Integer radioId;			//必填	电台ID
	private Integer programScheduleId;	//选填	节目排期ID
	private Integer programId;			//选填	节目ID
	private Double duration;			//必填	播放时长，单位秒。即播放一个音频过程中，真正处于播放中状态的总时间。
	private Double playedSecs;			//必填	播放第几秒或最后播放到的位置，是相对于这个音频开始位置的一个值。
												//如果没有拖动播放条、快进、快退、暂停、单曲循环等操作，played_secs的值一般和duration一致。
	private Long startedAt;				//选填	播放开始时刻，Unix毫秒数时间戳
	
	public LiveRecord() {
	}

	public Integer getRadioId() {
		return radioId;
	}

	public void setRadioId(Integer radioId) {
		this.radioId = radioId;
	}

	public Integer getProgramScheduleId() {
		return programScheduleId;
	}

	public void setProgramScheduleId(Integer programScheduleId) {
		this.programScheduleId = programScheduleId;
	}

	public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
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

	@Override
	public String toString() {
		return "LiveRecord {radioId=" + radioId + ", programScheduleId=" + programScheduleId 
				+ ", programId=" + programId + ", duration=" + duration
				+ ", playedSecs=" + playedSecs + ", startedAt=" + startedAt + "}";
	}
	
}
