package com.ximalaya.sdk4j.model.dto.album;

import java.util.List;

import com.ximalaya.sdk4j.model.dto.AbstractPageResult;

/***
 * 专辑列表DTO
 * @author will
 *
 */
public class AlbumList extends AbstractPageResult {
	
	private Long categoryID;       // 标签所属分类ID，可选
	private String categoryName;   // 标签所属分类名称，可选
	private String tagName;        // 标签名，可选
	private List<Album> albums;    // 专辑列表
	
	public Long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public List<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryID == null) ? 0 : categoryID.hashCode());
		result = prime * result + ((tagName == null) ? 0: tagName.hashCode());
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
		
		AlbumList other = (AlbumList) obj;
		if((categoryID == null && other.categoryID != null) 
			|| !categoryID.equals(other.categoryID)) {
			return false;
		}
		if(tagName == null && other.tagName != null
			|| !tagName.equals(other.tagName)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("AlbumList {categoryID: ");
		strBuilder.append(categoryID);
		strBuilder.append(", categoryName: \"");
		strBuilder.append(categoryName);
		strBuilder.append("\", tagName: \"");
		strBuilder.append(tagName);
		strBuilder.append("\", albums: [");
		if(albums != null && !albums.isEmpty()) {
			for(Album album: albums) {
				strBuilder.append(album.toString());
				strBuilder.append(", ");
			}
			strBuilder.deleteCharAt(strBuilder.lastIndexOf(","));
		}
		strBuilder.append("]}");
		return strBuilder.toString();
	}
	
}
