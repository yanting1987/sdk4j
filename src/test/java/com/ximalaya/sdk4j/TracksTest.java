package com.ximalaya.sdk4j;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.track.Track;
import com.ximalaya.sdk4j.model.dto.track.TrackList;

public class TracksTest {

	Tracks tracksService = new Tracks();

//	@Test
//	public void testGetHotTrackList() throws XimalayaException {
//		TrackList trackList = tracksService.getHotTrackList(0, null, null);
//		List<Track> tracks = trackList.getTracks();
//		Assert.assertTrue(tracks != null && !tracks.isEmpty());
//	}

/*	@Test
	public void testBatchGetTracks() throws XimalayaException {
		List<Track> tracks = tracksService.batchGetTracks(new long[] { 7368204,
				7349613 }); // 有版权
		Assert.assertTrue(tracks != null && tracks.size() > 0);
	}*/

	@Test
	public void testGetLastPlayTracks() throws XimalayaException {
		//TrackList trackList = tracksService.getLastPlayTracks(87415L, 20924L, 265031L, 5);
		TrackList trackList = tracksService.getLastPlayTracks(86573L, 713L, 259713L, 2);
		List<Track> tracks = trackList.getTracks();
		for(Track track:tracks){
			System.out.println(track.getCoverUrlLarge());
		}
	}
}
