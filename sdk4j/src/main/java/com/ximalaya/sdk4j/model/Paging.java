/*
Copyright (c) 2007-2009, Yusuke Yamamoto
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of the Yusuke Yamamoto nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY Yusuke Yamamoto ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL Yusuke Yamamoto BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package com.ximalaya.sdk4j.model;

/**
 * 分页参数
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public class Paging implements java.io.Serializable {
	private static final long serialVersionUID = -3285857427993796670L;
	
	/*
	 * 分页参数配置
	 */
	public static final int MIN_COUNT = 1;
	public static final int MAX_COUNT = 100;
	public static final int MIN_PAGE = 1;
	public static final int DEFAULT_COUNT = 20;
	public static final int DEFAULT_PAGE = 1;
	
	private static final String SET_COUNT_ERROR_MSG = String.format("count should >= %d and <= %d", MIN_COUNT, MAX_COUNT);
	private static final String SET_PAGE_ERROR_MSG = String.format("page should >= %d", MIN_PAGE);
	
	private int count = DEFAULT_COUNT;   // 每页数目，默认为20，最多返回100条
	private int page = DEFAULT_PAGE;     // 查询第几页，默认为1
   
    public Paging() {
    }

    public Paging(int page) {
        setPage(page);
    }

    public Paging(int page, int count) {
        this(page);
        setCount(count);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if (page < MIN_PAGE) {
            throw new IllegalArgumentException(SET_PAGE_ERROR_MSG);
        }
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count < MIN_COUNT || count > MAX_COUNT) {
            throw new IllegalArgumentException(SET_COUNT_ERROR_MSG);
        }
        this.count = count;
    }

    public Paging count(int count) {
        setCount(count);
        return this;
    }
    
}
