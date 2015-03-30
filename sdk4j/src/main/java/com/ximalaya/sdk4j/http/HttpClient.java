package com.ximalaya.sdk4j.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ximalaya.sdk4j.model.HttpParameter;
import com.ximalaya.sdk4j.model.MySSLSocketFactory;
import com.ximalaya.sdk4j.model.Paging;
import com.ximalaya.sdk4j.model.XimalayaException;

/**
 * @author will
 */
public class HttpClient implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8406097812276555308L;
	
	public static final int HTTP_STATUS_OK = 200;                      // 请求成功
	public static final int HTTP_STATUS_CREATED = 201;                // 创建成功
	public static final int HTTP_STATUS_ACCEPTED = 202;               // 更新成功
	public static final int HTTP_STATUS_PERMANENT_REDIRECT = 301;    // 请求永久重定向
	public static final int HTTP_STATUS_TEMPORAL_REDIRECT = 302;     // 请求临时重定向
	public static final int HTTP_SATUS_NOT_MODIFIED = 304;            // 未更改
	public static final int HTTP_STATUS_BAD_REQUEST = 400;            // 请求的地址不存在或者包含非法或者不支持的参数
	public static final int HTTP_STATUS_UNAUTHORIZED = 401;           // 未授权，因为用户没有进行身份认证
	public static final int HTTP_STATUS_FORBIDDEN = 403;               // 被禁止访问，因为用户被认定为没有访问特定资源的权限
	public static final int HTTP_STATUS_NOT_FOUND = 404;               // 请求的资源不存在
	public static final int HTTP_STATUS_UNPROCESSABLE_ENTITY = 422;   // 服务器理解请求，但其中包含非法参数
	public static final int HTTP_STATUS_TOO_MANY_REQUESTS = 429;      // 请求频率超配
	public static final int HTTP_STATUS_SERVER_ERROR = 500;            // 服务器错误
	public static final int HTTP_STATUS_BAD_GATEWAY = 502;             // 网关错误，服务器宕机或者在升级中
	
	private String proxyHost;
	private int proxyPort;
	private String proxyAuthUser;
	private String proxyAuthPassword;

	public String getProxyHost() {
		return proxyHost;
	}

	/**
	 * Sets proxy host. System property -Dsinat4j.http.proxyHost or
	 * http.proxyHost overrides this attribute.
	 * 
	 * @param proxyHost
	 */
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public int getProxyPort() {
		return proxyPort;
	}

	/**
	 * Sets proxy port. System property -Dsinat4j.http.proxyPort or
	 * -Dhttp.proxyPort overrides this attribute.
	 * 
	 * @param proxyPort
	 */
	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getProxyAuthUser() {
		return proxyAuthUser;
	}

	/**
	 * Sets proxy authentication user. System property -Dsinat4j.http.proxyUser
	 * overrides this attribute.
	 * 
	 * @param proxyAuthUser
	 */
	public void setProxyAuthUser(String proxyAuthUser) {
		this.proxyAuthUser = proxyAuthUser;
	}

	public String getProxyAuthPassword() {
		return proxyAuthPassword;
	}

	/**
	 * Sets proxy authentication password
	 * 
	 * @param proxyAuthPassword
	 */
	public void setProxyAuthPassword(String proxyAuthPassword) {
		this.proxyAuthPassword = proxyAuthPassword;
	}

	private static final Logger LOG = LoggerFactory.getLogger(HttpClient.class);
	private org.apache.commons.httpclient.HttpClient client = null;

	private MultiThreadedHttpConnectionManager connectionManager;

	public HttpClient() {
		this(150, 30000, 30000, 1024 * 1024);
	}

	public HttpClient(int maxConPerHost, int conTimeOutMs, int soTimeOutMs,
			int maxSize) {
		connectionManager = new MultiThreadedHttpConnectionManager();
		HttpConnectionManagerParams params = connectionManager.getParams();
		params.setDefaultMaxConnectionsPerHost(maxConPerHost);
		params.setConnectionTimeout(conTimeOutMs);
		params.setSoTimeout(soTimeOutMs);

		HttpClientParams clientParams = new HttpClientParams();
		// 忽略cookie 避免 Cookie rejected 警告
		clientParams.setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
		client = new org.apache.commons.httpclient.HttpClient(clientParams,
				connectionManager);
		Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
		Protocol.registerProtocol("https", myhttps);
		// 支持proxy
		if (proxyHost != null && !proxyHost.equals("")) {
			client.getHostConfiguration().setProxy(proxyHost, proxyPort);
			client.getParams().setAuthenticationPreemptive(true);
			if (proxyAuthUser != null && !proxyAuthUser.equals("")) {
				client.getState().setProxyCredentials(
						AuthScope.ANY,
						new UsernamePasswordCredentials(proxyAuthUser,
								proxyAuthPassword));
				LOG.debug("Proxy AuthUser: " + proxyAuthUser);
				LOG.debug("Proxy AuthPassword: " + proxyAuthPassword);
			}
		}
	}

	/**
	 * 处理HTTP GET请求
	 * 
	 */
	public HttpResponse get(String url, String token) throws XimalayaException {
		return get(url, new HttpParameter[0], token);
	}
	
	public HttpResponse get(String url, HttpParameter[] params, String token) 
			throws XimalayaException {
		LOG.debug("Request:");
		LOG.debug("GET:" + url);
		if (null != params && params.length > 0) {
			String encodedParams = HttpClient.encodeParameters(params);
			if (-1 == url.indexOf("?")) {
				url += "?" + encodedParams;
			} else {
				url += "&" + encodedParams;
			}
		}
		GetMethod getmethod = new GetMethod(url);
		return httpRequest(getmethod, token);
	}
	
	public HttpResponse get(String url, HttpParameter[] params, Paging paging, String token)
			throws XimalayaException {
		if (null != paging) {
			List<HttpParameter> pagingParams = new ArrayList<HttpParameter>(4);
			if (-1 != paging.getPage()) {
				pagingParams.add(new HttpParameter("page", String
						.valueOf(paging.getPage())));
			}
			if (-1 != paging.getCount()) {
				if (-1 != url.indexOf("search")) {
					// search api takes "rpp"
					pagingParams.add(new HttpParameter("rpp", String
							.valueOf(paging.getCount())));
				} else {
					pagingParams.add(new HttpParameter("count", String
							.valueOf(paging.getCount())));
				}
			}
			
			HttpParameter[] newparams = null;
			HttpParameter[] arrayPagingParams = pagingParams.toArray(new HttpParameter[pagingParams.size()]);
			if (null != params) {
				newparams = new HttpParameter[params.length + pagingParams.size()];
				System.arraycopy(params, 0, newparams, 0, params.length);
				System.arraycopy(arrayPagingParams, 0, newparams, params.length, pagingParams.size());
			} else {
				/*if (0 != arrayPagingParams.length) {
					String encodedParams = HttpClient.encodeParameters(arrayPagingParams);
					if (-1 != url.indexOf("?")) {
						url += "&" + encodedParams;
					} else {
						url += "?" + encodedParams;
					}
				}*/
				newparams = arrayPagingParams;
			}
			return get(url, newparams, token);
		}
		else {
			return get(url, params, token);
		}
	}

	/**
	 * 处理http deletemethod请求
	 */

	public HttpResponse delete(String url, HttpParameter[] params, String token)
			throws XimalayaException {
		if (0 != params.length) {
			String encodedParams = HttpClient.encodeParameters(params);
			if (-1 == url.indexOf("?")) {
				url += "?" + encodedParams;
			} else {
				url += "&" + encodedParams;
			}
		}
		DeleteMethod deleteMethod = new DeleteMethod(url);
		return httpRequest(deleteMethod, token);

	}

	/**
	 * 处理http post请求
	 * 
	 */
	public HttpResponse post(String url, HttpParameter[] params, String token)
			throws XimalayaException {
		return post(url, params, true, token);

	}
	
	public HttpResponse post(String url, HttpParameter[] params,
			Boolean WithTokenHeader, String token) throws XimalayaException {
		LOG.debug("Request:");
		LOG.debug("POST" + url);
		PostMethod postMethod = new PostMethod(url);
		for (int i = 0; i < params.length; i++) {
			postMethod.addParameter(params[i].getName(), params[i].getValue());
		}
		HttpMethodParams param = postMethod.getParams();
		param.setContentCharset("UTF-8");
		return httpRequest(postMethod, WithTokenHeader, token);
	}
	
	public HttpResponse httpRequest(HttpMethod method, String token) throws XimalayaException {
		return httpRequest(method, true, token);
	}

	public HttpResponse httpRequest(HttpMethod method, Boolean WithTokenHeader, String token)
			throws XimalayaException {
		InetAddress ipaddr;
		int responseCode = -1;
		try {
			ipaddr = InetAddress.getLocalHost();
			List<Header> headers = new ArrayList<Header>();
			if (WithTokenHeader) {
				if (token == null) {
					throw new IllegalStateException("Oauth2 token is not set!");
				}
				headers.add(new Header("Authorization", "OAuth2 " + token));
				headers.add(new Header("API-RemoteIP", ipaddr.getHostAddress()));
				client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
				for (Header hd : headers) {
					LOG.debug(hd.getName() + ": " + hd.getValue());
				}
			}
			
			method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler(3, false));
			client.executeMethod(method);
			Header[] resHeader = method.getResponseHeaders();
			responseCode = method.getStatusCode();
			LOG.debug("Response:");
			LOG.debug("https StatusCode:" + String.valueOf(responseCode));

			for (Header header : resHeader) {
				LOG.debug(header.getName() + ":" + header.getValue());
			}
			HttpResponse response = new HttpResponse();
			response.setResponseAsString(method.getResponseBodyAsString());
			LOG.debug(response.toString() + "\n");

			if (responseCode != HTTP_STATUS_OK) {
				try {
					throw new XimalayaException(getCause(responseCode),
							response.asJSONObject(), method.getStatusCode());
				} catch (JSONException e) {
					throw new XimalayaException("parse response json failed", e);
				}
			}
			return response;

		} catch (IOException ioe) {
			throw new XimalayaException(ioe.getMessage(), ioe, responseCode);
		} finally {
			method.releaseConnection();
		}
	}

	/*
	 * 对HTTP请求参数进行encode处理
	 */
	public static String encodeParameters(HttpParameter[] postParams) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < postParams.length; i++) {
			if (i != 0) {
				buf.append("&");
			}
			try {
				buf.append(URLEncoder.encode(postParams[i].getName(), "UTF-8"))
						.append("=")
						.append(URLEncoder.encode(postParams[i].getValue(),
								"UTF-8"));
			} catch (java.io.UnsupportedEncodingException neverHappen) {
			}
		}
		return buf.toString();
	}
	
	private static String getCause(int statusCode) {
		String cause = null;
		switch (statusCode) {
		case HTTP_SATUS_NOT_MODIFIED:
			break;
		case HTTP_STATUS_BAD_REQUEST:
			cause = "The request was invalid because request param missing or illegal.";
			break;
		case HTTP_STATUS_UNAUTHORIZED:
			cause = "Authentication credentials were missing or incorrect.";
			break;
		case HTTP_STATUS_FORBIDDEN:
			cause = "The request is understood, but it has been refused due to lack of permission.";
			break;
		case HTTP_STATUS_NOT_FOUND:
			cause = "The URI requested is invalid or the resource requested, such as a user, does not exists.";
			break;
		case HTTP_STATUS_SERVER_ERROR:
			cause = "Something is broken within the ximalaya openapi server.";
			break;
		case HTTP_STATUS_BAD_GATEWAY:
			cause = "Ximalaya openapi server is down or being upgraded.";
			break;
		default:
			cause = "";
		}
		return statusCode + ":" + cause;
	}

	
}
