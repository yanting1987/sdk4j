package com.ximalaya.sdk4j;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;

public class AlbumTestMain {
	
	private static final Albums albumService = new Albums();
	
	public static void main(String[] args) throws XimalayaException {
		albumService.getAnnouncerAlbums(30495264, new Paging());
	}

}
