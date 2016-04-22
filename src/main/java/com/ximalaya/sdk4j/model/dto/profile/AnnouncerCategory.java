package com.ximalaya.sdk4j.model.dto.profile;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;

/**
 * 
 * @author william.zhang
 *
 */
public class AnnouncerCategory extends XimalayaResponse {
	
	private static final long serialVersionUID = -5035432174118964524L;
	
	private Long id;
	private String kind;
	private String vCategoryName;
	private Integer orderNum;
	
	public AnnouncerCategory() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getvCategoryName() {
		return vCategoryName;
	}
	public void setvCategoryName(String vCategoryName) {
		this.vCategoryName = vCategoryName;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	public AnnouncerCategory(JSONObject json) throws XimalayaException {
		super();
		init(json);
	}
	
	public AnnouncerCategory(HttpResponse response) throws XimalayaException {
		super(response);
		init(response.asJSONObject());
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			id = json.getLong("id");
			kind = json.getString("kind");
			vCategoryName = json.getString("vcategory_name");
			orderNum = json.getInteger("order_num");
		}
	}

	public static List<AnnouncerCategory> constructAnnouncerCategories(
			HttpResponse response) throws XimalayaException {
		List<AnnouncerCategory> albums = new ArrayList<AnnouncerCategory> ();
		JSONArray albumsJsonArray = response.asJSONArray();
		try {
			if(albumsJsonArray != null) {
				for(int i = 0; i < albumsJsonArray.size(); i++) {
					albums.add(new AnnouncerCategory(albumsJsonArray.getJSONObject(i)));
				}
			}
		} catch (JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return albums;
	}
	
}