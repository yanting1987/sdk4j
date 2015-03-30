package com.ximalaya.sdk4j.util;

import java.util.Iterator;
import java.util.Map;

import com.ximalaya.sdk4j.model.HttpParameter;

public class ArrayUtils {

	public static HttpParameter[] mapToArray(Map<String, String> map) {
		HttpParameter[] parList = new HttpParameter[map.size()];
		Iterator<String> iter = map.keySet().iterator();
		int i = 0;
		while (iter.hasNext()) {
			String key = iter.next();
			String value = map.get(key);
			parList[i++] = new HttpParameter(key, value);
		}
		return parList;
	}
	
}
