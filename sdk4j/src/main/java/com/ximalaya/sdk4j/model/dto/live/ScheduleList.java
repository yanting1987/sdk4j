package com.ximalaya.sdk4j.model.dto.live;

import java.io.Serializable;
import java.util.List;

import com.ximalaya.sdk4j.model.dto.AbstractPageResult;

/**
 * 节目时间表列表
 * 
 * @author will
 *
 */
public class ScheduleList extends AbstractPageResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2828832946556051213L;
	
	private List<Schedule> schedules;
	
	public List<Schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("ScheduleList {totalCount: [");
		strBuilder.append(totalCount);
		strBuilder.append(", totalPage: ");
		strBuilder.append(totalPage);
		strBuilder.append(", schedules: [");
		if(schedules != null && !schedules.isEmpty()) {
			for(Schedule schedule: schedules) {
				strBuilder.append(schedule.toString());
				strBuilder.append(", ");
			}
			strBuilder.deleteCharAt(strBuilder.lastIndexOf(","));
		}
		strBuilder.append("]}");
		return strBuilder.toString();
	}
}
