package com.ximalaya.sdk4j;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;

public class SearchTestMain {
	
	public static void main(String[] args) throws XimalayaException {
		Searches search = new Searches();
//		search.searchAlbumList("故事", new Paging());
//		search.searchAlbumList("小说", new Paging());
		search.searchAlbumList("音乐", new Paging());
	}

}
