package com.ximalaya.sdk4j;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.Album;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;
import com.ximalaya.sdk4j.model.dto.album.AlbumTrackCount;
import com.ximalaya.sdk4j.model.dto.album.AlbumTracks;

public class AlbumsTest {
	
	Albums albumsService = new Albums();
	
	@Test
	public void testGetHotAlbumList() throws XimalayaException {
		AlbumList albumList = albumsService.getHotAlbumList(6L, null, new Paging());
		List<Album> albums = albumList.getAlbums();
		Assert.assertNotNull(albums);
		Assert.assertFalse(albums.isEmpty());
	}
	
	@Test
	public void testBatchGetAlbums() throws XimalayaException {
		List<Album> albums = albumsService.batchGetAlbums(new long[] {74391, 78349});
		Assert.assertNotNull(albums);
		Assert.assertFalse(albums.isEmpty());
	}
	
	@Test
	public void testBatchGetAlbumTrackCounts() throws XimalayaException {
		List<AlbumTrackCount> albumTrackCounts = albumsService.batchGetAlbumTrackCounts(new long[] { 74391, 78349 });
		Assert.assertNotNull(albumTrackCounts);
		Assert.assertFalse(albumTrackCounts.isEmpty());
	}
	
	@Test
	public void testBrowseAlbumTracks() throws XimalayaException {
		AlbumTracks albumTracks = albumsService.browseAlbumTracks(74391, new Paging());
		Assert.assertNotNull(albumTracks);
	}

}