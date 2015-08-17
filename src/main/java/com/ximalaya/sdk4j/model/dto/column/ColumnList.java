package com.ximalaya.sdk4j.model.dto.column;

import java.util.List;

import com.ximalaya.sdk4j.model.dto.AbstractPageResult;

public class ColumnList extends AbstractPageResult {

	private String columnTitle;		// 标题
	private List<Column> columns;	// 听单列表
	
	public ColumnList() {
	}

	public String getColumnTitle() {
		return columnTitle;
	}
	public void setColumnTitle(String columnTitle) {
		this.columnTitle = columnTitle;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
}
