package com.ximalaya.sdk4j;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.column.Column;
import com.ximalaya.sdk4j.model.dto.column.ColumnList;

public class ColumsTest {

	Columns columnService = new Columns();
	
	@Test
	public void testGetQualityColumnList() throws XimalayaException {
		ColumnList columns = columnService.getQualityColumnList(new Paging());
		Assert.assertTrue(columns != null && columns.getColumns() != null && columns.getColumns().size() > 0);
	}
	
	@Test
	public void testGetRankAlbums() throws XimalayaException {
		Column Column = columnService.getColumnDetail(361);
		Assert.assertTrue(Column != null && Column.getColumnItems() != null && Column.getColumnItems().size() > 0);
	}
}
