package com.ximalaya.sdk4j;

import java.util.List;

import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.model.DTOValidateUtil;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.category.Category;
import com.ximalaya.sdk4j.model.dto.track.Track;
import com.ximalaya.sdk4j.model.dto.track.TrackList;

/**
 * 
 * @author william.zhang
 *
 */
public class Customs extends Ximalaya {
	private static final long serialVersionUID = 4492229572627266854L;

	
	/**
	 * 获取喜马拉雅提供的由合作方自定义图标的内容分类。
	 * 
	 * @return
	 * @throws XimalayaException
	 */
	public List<Category> getCategories(int iconSetId) throws XimalayaException {
		DTOValidateUtil.validateIconSetID(iconSetId);
		HttpParameter[] specificParams = new HttpParameter[1];
        specificParams[0] = new HttpParameter("icon_set_id", iconSetId);
		return Category.constructCategories(
				CLIENT.get(String.format("%s/customized/categories", BASE_URL), assembleHttpParams(specificParams)));
	}
	
	/**
	 * 获取合作方定制化的声音列表。
	 * @param tracklistId
	 * @param paging
	 * @return
	 * @throws XimalayaException
	 */
	public TrackList getTrackList(int tracklistId, Paging paging) throws XimalayaException {
		DTOValidateUtil.validateTracklistID(tracklistId);
		paging = paging == null ? new Paging(): paging;
		
		HttpParameter[] specificParams = new HttpParameter[3];
		specificParams[0] = new HttpParameter("customized_tracklist_id", tracklistId);
		specificParams[1] = new HttpParameter("page", paging.getPage());
		specificParams[2] = new HttpParameter("count", paging.getCount());
		return Track.constructTrackList(
				CLIENT.get(String.format("%s/customized/tracks", BASE_URL),
						   assembleHttpParams(specificParams)));
	}
}
