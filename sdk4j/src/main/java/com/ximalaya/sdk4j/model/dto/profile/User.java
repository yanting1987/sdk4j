package com.ximalaya.sdk4j.model.dto.profile;

import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;

/**
 * 喜马拉雅用户DTO，包括主播和普通用户
 * 
 * @author will
 *
 */
public class User extends XimalayaResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3394162338155271567L;
	
	private Long id;           // ID
	private String kind;       // DTO实体类型
	private String nickname;   // 用户昵称
	private String cover;      // 用户头像
	
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
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
				kind = json.getString("kind");
				nickname = json.getString("nickname");
				cover = json.getString("cover");
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
		strBuilder.append(", kind: \"");
		strBuilder.append(kind);
		strBuilder.append("\", nickname: \"");
		strBuilder.append(nickname);
		strBuilder.append("\", cover: \"");
		strBuilder.append(cover);
		strBuilder.append("\"}");
		return strBuilder.toString();
	}

}
