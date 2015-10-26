package com.ximalaya.sdk4j.model.dto.album;

import com.ximalaya.sdk4j.model.dto.AbstractPageResult;

import java.io.Serializable;
import java.util.List;


public class RelativeAlbumList extends AbstractPageResult implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<RelativeAlbum> reletiveAlbum;    // 推荐专辑列表

	public List<RelativeAlbum> getReletiveAlbum() {
		return reletiveAlbum;
	}

	public void setReletiveAlbum(List<RelativeAlbum> reletiveAlbum) {
		this.reletiveAlbum = reletiveAlbum;
	}
}
