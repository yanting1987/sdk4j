package com.ximalaya.sdk4j;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.track.Track;
import com.ximalaya.sdk4j.model.dto.track.TrackList;

public class CustomsTest {
	
	public static void main(String[] args) throws XimalayaException {
		Customs customService = new Customs();
		TrackList customTrackList = customService.getTrackList(4, new Paging(1, 20));
		for(Track t: customTrackList.getTracks()) {
			if(t.getDuration() <= 300) {
				System.out.println(t.getId());
			}
		}
		
//		System.out.println(customTrackList.getTracks().size());
	}

}
