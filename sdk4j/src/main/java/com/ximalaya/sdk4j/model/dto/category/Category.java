package com.ximalaya.sdk4j.model.dto.category;

import java.io.Serializable;

import com.ximalaya.sdk4j.model.dto.DTOKind;
import com.ximalaya.sdk4j.model.dto.IKindAware;

/**
 * 分类DTO
 * @author will
 *
 */
public class Category implements IKindAware, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8134137599995673738L;
	
	private Long id;          // ID
	private Long updatedAt;   // 更新时间
	private Long createdAt;   // 更新时间
	private String categoryName;     // 分类名
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String getKind() {
		return DTOKind.CATEGORY_KIND;
	}
	
}
