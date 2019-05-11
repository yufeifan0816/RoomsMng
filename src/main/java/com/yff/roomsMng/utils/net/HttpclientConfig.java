package com.yff.roomsMng.utils.net;

import org.apache.http.client.config.RequestConfig;

/**
 * @Describe 请求配置
 * @Author Dougest
 * @Time 2018年12月10日
 */
public class HttpclientConfig {

	public static RequestConfig initConfig() {
		RequestConfig.Builder configBuilder = RequestConfig.custom();
		// 设置连接超时
		configBuilder.setConnectTimeout(HttpConstPool.MAX_TIMEOUT)
				// 设置读取超时
				.setSocketTimeout(HttpConstPool.MAX_TIMEOUT / 2)
				// 设置从连接池获取连接实例的超时
				.setConnectionRequestTimeout(HttpConstPool.MAX_TIMEOUT / 2);

		// 在提交请求之前 测试连接是否可用
		// .setStaleConnectionCheckEnabled(true);

		return configBuilder.build();
	}

}
