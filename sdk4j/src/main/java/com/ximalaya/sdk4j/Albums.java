package com.ximalaya.sdk4j;

import com.ximalaya.sdk4j.model.dto.album.AlbumList;

public class Albums extends Ximalaya {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8651526987345601726L;
	
	/**
	 * 根据分类和标签获取专辑（带分页）
	 * 
	 * @param categoryID   分类ID
	 * @param tagName      标签名
	 * @param page         当前第几页，默认为1，必须大于或等于1
	 * @param count        每页都少条，默认为20，取值范围为[1, 100]
	 * @return
	 */
	public AlbumList getAlbumList(long categoryID, String tagName, int page, int count) {
//		String listAlbumUrl = String.format("%s/albums/list", args) TODO
/*		return Album.constructAlbumList(
				client.get(baseURL + ""));*/
		return null;
	}
	
	/*
	 * 
	 * 根据用户ID获取用户信息
	 * 
	 * @param uid
	 *            需要查询的用户ID
	 * @return User
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/users/show
	 * @since JDK 1.5
	 public User showUserById(String uid) throws WeiboException {
		return new User(
				client.get(WeiboConfig.getValue("baseURL") + "users/show.json",
						   new PostParameter[] { new PostParameter("uid", uid) },
				           access_token)
				      .asJSONObject());
	}*/

}
