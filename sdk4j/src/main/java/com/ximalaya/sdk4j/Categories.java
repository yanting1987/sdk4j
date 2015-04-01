package com.ximalaya.sdk4j;

import java.util.List;

import com.ximalaya.sdk4j.model.XimalayaException;
import com.ximalaya.sdk4j.model.dto.category.Category;


public class Categories extends Ximalaya {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5338362069555289938L;
	
	/**
	 * 获取喜马拉雅分类
	 * 
	 * @return
	 * @throws XimalayaException
	 */
	public List<Category> getCategories() throws XimalayaException {
		return Category.constructCategories(
				CLIENT.get(String.format("%s/categories/list", BASE_URL),
						    assembleHttpParams(DEFAULT_SPECIFIC_PARAMS)));
	}

}
