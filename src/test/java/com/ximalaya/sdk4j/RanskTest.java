package com.ximalaya.sdk4j;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.Album;
import com.ximalaya.sdk4j.model.dto.live.Radio;
import com.ximalaya.sdk4j.model.dto.rank.Rank;
import com.ximalaya.sdk4j.model.dto.track.Track;

public class RanskTest {
	
	Ranks rankService = new Ranks();
	
	@Test
	public void testGetFirstPageRanks() throws XimalayaException {
		List<Rank> ranks = rankService.getFirstPageRanks(1);
		Assert.assertTrue(ranks != null && ranks.size() > 0);
	}
	
	@Test
	public void testGetRankAlbums() throws XimalayaException {
		List<Album> ranks = rankService.getRankAlbums("ranking:album:subscribed:30:0", new Paging());
		Assert.assertTrue(ranks != null && ranks.size() > 0);
	}
	
	@Test
	public void testGetRankRadios() throws XimalayaException {
		List<Radio> ranks = rankService.getRankRadios(5);
		Assert.assertTrue(ranks != null && ranks.size() > 0);
	}
	
	@Test
	public void testGetRankTracks() throws XimalayaException {
		List<Track> ranks = rankService.getRankTracks("ranking:track:played:1:0", new Paging());
		Assert.assertTrue(ranks != null && ranks.size() > 0);
	}
}
