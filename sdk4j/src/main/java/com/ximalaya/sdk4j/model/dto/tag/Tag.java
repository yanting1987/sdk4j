package com.ximalaya.sdk4j.model.dto.tag;

import java.io.Serializable;

import com.ximalaya.sdk4j.model.DTOKind;
import com.ximalaya.sdk4j.model.dto.IKindAware;

/**
 * 标签DTO
 * 
 * @author will
 *
 */
public class Tag implements IKindAware, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3639856295998431047L;
	
	private Long id;          // ID
	private String tagName;          // 标签名
	private Long updatedAt;   // 更新时间
	private Long createdAt;   // 更新时间
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
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
	
	@Override
	public String getKind() {
		return DTOKind.TAG_KIND;
	}
	
}
