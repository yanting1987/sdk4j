package com.ximalaya.sdk4j;

import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.model.DTOValidateUtil;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.Album;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;
import com.ximalaya.sdk4j.model.dto.live.Radio;
import com.ximalaya.sdk4j.model.dto.live.RadioList;
import com.ximalaya.sdk4j.model.dto.rank.Rank;
import com.ximalaya.sdk4j.model.dto.rank.RankList;
import com.ximalaya.sdk4j.model.dto.track.Track;
import com.ximalaya.sdk4j.model.dto.track.TrackList;

public class Ranks extends Ximalaya {
	private static final long serialVersionUID = -8651526987345601726L;

	/**
	 * 根据榜单类型获取榜单首页的榜单列表。
	 * @param rankType
	 * @return
	 * @throws XimalayaException
	 */
	public RankList getFirstPageRanks(int rankType) throws XimalayaException {
		HttpParameter[] specificParams = new HttpParameter[1];
		DTOValidateUtil.validateRankType(rankType);
		specificParams[0] = new HttpParameter("rank_type", rankType);
		return Rank.constructRankList(
			CLIENT.get(String.format("%s/ranks/index_list", BASE_URL), 
					assembleHttpParams(specificParams)));
	}
	
	/**
	 * 根据rank_key获取某个榜单下的专辑列表。	 
	 * @param rank_key
	 * @param page
	 * @param count
	 * @return
	 * @throws XimalayaException
	 */
	public AlbumList getRankAlbums(String rankKey, Paging paging) throws XimalayaException {
		paging = paging == null ? new Paging(): paging;
		DTOValidateUtil.validateRankKey(rankKey);
		HttpParameter[] specificParams = new HttpParameter[3];
		specificParams[0] = new HttpParameter("rank_key", rankKey);
		specificParams[1] = new HttpParameter("page", paging.getPage());
		specificParams[2] = new HttpParameter("count", paging.getCount());
		return Album.constructAlbumList(
			CLIENT.get(String.format("%s/ranks/albums", BASE_URL), 
					assembleHttpParams(specificParams)));
	}
	
	/**
	 * 根据rank_key获取某个榜单下的声音列表。
	 * @param rank_key
	 * @param paging
	 * @return
	 * @throws XimalayaException
	 */
	public TrackList getRankTracks(String rankKey, Paging paging) throws XimalayaException {
		paging = paging == null ? new Paging(): paging;
		DTOValidateUtil.validateRankKey(rankKey);
		HttpParameter[] specificParams = new HttpParameter[3];
		specificParams[0] = new HttpParameter("rank_type", rankKey);
		specificParams[1] = new HttpParameter("page", paging.getPage());
		specificParams[2] = new HttpParameter("count", paging.getCount());
		return Track.constructTrackList(
			CLIENT.get(String.format("%s/ranks/tracks", BASE_URL), 
					assembleHttpParams(specificParams)));
	}
	
	/**
	 * 获取直播电台排行榜。
	 * @param radioCount
	 * @return
	 * @throws XimalayaException
	 */
	public RadioList getRankRadios(int radioCount) throws XimalayaException {
		DTOValidateUtil.validateRadioCount(radioCount);
		HttpParameter[] specificParams = new HttpParameter[1];
		specificParams[0] = new HttpParameter("radio_count", radioCount);
		return Radio.constructRadioList(
			CLIENT.get(String.format("%s/ranks/radios", BASE_URL), 
					assembleHttpParams(specificParams)));
	}
}
