package com.ximalaya.sdk4j;

import java.util.ArrayList;
import java.util.List;

import com.ximalaya.sdk4j.model.HttpParameter;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.album.Album;
import com.ximalaya.sdk4j.model.dto.album.AlbumList;
import com.ximalaya.sdk4j.util.StringUtil;

public class Albums extends Ximalaya {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8651526987345601726L;
	
	private static final List<Album> EMPTY_ALBUMS = new ArrayList<Album> (0);
	
	/**
	 * 根据分类和标签获取热门专辑（带分页）
	 * 
	 * @param categoryID 必填，分类ID
	 * @param tagName    可选，标签名
	 * @param paging     可选（不填则为默认值），分页参数
	 * @return
	 * @throws XimalayaException 
	 */
	public AlbumList getHotAlbumList(long categoryID, String tagName, Paging paging) throws XimalayaException {
		if(categoryID <= 0) {
			throw new IllegalArgumentException("categoryID should > 0");
		}
		
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
		return Album.constructAlbumList(
				CLIENT.get(String.format("%s/albums/list", BASE_URL), 
							assembleHttpParams(specificParams)));
	}
	
	/**
	 * 根据一组ID批量获取专辑
	 * 
	 * @param ids 一组ID
	 * @return
	 * @throws XimalayaException
	 */
	public List<Album> batchGetAlbums(long[] ids) throws XimalayaException {
		if(ids == null || ids.length == 0) {
			return EMPTY_ALBUMS; 
		}
		
		HttpParameter[] specificParams = new HttpParameter[] { new HttpParameter("ids", StringUtil.join(ids, ",")) };
		return Album.constructAlbums(
				CLIENT.get(String.format("%s/albums/get_batch", BASE_URL),
						   assembleHttpParams(specificParams)));
	}

}
