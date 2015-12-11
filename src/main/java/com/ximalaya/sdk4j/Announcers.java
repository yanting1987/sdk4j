package com.ximalaya.sdk4j;

import java.util.List;

import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.model.DTOValidateUtil;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.profile.Announcer;
import com.ximalaya.sdk4j.model.dto.profile.AnnouncerCategory;
import com.ximalaya.sdk4j.model.dto.profile.AnnouncerList;

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
				CLIENT.get(String.format("%s/announcers/categories", BASE_URL), assembleHttpParams()));
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
				BASE_URL), assembleHttpParams(specificParams)));
	}
	
}
