package com.ximalaya.sdk4j.util;

public class StringUtil {
	
	/**
	 * 分隔long数组里的各个元素，比如array为[1,2,3]，seperator为英文逗号，那么得到"1,2,3"
	 * @param array
	 * @param seperator
	 * @return
	 */
	public static String join(long[] array, String seperator) {
		if(array == null || array.length == 0 || seperator == null || seperator.isEmpty()) {
			throw new IllegalArgumentException("array should not empty, seperator should be specified");
		}
		
		StringBuilder strBuilder = new StringBuilder();
		for(long i: array) {
			strBuilder.append(i);
			strBuilder.append(seperator);
		}
		strBuilder.deleteCharAt(strBuilder.lastIndexOf(seperator));
		return strBuilder.toString();
	}

}
