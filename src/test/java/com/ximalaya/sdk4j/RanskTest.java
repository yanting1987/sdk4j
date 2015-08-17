package com.ximalaya.sdk4j;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;
import com.ximalaya.sdk4j.model.dto.live.RadioList;
import com.ximalaya.sdk4j.model.dto.rank.RankList;
import com.ximalaya.sdk4j.model.dto.track.TrackList;

public class RanskTest {
	
	Ranks rankService = new Ranks();
	
	@Test
	public void testGetFirstPageRanks() throws XimalayaException {
		RankList ranks = rankService.getFirstPageRanks(1);
		Assert.assertTrue(ranks != null && ranks.getRanks()!= null && ranks.getRanks().size() > 0);
	}
	
	@Test
	public void testGetRankAlbums() throws XimalayaException {
		AlbumList albumList = rankService.getRankAlbums("ranking:album:subscribed:30:0", new Paging());
		Assert.assertTrue(albumList != null && albumList.getAlbums() != null && albumList.getAlbums().size() > 0);
	}
	
	@Test
	public void testGetRankRadios() throws XimalayaException {
		RadioList radios = rankService.getRankRadios(5);
		Assert.assertTrue(radios != null && radios.getRadios() != null && radios.getRadios().size() > 0);
	}
	
	@Test
	public void testGetRankTracks() throws XimalayaException {
		TrackList tracks = rankService.getRankTracks("ranking:track:played:1:0", new Paging());
		Assert.assertTrue(tracks != null && tracks.getTracks() != null && tracks.getTracks().size() > 0);
	}
}
