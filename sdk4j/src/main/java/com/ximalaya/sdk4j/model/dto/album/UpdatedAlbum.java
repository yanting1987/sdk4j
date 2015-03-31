package com.ximalaya.sdk4j.model.dto.album;

import com.ximalaya.sdk4j.model.DTOKind;
import com.ximalaya.sdk4j.model.dto.IKindAware;

/**
 * 有更新的专辑DTO
 * @author will
 *
 */
public class UpdatedAlbum implements IKindAware {
	
	private Long id;                       // ID
	private String albumTitle;             // 专辑标题
	private Long newUploadTrackCount;      // 在指定时间（包含）后上传的声音数
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAlbumTitle() {
		return albumTitle;
	}
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	public Long getNewUploadTrackCount() {
		return newUploadTrackCount;
	}
	public void setNewUploadTrackCount(Long newUploadTrackCount) {
		this.newUploadTrackCount = newUploadTrackCount;
	}
	
	@Override
	public String getKind() {
		return DTOKind.ALBUM_KIND;
	}

}
