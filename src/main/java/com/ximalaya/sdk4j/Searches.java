package com.ximalaya.sdk4j;

import java.util.List;

import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.AllList;
import com.ximalaya.sdk4j.model.DTOValidateUtil;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.Album;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;
import com.ximalaya.sdk4j.model.dto.live.Radio;
import com.ximalaya.sdk4j.model.dto.live.RadioList;
import com.ximalaya.sdk4j.model.dto.profile.Announcer;
import com.ximalaya.sdk4j.model.dto.profile.AnnouncerList;
import com.ximalaya.sdk4j.model.dto.search.HotWord;
import com.ximalaya.sdk4j.model.dto.search.SuggestWordList;
import com.ximalaya.sdk4j.model.dto.track.Track;
import com.ximalaya.sdk4j.model.dto.track.TrackList;
import com.ximalaya.sdk4j.util.XimalayaConfig;

/**
 * 搜索，包括专辑搜索和声音搜索
 * 
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
	 * @param q
	 *            搜索词，必填
	 * @param categoryID
	 *            分类ID，必填，如果为0则表示所有分类下的专辑
	 * @param paging
	 *            分页参数，可选，不填则为默认值
	 * @return
	 * @throws XimalayaException
	 */
	public AlbumList searchAlbumList(String q, long categoryID, Integer calcDimension, Paging paging)
			throws XimalayaException {
		checkSearchParam(q, categoryID);
		DTOValidateUtil.validateCalcDimension(calcDimension);
		paging = paging == null ? new Paging() : paging;
		return Album.constructAlbumList(CLIENT.get(String.format("%s/search/albums", XimalayaConfig.getBaseUrl()),
				assembleHttpParams(constructSpecificParamsForSearch(q, categoryID, calcDimension, paging))));
	}

	public AlbumList searchAlbumList(String q, long categoryID, Paging paging) throws XimalayaException {
		checkSearchParam(q, categoryID);
		paging = paging == null ? new Paging() : paging;
		return Album.constructAlbumList(CLIENT.get(String.format("%s/search/albums", XimalayaConfig.getBaseUrl()),
				assembleHttpParams(constructSpecificParamsForSearch(q, categoryID, 4, paging))));
	}

	/**
	 * 搜索专辑
	 * 
	 * @param q
	 *            搜索词，必填
	 * @param paging
	 *            分页参数，可选，不填则为默认值
	 * @return
	 * @throws XimalayaException
	 */
	public AlbumList searchAlbumList(String q, Paging paging) throws XimalayaException {
		checkSearchQ(q);
		paging = paging == null ? new Paging() : paging;
		return Album.constructAlbumList(CLIENT.get(String.format("%s/search/albums", XimalayaConfig.getBaseUrl()),
				assembleHttpParams(constructSpecificParamsForSearch(q, paging))));
	}

	/**
	 * 搜索声音
	 * 
	 * @param q
	 *            搜索词，必填
	 * @param categoryID
	 *            分类ID，必填，如果为0则表示所有分类下的声音
	 * @param paging
	 *            分页参数，可选，不填则为默认值
	 * @return
	 * @throws XimalayaException
	 */
	public TrackList searchTrackList(String q, long categoryID, Integer calcDimension, Paging paging)
			throws XimalayaException {
		checkSearchParam(q, categoryID);
		DTOValidateUtil.validateCalcDimension(calcDimension);
		paging = paging == null ? new Paging() : paging;
		return Track.constructTrackList(CLIENT.get(String.format("%s/search/tracks", XimalayaConfig.getBaseUrl()),
				assembleHttpParams(constructSpecificParamsForSearch(q, categoryID, calcDimension, paging))));
	}

	public TrackList searchTrackList(String q, long categoryID, Paging paging) throws XimalayaException {
		checkSearchParam(q, categoryID);
		paging = paging == null ? new Paging() : paging;
		return Track.constructTrackList(CLIENT.get(String.format("%s/search/tracks", XimalayaConfig.getBaseUrl()),
				assembleHttpParams(constructSpecificParamsForSearch(q, categoryID, 4, paging))));
	}

	/**
	 * 搜索声音
	 * 
	 * @param q
	 *            搜索词，必填
	 * @param paging
	 *            分页参数，可选，不填则为默认值
	 * @return
	 * @throws XimalayaException
	 */
	public TrackList searchTrackList(String q, Paging paging) throws XimalayaException {
		checkSearchQ(q);
		paging = paging == null ? new Paging() : paging;
		return Track.constructTrackList(CLIENT.get(String.format("%s/search/tracks", XimalayaConfig.getBaseUrl()),
				assembleHttpParams(constructSpecificParamsForSearch(q, paging))));
	}

	/**
	 * 获取最近top的热搜词
	 * 
	 * @param top
	 *            热搜词，必填
	 * @return
	 * @throws XimalayaException
	 */
	public List<HotWord> searchHotWords(int top) throws XimalayaException {
		checkSearchTopParam(top);
		return HotWord.constructHotWords(CLIENT.get(String.format("%s/search/hot_words", XimalayaConfig.getBaseUrl()),
				assembleHttpParams(new HttpParameter[] { new HttpParameter("top", top) })));
	}

	/**
	 * 获取某个关键词的联想词
	 * 
	 * @param q
	 *            关键词，必填
	 * @return
	 * @throws XimalayaException
	 */
	public SuggestWordList searchSuggestWords(String keyWord) throws XimalayaException {
		checkSearchKeyWordParam(keyWord);
		return new SuggestWordList(CLIENT.get(String.format("%s/search/suggest_words", XimalayaConfig.getBaseUrl()),
				assembleHttpParams(new HttpParameter[] { new HttpParameter("q", keyWord) })));
	}

	/**
	 * 按照关键词搜索直播。
	 * 
	 * @param q
	 * @param pageSize
	 * @param page
	 * @return
	 * @throws XimalayaException
	 */
	public RadioList searchRadios(String q, Paging paging) throws XimalayaException {
		paging = paging == null ? new Paging() : paging;
		HttpResponse response = CLIENT
				.get(String.format("%s/search/radios", XimalayaConfig.getBaseUrl()),
						assembleHttpParams(new HttpParameter[] { new HttpParameter("q", q),
								new HttpParameter("count", paging.getCount()),
								new HttpParameter("page", paging.getPage()) }));
		return Radio.constructRadioList(response);
	}

	/**
	 * 搜索主播
	 * 
	 * @param q
	 * @param calcDimension(排序条件：4-最相关（默认），5-粉丝最多，6-声音最多)
	 * @param paging
	 * @return
	 * @throws XimalayaException
	 */
	public AnnouncerList searchAnnouncerList(String q, Integer calcDimension, Paging paging) throws XimalayaException {
		paging = paging == null ? new Paging() : paging;
		HttpResponse response = CLIENT.get(String.format("%s/search/announcers", XimalayaConfig.getBaseUrl()),
				assembleHttpParams(new HttpParameter[] { new HttpParameter("q", q),
						new HttpParameter("calc_dimension", calcDimension),
						new HttpParameter("count", paging.getCount()), new HttpParameter("page", paging.getPage()) }));
		return Announcer.constructAnnouncerList(response);
	}

	/**
	 * 获取指定数量直播，声音，专辑的内容。
	 * 
	 * @param q
	 * @param pageSize
	 * @param page
	 * @return
	 * @throws XimalayaException
	 */
	public AllList searchAll(String q, Paging paging) throws XimalayaException {
		paging = paging == null ? new Paging() : paging;
		HttpResponse response = CLIENT
				.get(String.format("%s/search/all", XimalayaConfig.getBaseUrl()),
						assembleHttpParams(new HttpParameter[] { new HttpParameter("q", q),
								new HttpParameter("count", paging.getCount()),
								new HttpParameter("page", paging.getPage()) }));
		return new AllList(response);
	}

	private void checkSearchKeyWordParam(String keyWord) {
		if (keyWord == null || keyWord.isEmpty()) {
			throw new IllegalArgumentException("keyWord should not empty");
		}
	}

	private void checkSearchTopParam(int top) {
		if (top < 1 || top > 20) {
			throw new IllegalArgumentException("top should >= 1 and <= 20");
		}
	}

	private void checkSearchParam(String q, long categoryID) {
		if (q == null || q.isEmpty()) {
			throw new IllegalArgumentException("q should not empty");
		}
		if (categoryID < 0) {
			throw new IllegalArgumentException("category_id should >= 0");
		}
	}

	private void checkSearchQ(String q) {
		if (q == null || q.isEmpty()) {
			throw new IllegalArgumentException("q should not empty");
		}
	}

	private HttpParameter[] constructSpecificParamsForSearch(String q, Paging paging) {
		HttpParameter[] specificParams = new HttpParameter[3];
		specificParams[0] = new HttpParameter("q", q);
		specificParams[1] = new HttpParameter("page", paging.getPage());
		specificParams[2] = new HttpParameter("count", paging.getCount());
		return specificParams;
	}

	private HttpParameter[] constructSpecificParamsForSearch(String q, long categoryID, int calcDimension,
			Paging paging) {
		HttpParameter[] specificParams = new HttpParameter[5];
		specificParams[0] = new HttpParameter("q", q);
		specificParams[1] = new HttpParameter("category_id", categoryID);
		specificParams[2] = new HttpParameter("calc_dimension", calcDimension);
		specificParams[3] = new HttpParameter("page", paging.getPage());
		specificParams[4] = new HttpParameter("count", paging.getCount());
		return specificParams;
	}
}
