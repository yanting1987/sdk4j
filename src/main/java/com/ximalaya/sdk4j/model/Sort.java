package com.ximalaya.sdk4j.model;

import com.ximalaya.sdk4j.util.StringUtil;


/**
 * 
 * @author william.zhang
 *
 */
public enum Sort {
	
	ASC, DESC;
	
	public static Sort getSort(String sortStr) {
		if(StringUtil.isEmpty(sortStr)) {
			return null;
		}
		
		String sortVal = sortStr.toLowerCase();
		Sort result = null;
		if(sortVal.equals("asc")) {
			result = Sort.ASC;
		}
		else if(sortVal.equals("desc")) {
			result = Sort.DESC;
		}
		return result;
	}
	
	public static String getSortText(Sort sort) {
		String result = "asc";
		if(sort == null) {
			return result;
		}
		if(sort == Sort.DESC) {
			result = "desc";
		}
		return result;
	}
}
