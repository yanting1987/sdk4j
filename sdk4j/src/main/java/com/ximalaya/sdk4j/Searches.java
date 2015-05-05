package com.ximalaya.sdk4j;

import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.Album;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;
import com.ximalaya.sdk4j.model.dto.track.Track;
import com.ximalaya.sdk4j.model.dto.track.TrackList;

/**
 * 搜索，包括专辑搜索和声音搜索
 * @author will
 *
 */
public class Searches extends Ximalaya {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2133121637009516256L;
	
	/**
	 * 搜索专辑
	 * 
	 * @param q 搜索词，必填
	 * @param categoryID 分类ID，0-热门分类，1-...
	 * @param paging 分页参数，可选，不填则为默认值
	 * @return
	 * @throws XimalayaException
	 */
	public AlbumList searchAlbumList(String q, long categoryID,  Paging paging) throws XimalayaException {
		checkSearchParam(q, categoryID);
		paging = paging == null ? new Paging(): paging;
		return Album.constructAlbumList(
				CLIENT.get(String.format("%s/search/albums", BASE_URL),
						   assembleHttpParams(constructSpecificParamsForSearch(q, categoryID, paging))));
	}
	
	/**
	 * 搜索声音
	 * 
	 * @param q      搜索词，必填
	 * @param categoryID 分类ID，0-热门分类，1-...
	 * @param paging 分页参数，可选，不填则为默认值
	 * @return
	 * @throws XimalayaException
	 */
	public TrackList searchTrackList(String q, long categoryID, Paging paging) throws XimalayaException {
		checkSearchParam(q, categoryID);
		paging = paging == null ? new Paging(): paging;
		return Track.constructTrackList(
				CLIENT.get(String.format("%s/search/tracks", BASE_URL),
						   assembleHttpParams(constructSpecificParamsForSearch(q, categoryID, paging))));
	}
	
	private void checkSearchParam(String q, long categoryID) {
		if(q == null || q.isEmpty()) {
			throw new IllegalArgumentException("q should not empty");
		}
		if(categoryID < 0) {
			throw new IllegalArgumentException("category_id should >= 0");
		}
	}
	
	private HttpParameter[] constructSpecificParamsForSearch(String q, long categoryID,  Paging paging) {
		HttpParameter[] specificParams = new HttpParameter[4];
		specificParams[0] = new HttpParameter("q", q);
		specificParams[1] = new HttpParameter("category_id", categoryID);
		specificParams[2] = new HttpParameter("page", paging.getPage());
		specificParams[3] = new HttpParameter("count", paging.getCount());
		return specificParams;
	}
	
}
