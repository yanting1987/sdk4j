package com.ximalaya.sdk4j.model.dto.profile;

import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;
import com.ximalaya.sdk4j.model.dto.IKindAware;

/**
 * 喜马拉雅用户DTO，包括主播和普通用户
 * 
 * @author will
 *
 */
public class User extends XimalayaResponse implements IKindAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3394162338155271567L;
	
	private Long id;           // ID
	private String nickname;   // 用户昵称
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String getKind() {
		return "user";
	}
	
	public User(HttpResponse response) throws XimalayaException {
		super(response);
		init(response.asJSONObject());
	}
	
	public User(JSONObject json) throws XimalayaException {
		super();
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				id = json.getLong("id");
				nickname = json.getString("nickname");
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		User other = (User) obj;
		if((id == null && other.id != null) 
			|| !id.equals(other.id)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("User {id: ");
		strBuilder.append(id);
		strBuilder.append(", nickname: \"");
		strBuilder.append(nickname);
		strBuilder.append("}");
		return strBuilder.toString();
	}

}
