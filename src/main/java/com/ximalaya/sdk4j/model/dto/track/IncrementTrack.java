package com.ximalaya.sdk4j.model.dto.track;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;

/**
 * 增量声音DTO
 * @author william
 *
 */
public class IncrementTrack extends Track {
	private static final long serialVersionUID = -8390101848254471252L;

	private boolean isOnline;   // 上线/下线
	
	public IncrementTrack(JSONObject json) throws XimalayaException {
		super(json);
		init(json);
	}
	
	public IncrementTrack(HttpResponse response) throws XimalayaException {
		super(response);
		init(response.asJSONObject());
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
	
	public static IncrementTrackList constructIncrementTracks(HttpResponse response) throws XimalayaException {
		IncrementTrackList incrementTracks = new IncrementTrackList();
		JSONObject incrementTracksJsonObject = response.asJSONObject();
		try {
			int totalCount = incrementTracksJsonObject.getInt("total_count");
			if(totalCount > 0) {
				
				incrementTracks.setCategoryID(incrementTracksJsonObject.getLong("category_id"));
				incrementTracks.setCategoryName(incrementTracksJsonObject.getString("category_name"));
				incrementTracks.setTagName(incrementTracksJsonObject.getString("tag_name"));
				
				incrementTracks.setTotalCount(totalCount);
				incrementTracks.setTotalPage(incrementTracksJsonObject.getInt("total_page"));
				
				List<IncrementTrack> tracks = new ArrayList<IncrementTrack> ();
				JSONArray tracksJsonArray = incrementTracksJsonObject.getJSONArray("tracks");
				int size = tracksJsonArray.length();
				for(int i = 0; i < size; i++) {
					tracks.add(new IncrementTrack(tracksJsonArray.getJSONObject(i)));
				}
				incrementTracks.setTracks(tracks);
			}
		} catch(JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return incrementTracks;
	}
	
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
}
