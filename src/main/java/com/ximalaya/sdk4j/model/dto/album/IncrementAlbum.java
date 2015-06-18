package com.ximalaya.sdk4j.model.dto.album;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;

/**
 * 增量专辑DTO模型
 * @author william
 *
 */
public class IncrementAlbum extends Album {
	private static final long serialVersionUID = -697459276083288173L;

	private boolean isOnline;   // 上线/下线
	
	public IncrementAlbum(HttpResponse response) throws XimalayaException {
		super(response);
		init(response.asJSONObject());
	}
	
	public IncrementAlbum(JSONObject json) throws XimalayaException {
		super(json);
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException{
		if(json != null) {
			try {
				isOnline = json.getBoolean("is_online");
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	public static IncrementAlbumList constructIncrementAlbumList(HttpResponse response) throws XimalayaException {
		IncrementAlbumList albumList = new IncrementAlbumList();
		JSONObject albumListJsonObject = response.asJSONObject();
 		try {
 			int totalCount = albumListJsonObject.getInt("total_count");
 			if(totalCount > 0) {
 				albumList.setTotalPage(albumListJsonObject.getInt("total_page"));
 	 			albumList.setTotalCount(totalCount);
 	 			try{
 	 				albumList.setCategoryID(albumListJsonObject.getLong("category_id"));
 	 			} catch(JSONException jsone) {
 	 			}
 	 			try{
 	 				albumList.setCategoryName(albumListJsonObject.getString("category_name"));
 	 			} catch(JSONException jsone) {
 	 			}
 	 			try{
 	 				albumList.setTagName(albumListJsonObject.getString("tag_name"));
 	 			} catch(JSONException jsone) {
 	 			}
 	 			List<IncrementAlbum> albums = new ArrayList<IncrementAlbum> ();
 	 			JSONArray albumsJsonArray = albumListJsonObject.getJSONArray("albums");
 	 			int size = albumsJsonArray.length();
 	 			for(int i = 0; i < size; i++) {
 	 				albums.add(new IncrementAlbum(albumsJsonArray.getJSONObject(i)));
 	 			}
 	 			albumList.setAlbums(albums);
 			}
		} catch(JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return albumList;
	}
	
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
}
