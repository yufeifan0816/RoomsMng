package com.yff.roomsMng.utils;

import com.yff.roomsMng.utils.net.HttpclientCore;

/**
 * @program: RoomsMng
 * @description:
 * @author: yufeiafn@wondersgroup.com
 * @create: 2019-04-08 15:19
 **/
public class test {
    /** 短信接口地址 **/
    private static final String SMS_URL = "http://v.juhe.cn/sms/send";
    private static final String SMS_KEY = "03b1e945006cc9cf531fbf9b384a1696";
    private static final String SMS_TEMPLATE_ID = "146373";
    public static void main(String[] args) throws Exception {
        sendSms("18271875021","niHaoLta");
    }

    /**
     *
     * @param phoneNum
     * @param code
     * @return
     * @throws Exception
     */
    public static void sendSms(String phoneNum, String code) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(SMS_URL).append("?");
        sb.append("mobile=").append(phoneNum).append("&");
        sb.append("tpl_id=").append(SMS_TEMPLATE_ID).append("&");
        sb.append("tpl_value=").append("%23code%23%3d").append(code).append("&");
        sb.append("key=").append(SMS_KEY);
        String result = HttpclientCore.doPost(sb.toString());
    }
}
