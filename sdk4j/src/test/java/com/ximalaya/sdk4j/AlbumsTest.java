package com.ximalaya.sdk4j;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.Album;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;
import com.ximalaya.sdk4j.model.dto.album.AlbumTracks;

public class AlbumsTest {
	
	Albums albumsService = new Albums();
	
	@Test
	public void testGetHotAlbumList() throws XimalayaException {
		AlbumList albumList = albumsService.getHotAlbumList(0L, null, new Paging());
		List<Album> albums = albumList.getAlbums();
		Assert.assertTrue(albums != null && !albums.isEmpty());
	}
	
	@Test
	public void testBatchGetAlbums() throws XimalayaException {
		List<Album> albums = albumsService.batchGetAlbums(new long[] {84363, 84365, 84752});
		Assert.assertTrue(albums != null && albums.size() == 2);
	}
	
	@Test
	public void testBrowseAlbumTracks() throws XimalayaException {
		/*
		 * 有版权
		 */
		AlbumTracks albumTracks = albumsService.browseAlbumTracks(84363, new Paging(1, 5));
		Assert.assertTrue(albumTracks != null && albumTracks.getTracks() != null
				&& !albumTracks.getTracks().isEmpty());
		
		/*
		 * 无版权
		 */
		albumTracks = albumsService.browseAlbumTracks(84364, new Paging(1, 5));
		Assert.assertTrue(albumTracks != null && albumTracks.getTracks() == null);
	}

}