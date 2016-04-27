package com.ximalaya.sdk4j;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.Sort;
import com.ximalaya.sdk4j.model.XimalayaException;

public class AlbumTestMain {
	
	private static final Categories categoryService = new Categories();
	private static final Tags tagService = new Tags();
	private static final Albums albumService = new Albums();
//	private static final Lives liveService = new Lives();
//	private static final Ranks rankService = new Ranks();
//	private static final Banners bannerService = new Banners();
	
	public static void main(String[] args) throws XimalayaException {
//		albumService.getAnnouncerAlbums(30495264, new Paging());
//		albumService.browseAlbumTracks(3576345, new Paging(), Sort.ASC);
//		liveService.getPlayingProgram(12);
//		rankService.getRankRadios(200);
//		bannerService.getDiscoveryBanners();
//		albumService.getAnnouncerAlbums(2012232, new Paging());
		
		albumService.getRecommendDownloadAlbumList(1, new Paging());
		
//		categoryService.getCategories();
//		tagService.getTagsV2(6, 0);
//		categoryService.getRecommendCategories();
//		albumService.getAlbumList(28, null, 1, new Paging());
//		albumService.getAlbumListV2(28, null, 1, new Paging());
	}

}
