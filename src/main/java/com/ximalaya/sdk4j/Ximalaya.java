package com.ximalaya.sdk4j;

import java.io.Serializable;

import com.ximalaya.sdk4j.http.HttpClient;
import com.ximalaya.sdk4j.http.HttpParameter;
import com.ximalaya.sdk4j.util.CrypterUtil;
import com.ximalaya.sdk4j.util.SignatureUtil;
import com.ximalaya.sdk4j.util.XimalayaConfig;

public abstract class Ximalaya implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2462822863708818946L;
	
	protected static final HttpClient CLIENT = new HttpClient();
	protected static final HttpParameter[] DEFAULT_SPECIFIC_PARAMS = new HttpParameter[0];
	
	private static final int SERVER_CLIENT_OS_TYPE = 4;   // 服务端client_os_type参数固定为4
	
	/**
	 * 组装HTTP请求参数，不带特殊业务参数
	 * @return
	 */
	protected final HttpParameter[] assembleHttpParams() {
		return assembleHttpParams(DEFAULT_SPECIFIC_PARAMS);
	}
	
	/**
	 * 组装HTTP请求参数
	 * @param specificParams 每个接口除去通用参数以外的特殊业务参数
	 * @return
	 */
	protected final HttpParameter[] assembleHttpParams(HttpParameter[] specificParams) {
		HttpParameter[] resultParams = null;
		HttpParameter[] commonParams = assembleCommonParams();
		resultParams = new HttpParameter[commonParams.length + specificParams.length + 1];
		if(specificParams.length > 0) {
			System.arraycopy(commonParams, 0, resultParams, 0, commonParams.length);
			System.arraycopy(specificParams, 0, resultParams, commonParams.length, specificParams.length);
		}
		else {
			System.arraycopy(commonParams, 0, resultParams, 0, commonParams.length);
		}
		
		/*
		 * 计算签名参数 
		 */
		String seed = XimalayaConfig.getAppSecret() + XimalayaConfig.getServerAuthenticateStaticKey();
		String sig = SignatureUtil.caculateSignature(resultParams, seed);
		resultParams[resultParams.length - 1] = new HttpParameter("sig", sig);
		
		return resultParams;
	}
	
	/**
	 * 组装通用HTTP请求参数
	 * 
	 * @return
	 */
	private final HttpParameter[] assembleCommonParams() {
		HttpParameter[] commonParams = new HttpParameter[4];
		commonParams[0] = new HttpParameter("app_key", XimalayaConfig.getAppKey());
		commonParams[1] = new HttpParameter("client_os_type", SERVER_CLIENT_OS_TYPE);
		commonParams[2] = new HttpParameter("nonce", CrypterUtil.getRandKey());  // nonce是一个随机字符串
		commonParams[3] = new HttpParameter("timestamp", System.currentTimeMillis());
		return commonParams;
	}
	
}
