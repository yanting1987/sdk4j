package com.ximalaya.sdk4j.model.dto.live;

import java.io.Serializable;
import java.util.List;

/**
 * 昨天、今天和明天的节目时间表
 * 
 * @author will
 *
 */
public class ThreeDaySchedules implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2828832946556051213L;
	
	private List<Schedule> yesterdaySchedules;
	private List<Schedule> todaySchedules;
	private List<Schedule> tomorrowSchedules;
	
	public List<Schedule> getYesterdaySchedules() {
		return yesterdaySchedules;
	}
	public void setYesterdaySchedules(List<Schedule> yesterdaySchedules) {
		this.yesterdaySchedules = yesterdaySchedules;
	}
	public List<Schedule> getTodaySchedules() {
		return todaySchedules;
	}
	public void setTodaySchedules(List<Schedule> todaySchedules) {
		this.todaySchedules = todaySchedules;
	}
	public List<Schedule> getTomorrowSchedules() {
		return tomorrowSchedules;
	}
	public void setTomorrowSchedules(List<Schedule> tomorrowSchedules) {
		this.tomorrowSchedules = tomorrowSchedules;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("ThreeDaySchedules {yesterdaySchedules: [");
		appendSchedule(strBuilder, yesterdaySchedules);
		strBuilder.append("], todaySchedules: [");
		appendSchedule(strBuilder, todaySchedules);
		strBuilder.append("], tomorrowSchedules: [");
		appendSchedule(strBuilder, tomorrowSchedules);
		strBuilder.append("]}");
		return strBuilder.toString();
	}
	
	private void appendSchedule(StringBuilder strBuilder, List<Schedule> schedules) {
		if(schedules != null && !schedules.isEmpty()) {
			for(Schedule schedule: schedules) {
				strBuilder.append(schedule.toString());
				strBuilder.append(", ");
			}
		}
	}
	
}
