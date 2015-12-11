package com.ximalaya.sdk4j.model.dto.profile;

import java.io.Serializable;
import java.util.List;

import com.ximalaya.sdk4j.model.dto.AbstractPageResult;

public class AnnouncerList extends AbstractPageResult implements Serializable {
	private static final long serialVersionUID = 4955837491785999565L;
	
	private Long vcategoryID;   			// 主播分类ID
	private List<Announcer> announcers;
	
	public Long getVcategoryID() {
		return vcategoryID;
	}
	public void setVcategoryID(Long vcategoryID) {
		this.vcategoryID = vcategoryID;
	}
	public List<Announcer> getAnnouncers() {
		return announcers;
	}
	public void setAnnouncers(List<Announcer> announcers) {
		this.announcers = announcers;
	}
	
	
}