package com.ximalaya.sdk4j;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;
import com.ximalaya.sdk4j.model.dto.track.TrackList;

public class SearchesTest {
	
	Searches searchesService = new Searches();
	
	@Test
	public void testSearchAlbum() throws XimalayaException {
		AlbumList albumList = searchesService.searchAlbumList("小说", 0, new Paging());
		Assert.assertTrue(albumList != null && albumList.getAlbums() != null && !albumList.getAlbums().isEmpty());
	}
	
	@Test
	public void testSearchTracks() throws XimalayaException {
		TrackList trackList = searchesService.searchTrackList("郭德纲", 0, new Paging());
		Assert.assertTrue(trackList != null && trackList.getTracks() != null && !trackList.getTracks().isEmpty());
	}

}
