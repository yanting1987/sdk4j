package com.ximalaya.sdk4j;

import com.ximalaya.sdk4j.model.XimalayaException;

public class RecommendTest {
	
	public static void main(String[] args) throws XimalayaException {
		Albums albums = new Albums();
		albums.getCategoryRecommondAlbums(3, 3);
	}

}
