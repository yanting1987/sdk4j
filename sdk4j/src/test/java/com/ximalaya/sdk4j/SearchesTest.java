package com.ximalaya.sdk4j;

import org.junit.Test;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;
import com.ximalaya.sdk4j.model.dto.track.TrackList;

public class SearchesTest {
	
	Searches searchesService = new Searches();
	
	@Test
	public void testSearchAlbum() throws XimalayaException {
		AlbumList albumList = searchesService.searchAlbumList("郭德纲", new Paging());
		System.out.println(albumList);
	}
	
	@Test
	public void testSearchTracks() throws XimalayaException {
		TrackList trackList = searchesService.searchTrackList("郭德纲", new Paging());
		System.out.println(trackList);
	}

}
