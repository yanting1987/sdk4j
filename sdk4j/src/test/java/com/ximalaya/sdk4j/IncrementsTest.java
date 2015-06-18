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
	private static final long LESSTHENTENMINUTES = System.currentTimeMillis()-60*8*1000;
	
	Increments increments = new Increments();
	
	@Test
	public void testGetIncrementAlbumList() throws XimalayaException {
		IncrementAlbumList incrAlbumList = increments.getIncrementAlbumList(3L, null, null, LESSTHENTENMINUTES);
		assertTrue(incrAlbumList != null && !(incrAlbumList.getAlbums()==null) 
			&& !incrAlbumList.getAlbums().isEmpty());
	}
	
	@Test
	public void testGetIncrementRadioList() throws XimalayaException {
		IncrementRadioList incrRadioList = increments.getIncrementRadioList(2, "540000", new Paging(), LESSTHENTENMINUTES);
		assertTrue(incrRadioList != null && !(incrRadioList.getRadios()==null) 
			&& !incrRadioList.getRadios().isEmpty());
	}
	
	@Test
	public void testGetIncrementSchedules() throws XimalayaException {
		List<IncrementSchedule> scheduleList = increments.getIncrementSchedules(1037, 3, LESSTHENTENMINUTES);
		assertTrue(scheduleList != null && !scheduleList.isEmpty());
	}
	
	@Test
	public void testGetIncrementTrackList() throws XimalayaException {
		IncrementTrackList trackList = increments.getIncrementTrackList(278614, new Paging(), LESSTHENTENMINUTES);
		assertTrue(trackList != null && !(trackList.getTracks()==null) 
			&& !trackList.getTracks().isEmpty());
	}

}
