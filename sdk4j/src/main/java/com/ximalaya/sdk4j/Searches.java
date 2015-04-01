package com.ximalaya.sdk4j;

import com.ximalaya.sdk4j.model.HttpParameter;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.Album;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;
import com.ximalaya.sdk4j.model.dto.track.Track;
import com.ximalaya.sdk4j.model.dto.track.TrackList;


public class Searches extends Ximalaya {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2133121637009516256L;
	
	/**
	 * 搜索专辑
	 * 
	 * @param q      搜索词，必填
	 * @param paging 分页参数，可选，不填则为默认值
	 * @return
	 * @throws XimalayaException
	 */
	public AlbumList searchAlbumList(String q, Paging paging) throws XimalayaException {
		checkSearchParam(q, paging);
		return Album.constructAlbumList(
				CLIENT.get(String.format("%s/search/albums", BASE_URL),
						   assembleHttpParams(constructSpecificParamsForSearch(q, paging))));
	}
	
	/**
	 * 搜索声音
	 * 
	 * @param q      搜索词，必填
	 * @param paging 分页参数，可选，不填则为默认值
	 * @return
	 * @throws XimalayaException
	 */
	public TrackList searchTrackList(String q, Paging paging) throws XimalayaException {
		checkSearchParam(q, paging);
		return Track.constructTrackList(
				CLIENT.get(String.format("%s/search/tracks", BASE_URL),
						   assembleHttpParams(constructSpecificParamsForSearch(q, paging))));
	}
	
	private void checkSearchParam(String q, Paging paging) {
		if(q == null || q.isEmpty()) {
			throw new IllegalArgumentException("q should not empty");
		}
		paging = (paging == null) ? new Paging() : paging;
	}
	
	private HttpParameter[] constructSpecificParamsForSearch(String q, Paging paging) {
		HttpParameter[] specificParams = new HttpParameter[3];
		specificParams[0] = new HttpParameter("q", q);
		specificParams[1] = new HttpParameter("page", paging.getPage());
		specificParams[2] = new HttpParameter("count", paging.getCount());
		return specificParams;
	}
	
}
