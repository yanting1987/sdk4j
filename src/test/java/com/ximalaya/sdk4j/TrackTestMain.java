package com.ximalaya.sdk4j;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;

public class TrackTestMain {
	
	public static void main(String[] args) throws XimalayaException {
		Tracks tracks = new Tracks();
//		tracks.batchGetTracks(new long[] { 13783610,13783618 }); 
		tracks.getHotTrackList(1, null, new Paging());
	}

}
