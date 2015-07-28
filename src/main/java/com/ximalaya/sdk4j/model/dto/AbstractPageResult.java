package com.ximalaya.sdk4j.model.dto;

public abstract class AbstractPageResult {
	
	protected Integer totalPage;    // 总页数
	protected Integer totalCount;   // 声音总数
	protected Integer currentPage;  // 当前页
	
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
}
