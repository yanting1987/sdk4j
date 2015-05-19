package com.ximalaya.sdk4j.model.dto.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ximalaya.sdk4j.http.HttpResponse;
import com.ximalaya.sdk4j.model.XimalayaException;

/**
 * 分类DTO
 * @author will
 *
 */
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8134137599995673738L;
	
	private Long id;                 // ID
	private String kind;             // DTO实体类型
	private String categoryName;     // 分类名
	private String coverUrlSmall;    // 封面小图
	private String coverUrlMiddle;   // 封面中图
	private String coverUrlLarge;    // 封面大图
	
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCoverUrlSmall() {
		return coverUrlSmall;
	}
	public void setCoverUrlSmall(String coverUrlSmall) {
		this.coverUrlSmall = coverUrlSmall;
	}
	public String getCoverUrlMiddle() {
		return coverUrlMiddle;
	}
	public void setCoverUrlMiddle(String coverUrlMiddle) {
		this.coverUrlMiddle = coverUrlMiddle;
	}
	public String getCoverUrlLarge() {
		return coverUrlLarge;
	}
	public void setCoverUrlLarge(String coverUrlLarge) {
		this.coverUrlLarge = coverUrlLarge;
	}
	
	public Category(JSONObject json) throws XimalayaException {
		init(json);
	}
	
	private void init(JSONObject json) throws XimalayaException {
		if(json != null) {
			try {
				id = json.getLong("id");
				kind = json.getString("kind");
				categoryName = json.getString("category_name");
				if(json.has("cover_url_small")) {
					coverUrlSmall = json.getString("cover_url_small");
				}
				if(json.has("cover_url_middle")) {
					coverUrlMiddle = json.getString("cover_url_middle");
				}
				if(json.has("cover_url_large")) {
					coverUrlLarge = json.getString("cover_url_large");
				}
			} catch (JSONException jsone) {
				throw new XimalayaException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	public static List<Category> constructCategories(HttpResponse response) throws XimalayaException {
		List<Category> categories = new ArrayList<Category> ();
		JSONArray categoriesJsonArray = response.asJSONArray();
		try {
			int size = categoriesJsonArray.length();
			for(int i = 0; i < size; i++) {
				categories.add(new Category(categoriesJsonArray.getJSONObject(i)));
			}
		} catch (JSONException jsone) {
			throw new XimalayaException(jsone.getMessage() + ":" + jsone.toString(), jsone);
		}
		return categories;
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
		
		Category other = (Category) obj;
		if((id == null && other.id != null) 
			|| !id.equals(other.id)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Category {id: ");
		strBuilder.append(id);
		strBuilder.append(", kind: \"");
		strBuilder.append(kind);
		strBuilder.append("\", categoryName: \"");
		strBuilder.append(categoryName);
		strBuilder.append("\", coverUrlSmall: ");
		strBuilder.append(coverUrlSmall == null ? null : ("\"" + coverUrlSmall + "\""));
		strBuilder.append(", coverUrlMiddle: ");
		strBuilder.append(coverUrlMiddle == null ? null : ("\"" + coverUrlMiddle + "\""));
		strBuilder.append(", coverUrlLarge: ");
		strBuilder.append(coverUrlLarge == null ? null : ("\"" + coverUrlLarge + "\""));
		strBuilder.append("}");
		return strBuilder.toString();
	}
	
}
