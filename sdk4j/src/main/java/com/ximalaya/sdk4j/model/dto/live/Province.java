package com.ximalaya.sdk4j.model.dto.live;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.XimalayaResponse;
import com.ximalaya.sdk4j.model.dto.DTOKind;
import com.ximalaya.sdk4j.model.dto.IKindAware;

/**
 * 直播省市DTO模型
 * 
 * @author will
 *
 */
public class Province extends XimalayaResponse implements IKindAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7557254279857972145L;
	
	private Long id;                // 省市ID
	private String provinceCode;    // 省市代码，比如"110000"
	private String provinceName;    // 省市名称
	private Integer provinceType;   // 省市类型，0-普通省份，1-直辖市，2-自治区，3-特别行政区
	private Long createdAt;         // 更新时间
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public Integer getProvinceType() {
		return provinceType;
	}
	public void setProvinceType(Integer provinceType) {
		this.provinceType = provinceType;
	}
	public Long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String getKind() {
		return DTOKind.PROVINCE_KIND;
	}
	
	public Province(HttpResponse response) throws XimalayaException {
		super(response);
		init(response.asJSONObject());
	}
	
	public Province(JSONObject json) throws XimalayaException {
		super();
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				id = json.getLong("id");
				provinceCode = json.getString("province_code");
				provinceName = json.getString("province_name");
				provinceType = json.getInt("province_type");
				createdAt = json.getLong("created_at");
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	public static List<Province> constructProvinces(HttpResponse response) throws XimalayaException {
		List<Province> provinces = new ArrayList<Province> ();
		JSONArray provincesJsonArray = response.asJSONArray();
		try {
			int size = provincesJsonArray.length();
			for(int i = 0; i < size; i++) {
				provinces.add(new Province(provincesJsonArray.getJSONObject(i)));
			}
		} catch(JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return provinces;
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
		
		Province other = (Province) obj;
		if((id == null && other.id != null) 
			|| !id.equals(other.id)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Province {id: ");
		strBuilder.append(id);
		strBuilder.append(", provinceCode: \"");
		strBuilder.append(provinceCode);
		strBuilder.append("\", provinceName: \"");
		strBuilder.append(provinceName);
		strBuilder.append("\", provinceType: ");
		strBuilder.append(provinceType);
		strBuilder.append(", createdAt: ");
		strBuilder.append(createdAt);
		strBuilder.append("}");
		return strBuilder.toString();
	}
}