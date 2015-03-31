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

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 调用喜马拉雅OpenAPI出错时的异常类
 * @author will
 */
public class XimalayaException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3790211061675143505L;
	
	private int statusCode = -1;   // HTTP状态码
	private int errorNo;           // 错误码
    private String errorCode;      // 错误编号
    private String errorDesc;      // 错误描述
    private String service;        // 调用出错的服务，用于提交给喜马拉雅开放平台开发人员来诊断错误
    
    public XimalayaException(String msg) {
        super(msg);
    }
    
    public XimalayaException(Exception cause) {
        super(cause);
    }
    
    public XimalayaException(String msg , int statusCode) throws JSONException {
    	super(msg);
    	this.statusCode = statusCode;
    }
    
    public XimalayaException(String msg, JSONObject json, int statusCode) throws JSONException {
        super(msg + "\n { error_no: " + json.getInt("error_no") + ", error_code: \"" + json.getString("error_code")
        	+ "\", error_desc: \"" + json.getString("error_desc") + "\", service: " + (json.has("service") ? ("\"" + json.getString("service") + "\"") : null
        	+ "}"));
        this.statusCode = statusCode;
        this.errorNo = json.getInt("error_no");
        this.errorCode = json.getString("error_code");
        this.errorDesc = json.getString("error_desc");
        if(json.has("service")) {
        	this.service = json.getString("service");
        }
    }

    public XimalayaException(String msg, Exception cause) {
        super(msg, cause);
    }

    public XimalayaException(String msg, Exception cause, int statusCode) {
        super(msg, cause);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
    
    public int getErrorNo() {
    	return errorNo;
    }

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}
	
	public String getService() {
		return service;
	}
}
