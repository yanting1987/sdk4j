package com.ximalaya.sdk4j;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.Sort;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.rank.Rank;

public class AlbumTestMain {
	
	private static final Albums albumService = new Albums();
	private static final Lives liveService = new Lives();
	private static final Ranks rankService = new Ranks();
	private static final Banners bannerService = new Banners();
	
	public static void main(String[] args) throws XimalayaException {
//		albumService.getAnnouncerAlbums(30495264, new Paging());
//		albumService.browseAlbumTracks(3576345, new Paging(), Sort.ASC);
//		liveService.getPlayingProgram(12);
//		rankService.getRankRadios(200);
		bannerService.getDiscoveryBanners();
	}

}
