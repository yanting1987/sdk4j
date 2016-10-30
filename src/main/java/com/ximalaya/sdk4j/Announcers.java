package com.ximalaya.sdk4j;

import java.util.ArrayList;
import java.util.List;

import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.DTOValidateUtil;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.Album;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;
import com.ximalaya.sdk4j.model.dto.profile.Announcer;
import com.ximalaya.sdk4j.model.dto.profile.AnnouncerCategory;
import com.ximalaya.sdk4j.model.dto.profile.AnnouncerList;
import com.ximalaya.sdk4j.util.StringUtil;
import com.ximalaya.sdk4j.util.XimalayaConfig;

/**
 * 喜马拉雅内容分类
 * @author william
 *
 */
public class Announcers extends Ximalaya {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5338362069555289938L;
	
	/**
	 * 获取喜马拉雅主播分类
	 * 
	 * @return
	 * @throws XimalayaException
	 */
	public List<AnnouncerCategory> getAnnouncerCategories() throws XimalayaException {
		return AnnouncerCategory.constructAnnouncerCategories(
				CLIENT.get(String.format("%s/announcers/categories", XimalayaConfig.getBaseUrl()), assembleHttpParams()));
	}

	/**
	 * 获取某个分类下的主播列表
	 * @param vCategoryId	必填		主播分类ID
	 * @param calcDimension 选填		返回的主播列表排序规则，取值为 1 （热度 ）、2 （新晋主播）、3（最多粉丝）
	 * @return
	 * @throws XimalayaException
	 */
	public AnnouncerList getAnnouncerList(int vCategoryId, int calcDimension, Paging paging)
			throws XimalayaException {
		DTOValidateUtil.validateCategoryID(vCategoryId);
		DTOValidateUtil.validateCalcDimension(calcDimension);
		paging = paging == null ? new Paging() : paging;
        HttpParameter[] specificParams = new HttpParameter[4];
        specificParams[0] = new HttpParameter("vcategory_id", vCategoryId);
        specificParams[1] = new HttpParameter("calc_dimension", calcDimension);
        specificParams[2] = new HttpParameter("page", paging.getPage());
        specificParams[3] = new HttpParameter("count", paging.getCount());
		return  Announcer.constructAnnouncerList(CLIENT.get(String.format("%s/announcers/list",
				XimalayaConfig.getBaseUrl()), assembleHttpParams(specificParams)));
	}
	
	
	/**
	 * 	根据一批主播ID批量获取主播信息
	 * @param ids 		主播用户ID列表
	 * @return
	 * @throws XimalayaException
	 */
	public List<Announcer> batchGetAnnouncers(long[] ids)
			throws XimalayaException {
		if (ids == null || ids.length == 0) {
            return new ArrayList<Announcer>(0);
        }
        HttpParameter[] specificParams = new HttpParameter[]{new HttpParameter("ids", StringUtil.join(ids, ","))};
		return Announcer.constructAnnouncers(CLIENT.get(String.format("%s/announcers/get_batch",
				XimalayaConfig.getBaseUrl()), assembleHttpParams(specificParams)));
	}
	
	/**
     * 获取某个主播下的专辑列表
     * @param aid		是	主播用户ID
     * @param paging	否	返回第几页，必须大于等于1，不填默认为1否；每页多少条，默认20，最多不超过100
     * @return
     * @throws XimalayaException
     */
    public AlbumList getAnnouncerAlbums(int aid, Paging paging) throws XimalayaException {
    	DTOValidateUtil.validateAnnouncerId(aid);
    	paging = paging == null ? new Paging() : paging;
    	HttpParameter[] specificParams = new HttpParameter[3];
        specificParams[0] = new HttpParameter("aid", aid);
        specificParams[1] = new HttpParameter("page", paging.getPage());
        specificParams[2] = new HttpParameter("count", paging.getCount());
        HttpResponse response = CLIENT.get(String.format("%s/announcers/albums", XimalayaConfig.getBaseUrl()),
                assembleHttpParams(specificParams));
        return Album.constructAlbumList(response);
    }
	
}
