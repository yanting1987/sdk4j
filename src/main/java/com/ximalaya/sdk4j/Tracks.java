package com.ximalaya.sdk4j;

import java.util.ArrayList;
import java.util.List;





import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.Sort;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.RelativeAlbum;
import com.ximalaya.sdk4j.model.dto.album.RelativeAlbumList;
import com.ximalaya.sdk4j.model.dto.track.Track;
import com.ximalaya.sdk4j.model.dto.track.TrackList;
import com.ximalaya.sdk4j.util.StringUtil;
import com.ximalaya.sdk4j.util.XimalayaConfig;

/**
 * 声音相关接口
 * @author will
 *
 */
public class Tracks extends Ximalaya {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6472908914256459025L;
	
	private static final List<Track> EMPTY_TRACKS = new ArrayList<Track> (0);
	
	/**
	 * 根据分类和标签获取热门声音（带分页）
	 * 
	 * @param categoryID 分类ID，必填，如果为0则表示所有分类下热门声音
	 * @param tagName    标签名，可选
	 * @param paging     分页参数，可选，如果为null则为默认分页参数
	 * @return
	 * @throws XimalayaException 
	 */
	public TrackList getHotTrackList(long categoryID, String tagName, Paging paging) throws XimalayaException {
		checkCategoryID(categoryID);
		paging = paging == null ? new Paging(): paging;
		
		HttpParameter[] specificParams = null;
		if(tagName != null && !tagName.isEmpty()) {
			specificParams = new HttpParameter[4];
			specificParams[0] = new HttpParameter("category_id", categoryID);
			specificParams[1] = new HttpParameter("tag_name", tagName);
			specificParams[2] = new HttpParameter("page", paging.getPage());
			specificParams[3] = new HttpParameter("count", paging.getCount());
		}
		else {
			specificParams = new HttpParameter[3];
			specificParams[0] = new HttpParameter("category_id", categoryID);
			specificParams[1] = new HttpParameter("page", paging.getPage());
			specificParams[2] = new HttpParameter("count", paging.getCount());
		}
		return Track.constructTrackList(
				CLIENT.get(String.format("%s/tracks/hot", XimalayaConfig.getBaseUrl()),
						   assembleHttpParams(specificParams)));
	}
	
	/**
	 * 根据上一次所听声音的id，搜索给定数量的声音。
	 * @param albumId 必填	专辑ID
	 * @param trackId 必填	声音ID
	 * @param count   选填	需要数据的条数，默认20条，最大100条
	 * @param sort    选填	asc（正序），或desc（倒序）；默认asc
	 * @return
	 * @throws XimalayaException
	 */
	public TrackList getLastPlayTracks(long albumId, long trackId, int count, Sort sort) throws XimalayaException{
		sort = sort == null ? Sort.ASC : sort;
		HttpParameter[] specificParams = new HttpParameter[4];
			specificParams[0] = new HttpParameter("album_id", albumId);
			specificParams[1] = new HttpParameter("track_id", trackId);
			specificParams[2] = new HttpParameter("count", count);
			specificParams[3] = new HttpParameter("sort", Sort.getSortText(sort));
		return Track.constructTrackList(
				CLIENT.get(String.format("%s/tracks/get_last_play_tracks", XimalayaConfig.getBaseUrl()),
							assembleHttpParams(specificParams)));
	}

	/**
	 * 获取某个专辑的相关推荐专辑
	 * @param id 声音ID
	 * @return
	 * @throws XimalayaException
	 */
	public RelativeAlbumList getRelativeAlbums(Long id) throws XimalayaException {
		if (id == null || id <= 0) {
			return new RelativeAlbumList();
		}
		HttpParameter[] specificParams = new HttpParameter[]{new HttpParameter("trackId", id)};
		HttpResponse response = CLIENT.get(String.format("%s/tracks/relative_album", XimalayaConfig.getBaseUrl()),
				assembleHttpParams(specificParams));
		return RelativeAlbum.constructReletiveAlbumList(response);
	}

	/**
	 * 根据一组声音ID批量获取声音
	 * 
	 * @param trackIDs 一组声音ID，必填
	 * @return
	 * @throws XimalayaException
	 */
	public List<Track> batchGetTracks(long[] trackIDs) throws XimalayaException {
		if(trackIDs == null || trackIDs.length == 0) {
			return EMPTY_TRACKS; 
		}
		
		HttpParameter[] specificParams = new HttpParameter[] { new HttpParameter("ids", StringUtil.join(trackIDs, ",")) };
		return Track.constructTracks(
				CLIENT.get(String.format("%s/tracks/get_batch", XimalayaConfig.getBaseUrl()),
						   assembleHttpParams(specificParams)));
	}
	
	private void checkCategoryID(long categoryID) {
		if(categoryID < 0) {
			throw new IllegalArgumentException("categoryID should >= 0");
		}
	}

}
