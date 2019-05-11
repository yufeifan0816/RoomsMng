package com.yff.roomsMng.utils.net;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Describe
 * @Author Dougest
 * @Time 2018年12月7日
 */
public class HttpclientCore {
	private static Log logger = LogFactory.getLog(HttpclientCore.class);

	/**
	 * @Describe 支持http/https
	 * @Author Dougest
	 * @Date 2018年12月11日 上午10:21:10
	 * @return
	 */
	public static CloseableHttpClient initHttpclient() {
		logger.info("initHttpclient ... ");
		// 设置连接管理器
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(
				HttpclientPool.initPoolAndGetRegistry());
		ConnectionConfig.Builder conConfigbuilder = ConnectionConfig.custom();
		conConfigbuilder.setCharset(Charset.forName("UTF-8"));
		// .setBufferSize(0).setFragmentSizeHint(0);
		// build something ...

		connManager.setDefaultConnectionConfig(conConfigbuilder.build());
		SocketConfig.Builder socketConfigBuilder = SocketConfig.custom();
		// build something ...
		connManager.setDefaultSocketConfig(socketConfigBuilder.build());
		// 构建客户端
		CloseableHttpClient client = HttpClientBuilder.create().setConnectionManager(connManager).build();
		return client;
	}

	// 默认连接池性能本地测的不怎么行
	public static CloseableHttpClient initDefaultHttpclient() {
		logger.info("initDefaultHttpclient ... ");
		// 设置连接管理器
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
		ConnectionConfig.Builder conConfigbuilder = ConnectionConfig.custom();
		conConfigbuilder.setCharset(Charset.forName("UTF-8"));
		// build something ...
		// .setBufferSize(0).setFragmentSizeHint(0);

		connManager.setDefaultConnectionConfig(conConfigbuilder.build());
		SocketConfig.Builder socketConfigBuilder = SocketConfig.custom();
		// build something ...
		connManager.setDefaultSocketConfig(socketConfigBuilder.build());
		// 构建客户端
		CloseableHttpClient client = HttpClientBuilder.create().setConnectionManager(connManager).build();
		return client;
	}

	/**
	 * 发送 POST 请求（HTTP/HTTPS）
	 * 
	 * 
	 * @param apiUrl
	 * @return
	 */
	public static String doPost(String apiUrl) throws Exception {
		return doPost(apiUrl, new HashMap<String, String>(), null, null);
	}

	public static String doPostEntity(String apiUrl, HttpEntity entity) throws Exception {
		logger.info("doPostEntity ... ");
		CloseableHttpClient httpClient = initHttpclient();
		String httpStr = null;
		HttpPost httpPost = new HttpPost(apiUrl);
		CloseableHttpResponse response = null;

		try {
			httpPost.setEntity(entity);
			httpPost.setConfig(HttpclientConfig.initConfig());
			response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			httpStr = EntityUtils.toString(httpEntity, HttpConstPool.CHAR_SET_UTF_8);
		} catch (IOException e) {
			httpPost.abort();
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return httpStr;
	}

	/**
	 * 发送 POST 请求（HTTP/HTTPS），K-V形式 参数/请求体/header
	 * 
	 * @Describe
	 * @Author Dougest
	 * @Date 2018年12月11日 下午4:24:41
	 * @param apiUrl
	 * @param params
	 * @param entity
	 * @param header
	 * @return
	 * @throws Exception
	 */
	public static String doPost(String apiUrl, Map<String, String> params, Map<String, String> entity,
			Map<String, String> header) throws Exception {
		logger.info("doPost ... ");
		// CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpClient httpClient = initHttpclient();
		String httpStr = null;
		HttpPost httpPost = new HttpPost(apiUrl);
		CloseableHttpResponse response = null;

		try {
			// 设置头信息
			if (header != null && !header.isEmpty()) {
				for (Map.Entry<String, String> entry : header.entrySet()) {
					httpPost.addHeader(entry.getKey(), entry.getValue());
				}
			}
			// 请求体
			if (entity != null && !entity.isEmpty()) {
				List<NameValuePair> pairList = new ArrayList<NameValuePair>(entity.size());
				for (Map.Entry<String, String> entry : entity.entrySet()) {
					NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
					pairList.add(pair);
				}
				httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
			}

			// 设置请求参数
			if (params != null && !params.isEmpty()) {
				List<NameValuePair> formparams = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> entry : params.entrySet()) {
					// 给参数赋值
					formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
				UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
				httpPost.setEntity(urlEncodedFormEntity);
			}

			httpPost.setConfig(HttpclientConfig.initConfig());
			response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			httpStr = EntityUtils.toString(httpEntity, HttpConstPool.CHAR_SET_UTF_8);
		} catch (IOException e) {
			httpPost.abort();
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return httpStr;
	}

	/**
	 * 发送 POST 请求（HTTP/HTTPS），JSON形式
	 */
	public static String doPostJson(String apiUrl, JSONObject json) {
		logger.info("doPostJson ... ");
		CloseableHttpClient httpClient = initHttpclient();
		String httpStr = null;
		HttpPost httpPost = new HttpPost(apiUrl);
		CloseableHttpResponse response = null;
		try {
			httpPost.setConfig(HttpclientConfig.initConfig());
			StringEntity stringEntity = new StringEntity(json.toString(), HttpConstPool.CHAR_SET_UTF_8);// 解决中文乱码问题
			stringEntity.setContentEncoding(HttpConstPool.CHAR_SET_UTF_8);
			stringEntity.setContentType(HttpConstPool.CONTENT_TYPE_JSON);
			httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			httpStr = EntityUtils.toString(entity, HttpConstPool.CHAR_SET_UTF_8);
		} catch (IOException e) {
			httpPost.abort();
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return httpStr;
	}

	/**
	 * 发送 POST 请求（HTTP/HTTPS），File形式
	 */
	public static String doPostFile(String apiUrl, File file) {
		logger.info("doPostFile ... ");
		CloseableHttpClient httpClient = initHttpclient();
		FileEntity entity = new FileEntity(file);
		entity.setChunked(true);// 作用于http1.1 通知HttpClient分块编码
		entity.setContentType(HttpConstPool.PLAIN_TEXT_TYPE);
		entity.setContentEncoding(HttpConstPool.CHAR_SET_UTF_8);
		HttpPost httpPost = new HttpPost(apiUrl);
		httpPost.setConfig(HttpclientConfig.initConfig());
		httpPost.setEntity(entity);
		CloseableHttpResponse response = null;
		String httpStr = null;
		try {
			response = httpClient.execute(httpPost);
			httpStr = EntityUtils.toString(response.getEntity(), HttpConstPool.CHAR_SET_UTF_8);
			return httpStr;
		} catch (ClientProtocolException e1) {
			httpPost.abort();
			e1.printStackTrace();
		} catch (IOException e1) {
			httpPost.abort();
			e1.printStackTrace();
		} catch (ParseException e) {
			httpPost.abort();
			e.printStackTrace();
		}
		return httpStr;
	}

	/**
	 * @Describe https请求
	 * @Author Dougest
	 * @Date 2018年12月11日 上午10:17:10
	 */
	public static String doPostHttps(String url) {
		logger.info("doPostHttps ... ");
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			httpPost.setConfig(HttpclientConfig.initConfig());
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, HttpConstPool.CHAR_SET_UTF_8);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
