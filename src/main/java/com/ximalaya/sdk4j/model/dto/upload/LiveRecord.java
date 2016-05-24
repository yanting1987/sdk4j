package com.ximalaya.sdk4j.model.dto.upload;

/**
 * 
 * @author william.zhang
 *
 */
public class LiveRecord {

	private Integer radio_id;				//必填	电台ID
	private Integer program_schedule_id;	//选填	节目排期ID
	private Integer program_id;				//选填	节目ID
	private Double duration;				//必填	播放时长，单位秒。即播放一个音频过程中，真正处于播放中状态的总时间。
	private Double played_secs;				//必填	播放第几秒或最后播放到的位置，是相对于这个音频开始位置的一个值。
											//如果没有拖动播放条、快进、快退、暂停、单曲循环等操作，played_secs的值一般和duration一致。
	private Long startedAt;					//选填	播放开始时刻，Unix毫秒数时间戳
	
	public LiveRecord() {
	}

	public Integer getRadio_id() {
		return radio_id;
	}

	public void setRadio_id(Integer radio_id) {
		this.radio_id = radio_id;
	}

	public Integer getProgram_schedule_id() {
		return program_schedule_id;
	}

	public void setProgram_schedule_id(Integer program_schedule_id) {
		this.program_schedule_id = program_schedule_id;
	}

	public Integer getProgram_id() {
		return program_id;
	}

	public void setProgram_id(Integer program_id) {
		this.program_id = program_id;
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

	public Long getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Long startedAt) {
		this.startedAt = startedAt;
	}

	@Override
	public String toString() {
		return "LiveRecord {radio_id=" + radio_id + ", program_schedule_id=" + program_schedule_id 
				+ ", program_id=" + program_id + ", duration=" + duration + ", played_secs=" 
				+ played_secs + ", startedAt=" + startedAt + "]";
	}

}
