package com.ximalaya.sdk4j.model.dto.album;

import com.ximalaya.sdk4j.model.DTOKind;
import com.ximalaya.sdk4j.model.dto.IKindAware;

public class AlbumTrackCount implements IKindAware {
	
	private Long id;           // ID
	private Long trackCount;   // 该专辑包含声音数
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTrackCount() {
		return trackCount;
	}
	public void setTrackCount(Long trackCount) {
		this.trackCount = trackCount;
	}
	
	@Override
	public String getKind() {
		return DTOKind.ALBUM_KIND;
	}

}
