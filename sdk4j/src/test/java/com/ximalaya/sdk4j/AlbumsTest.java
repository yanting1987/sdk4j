package com.ximalaya.sdk4j;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;

public class AlbumsTest {
	
	Albums albums = new Albums();
	
	@Test
	public void testGetAlbumList() throws XimalayaException {
		AlbumList albumList = albums.getAlbumList(6L, null, new Paging());
		Assert.assertFalse(albumList.getAlbums().isEmpty());
	}

}