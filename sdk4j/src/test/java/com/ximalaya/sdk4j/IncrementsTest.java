package com.ximalaya.sdk4j;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.IncrementAlbumList;
import com.ximalaya.sdk4j.model.dto.live.IncrementRadioList;
import com.ximalaya.sdk4j.model.dto.live.IncrementSchedule;
import com.ximalaya.sdk4j.model.dto.track.IncrementTrackList;

public class IncrementsTest {
	
	Increments increments = new Increments();
	
	@Test
	public void testGetIncrementAlbumList() throws XimalayaException {
		IncrementAlbumList incrAlbumList = increments.getIncrementAlbumList(0L, "小说", null, 1434351797388L);
		assertTrue(incrAlbumList != null && !(incrAlbumList.getAlbums()==null) 
			&& !incrAlbumList.getAlbums().isEmpty());
	}
	
	@Test
	public void testGetIncrementRadioList() throws XimalayaException {
		IncrementRadioList incrRadioList = increments.getIncrementRadioList(2, "360000", new Paging(), 1434003325300L);
		assertTrue(incrRadioList != null && !(incrRadioList.getRadios()==null) 
			&& !incrRadioList.getRadios().isEmpty());
	}
	
	@Test
	public void testGetIncrementSchedules() throws XimalayaException {
		List<IncrementSchedule> scheduleList = increments.getIncrementSchedules(610, 0, 1434003325300L);
		assertTrue(scheduleList != null && !scheduleList.isEmpty());
	}
	
	@Test
	public void testGetIncrementTracks() throws XimalayaException {
		IncrementTrackList trackList = increments.getIncrementTracks(1, new Paging(), 1434351797388L);
		assertTrue(trackList != null && !(trackList.getTracks()==null) 
			&& !trackList.getTracks().isEmpty());
	}

}
