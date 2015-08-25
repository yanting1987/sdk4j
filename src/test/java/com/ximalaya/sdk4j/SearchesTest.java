package com.ximalaya.sdk4j;

import java.util.List;

import com.ximalaya.sdk4j.model.AllList;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;
import com.ximalaya.sdk4j.model.dto.live.RadioList;
import com.ximalaya.sdk4j.model.dto.search.HotWord;
import com.ximalaya.sdk4j.model.dto.search.SuggestWordList;
import com.ximalaya.sdk4j.model.dto.track.TrackList;

import org.junit.Assert;
import org.junit.Test;

public class SearchesTest {
	
static	Searches searchesService = new Searches();
	
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

	@Test
	public void testSearchHotWords() throws XimalayaException {
		List<HotWord> hotWordList = searchesService.searchHotWords(10);
		Assert.assertTrue(hotWordList != null && !hotWordList.isEmpty());
	}

	@Test
	public void testSearchSuggestWords() throws XimalayaException {
		SuggestWordList suggestWordList = searchesService.searchSuggestWords("郭");
		Assert.assertNotNull(suggestWordList);
		Assert.assertNotNull(suggestWordList.getAlbums());
		Assert.assertTrue(!suggestWordList.getAlbums().isEmpty());
		Assert.assertNotNull(suggestWordList.getKeywords());
		Assert.assertTrue(!suggestWordList.getKeywords().isEmpty());
	}

	@Test
	public void testSearchRadios() throws XimalayaException {
		RadioList radioList=searchesService.searchRadios("郭德纲", 2, 1);
		Assert.assertTrue(!radioList.getRadios().isEmpty());
	}

	@Test
	public void testSearchAll() throws XimalayaException {
	    AllList allList= searchesService.searchAll("郭德纲", 2, 1);
		Assert.assertTrue(allList!=null);
	}
}
