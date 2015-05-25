package com.ximalaya.sdk4j;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.track.DownloadTrack;
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
		List<Track> tracks = tracksService.batchGetTracks(new long[] { 251739, 252045 });
		Assert.assertTrue(tracks != null && !tracks.isEmpty());
	}
	
	@Test
	public void testBatchGetDownloadTracks() throws XimalayaException {
		List<DownloadTrack> downTracks = tracksService.batchGetDownloadTracks(new long[] { 251739, 252045 });
		Assert.assertTrue(downTracks != null && !downTracks.isEmpty());
	}

}
