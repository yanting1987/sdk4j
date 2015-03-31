package com.ximalaya.sdk4j.model.dto.album;

import com.ximalaya.sdk4j.model.dto.DTOKind;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		UpdatedAlbum other = (UpdatedAlbum) obj;
		if((id == null && other.id != null) 
			|| !id.equals(other.id)) {
			return false;
		}
		
		return true;
	}

}
