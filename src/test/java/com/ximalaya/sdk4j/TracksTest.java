package com.ximalaya.sdk4j;

import java.util.List;

import com.ximalaya.sdk4j.model.dto.album.ReletiveAlbum;
import com.ximalaya.sdk4j.model.dto.album.ReletiveAlbumList;
import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.track.Track;
import com.ximalaya.sdk4j.model.dto.track.TrackList;

public class TracksTest {

	Tracks tracksService = new Tracks();

	@Test
	public void testGetHotTrackList() throws XimalayaException {
		TrackList trackList = tracksService.getHotTrackList(0, null, null);
		List<Track> tracks = trackList.getTracks();
		Assert.assertTrue(tracks != null && !tracks.isEmpty());
	}

	@Test
	public void testBatchGetTracks() throws XimalayaException {
		List<Track> tracks = tracksService.batchGetTracks(new long[]{7368204, 7349613}); // 有版权
		Assert.assertTrue(tracks != null && tracks.size() > 0);
	}

	@Test
	public void testGetLastPlayTracks() throws XimalayaException {
		TrackList trackList = tracksService.getLastPlayTracks(12964151L, 275158L, 7861837L, 2);
		List<Track> tracks = trackList.getTracks();
		Assert.assertTrue(trackList != null && tracks != null && tracks.size() > 0);
	}

	@Test
	public void testReletiveAlbum() throws XimalayaException {
		//ReletiveAlbumList reletiveAlbumList = tracksService.getReletiveAlbums(265749L);    //测试
		ReletiveAlbumList reletiveAlbumList = tracksService.getReletiveAlbums(6625829L);      //正网
		List<ReletiveAlbum> reletiveAlbums=reletiveAlbumList.getReletiveAlbum();
		Assert.assertTrue(reletiveAlbums != null );

	}
}
