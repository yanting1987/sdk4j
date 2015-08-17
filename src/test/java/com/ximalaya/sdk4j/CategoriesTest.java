package com.ximalaya.sdk4j;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.category.Category;
import com.ximalaya.sdk4j.model.dto.category.RecommendCategory;

public class CategoriesTest {

	Categories categoriesService = new Categories();
	
	@Test
	public void testGetCategories() throws XimalayaException {
		List<Category> categories = categoriesService.getCategories();
		Assert.assertTrue(categories != null && !categories.isEmpty());
	}
	
	@Test
	public void testGetRecommendCategories() throws XimalayaException {
		List<RecommendCategory> categories = categoriesService.getRecommendCategories();
		Assert.assertTrue(categories != null && !categories.isEmpty());
	}
}
