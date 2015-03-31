package com.ximalaya.sdk4j;

import com.ximalaya.sdk4j.model.HttpParameter;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.Album;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;

public class Albums extends Ximalaya {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8651526987345601726L;
	
	/**
	 * 根据分类和标签获取专辑（带分页）
	 * 
	 * @param categoryID 必填，分类ID
	 * @param tagName    可选，标签名
	 * @param paging     可选（不填则为默认值），分页参数
	 * @return
	 * @throws XimalayaException 
	 */
	public AlbumList getAlbumList(long categoryID, String tagName, Paging paging) throws XimalayaException {
		return Album.constructAlbumList(
				CLIENT.get(String.format("%s/albums/list", BASE_URL), 
							assembleHttpParams(assembleSpecificParams(new Object[] { categoryID, tagName, paging }))));
	}
	
	@Override
	public HttpParameter[] assembleSpecificParams(Object[] rawParams) {
		HttpParameter[] specificParams = null;
		long categoryID = (Long) rawParams[0];
		String tagName = rawParams[1] == null ? null : String.valueOf(rawParams);
		Paging paging = (Paging) rawParams[2];
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
		return specificParams;
	}

}
