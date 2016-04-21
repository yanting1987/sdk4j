package com.ximalaya.sdk4j;

import com.ximalaya.sdk4j.model.XimalayaException;

public class RankTestMain {
	
	public static void main(String[] args) throws XimalayaException {
		Ranks rankService = new Ranks();
		rankService.getRankRadios(100);
	}

}