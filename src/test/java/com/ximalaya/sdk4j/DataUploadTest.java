package com.ximalaya.sdk4j;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ximalaya.sdk4j.DataUpload;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.upload.LiveRecord;
import com.ximalaya.sdk4j.model.dto.upload.TrackRecord;

public class DataUploadTest {

	DataUpload uploadService = new DataUpload();
	
	@Test
	public void testUploadSingleLiveRecord() throws XimalayaException {
		LiveRecord liveRecord = new LiveRecord();
		liveRecord.setRadio_id(123456789);
		liveRecord.setPlayed_secs(32323.33D);
		liveRecord.setDuration(33333.33D);
		uploadService.uploadSingleLiveRecord(liveRecord);
	}
	
	@Test
	public void testUploadSingleLiveRecords() throws XimalayaException {
		List<LiveRecord> liveRecords = new ArrayList<LiveRecord>();
		LiveRecord liveRecord = new LiveRecord();
		liveRecord.setRadio_id(123456789);
		liveRecord.setPlayed_secs(32323.33D);
		liveRecord.setDuration(33333.33D);
		liveRecords.add(liveRecord);
		uploadService.uploadBatchLiveRecord(liveRecords);
	}
	
	@Test
	public void testUploadSingleTrackRecord() throws XimalayaException {
		TrackRecord trackRecord = new TrackRecord();
		trackRecord.setTrack_id(264899);
		trackRecord.setPlay_type(0);
		trackRecord.setDuration(2223.3D);
		trackRecord.setPlayed_secs(2223.3D);
		uploadService.uploadSingleTrackRecord(trackRecord);
	}
	
	@Test
	public void testUploadSingleTrackRecords() throws XimalayaException {
		List<TrackRecord> trackRecords = new ArrayList<TrackRecord>();
		TrackRecord trackRecord = new TrackRecord();
		trackRecord.setTrack_id(264899);
		trackRecord.setPlay_type(0);
		trackRecord.setDuration(2223.3D);
		trackRecord.setPlayed_secs(2223.3D);
		trackRecords.add(trackRecord);
		uploadService.uploadBatchTrackRecord(trackRecords);
	}
}
