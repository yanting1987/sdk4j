package com.ximalaya.sdk4j.model.dto.live;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;

public class IncrementSchedule extends Schedule {
	private static final long serialVersionUID = 837977151956568920L;
	
	private boolean isOnline;   // 上线/下线(1表示新增或修改，0表示删除)
	
	public IncrementSchedule(JSONObject json) throws XimalayaException {
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
	
	public static List<IncrementSchedule> constructIncrementSchedules(HttpResponse response) throws XimalayaException {
		JSONArray schedulesJsonArray = response.asJSONArray();
		List<IncrementSchedule> schedules = new ArrayList<IncrementSchedule> ();
		try {
			int size = schedulesJsonArray.length();
			for(int i = 0; i < size; i++) {
				schedules.add(new IncrementSchedule(schedulesJsonArray.getJSONObject(i)));
			}
		} catch(JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return schedules;
	}
	
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

}
