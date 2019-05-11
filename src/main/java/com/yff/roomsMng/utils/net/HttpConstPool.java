package com.yff.roomsMng.utils.net;

/**
 * @Describe HttpClient静态资源
 * @Author Dougest
 * @Time 2018年12月10日
 */
public class HttpConstPool {
	// 最大链接时
	public static final int MAX_TIMEOUT = 10 * 10000;

	public static final String CONTENT_TYPE_JSON = "application/json";

	public final static String OCTET_STREAM_TYPE = "application/octet-stream";

	public final static String PLAIN_TEXT_TYPE = "text/plain";
	/**
	 */
	public final static String CHARSET_PARAM = "; charset=";

	/** HTTP header 定义 */
	public static final String TRANSFER_ENCODING = "Transfer-Encoding";
	public static final String CONTENT_LEN = "Content-Length";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String CONTENT_ENCODING = "Content-Encoding";
	public static final String EXPECT_DIRECTIVE = "Expect";
	public static final String CONN_DIRECTIVE = "Connection";
	public static final String TARGET_HOST = "Host";
	public static final String USER_AGENT = "User-Agent";
	public static final String DATE_HEADER = "Date";
	public static final String SERVER_HEADER = "Server";
	/** HTTP 链接控制 */
	public static final String CONN_CLOSE = "Close";
	public static final String CONN_KEEP_ALIVE = "Keep-Alive";

	public static final String HTTP_SCHEMA = "http";
	public static final String HTTPS_SCHEMA = "https";

	/** 操作失败! **/
	public static final String RESPONSE_STATUS_ERROR = "-1";
	/** Hearder参数错误,不能为空 **/
	public static final String RESPONSE_STATUS_0 = "0";
	/** 操作成功! **/
	public static final String RESPONSE_STATUS_1 = "1";
	/** 请求数据解密失败! **/
	public static final String RESPONSE_STATUS_2 = "2";
	/** 响应数据解析或加密失败! **/
	public static final String RESPONSE_STATUS_3 = "3";
	/** 请检查password或userName参数是否传输正确! **/
	public static final String RESPONSE_STATUS_4 = "4";
	/** RSA秘钥获取失败! **/
	public static final String RESPONSE_STATUS_5 = "5";
	/** AES秘钥获取失败! **/
	public static final String RESPONSE_STATUS_6 = "6";
	/** 参数 {0} 不能为空,你检查你输入的参数 **/
	public static final String RESPONSE_STATUS_7 = "7";
	/** RSA解密失败! **/
	public static final String RESPONSE_STATUS_8 = "8";
	/** 无法识别的数据,秘钥解密失败,无法解密数据! **/
	public static final String RESPONSE_STATUS_90 = "90";
	/** 秘钥失效,根据设备信息无法找到对应秘钥或对应秘钥已失效 **/
	public static final String RESPONSE_STATUS_91 = "91";
	/** 非法请求,Hearder参数不错误 **/
	public static final String RESPONSE_STATUS_92 = "92";
	/** http协议头 **/
	public static final String PROTOCOL_HTTP = "http://";
	/** https协议头 **/
	public static final String PROTOCOL_HTTPS = "https://";
	/** file协议头 **/
	public static final String PROTOCOL_FILE = "file://";
	/** 响应成功 **/
	public static final Integer HTTP_STATUS_OK = 200;
	/** 内部异常 **/
	public static final Integer HTTP_STATUS_INTERNAL_SERVER_ERROR = 500;

	public static final String CHAR_SET_UTF_8 = "UTF-8";

}
