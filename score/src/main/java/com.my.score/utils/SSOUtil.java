package com.my.score.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class SSOUtil {
	//code路径
	public static final String CODEURL="http://mis-test.diditaxi.com.cn/auth/sso/api/check_code";
	//统一app_key
	public static final String APP_KEY="39d00621a611f77baca7f1fc6b608526";
	//统一app——id
	public static final Integer APP_ID=1206;
	//ticket路径
	public static  final String TICKETURL="http://mis-test.diditaxi.com.cn/auth/sso/api/check_ticket";
	//线下路径
	public static final String TEST_LOGINURL="http://mis-test.diditaxi.com.cn/auth/sso/login?app_id=1206&jumpto=%2F&version=1.0";
	//登录路径 线上路径
	public static final String LOGINURL="http://mis.diditaxi.com.cn/auth/sso/login?app_id=4&jumpto=%2F&version=1.0";
	//ticket——session(map) key:ticket key:userName
	public static final String TICKET_SESSION="ticket_session";
    /**
     * 获取校验code
     * @param code 
     * @return 校验code路径
     */
    public static  String getCodeUrl(String code) {
    	String url=CODEURL+"?code="+code+"&app_key="+APP_KEY+"&app_id="+APP_ID;
    	System.out.println(url);
    	return url;
    }
    /**
     * 获取校验ticket
     * @param ticket 
     * @return 校验ticket路径
     */
    public static  String getTicketUrl(String ticket) {
    	String url=TICKETURL+"?code="+ticket+"&app_id="+APP_ID;
    	System.out.println(encode(url));
    	return encode(url);
    }
    /**
     * 解码
     * @param param
     * @return
     */
    public static String decode(String param) {
    	String newDecode=null;
    	try {
    		newDecode=URLDecoder.decode(param,"UTF-8");//解码
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return newDecode;
    }
    /**
     * 转码
     * @param param
     * @return
     */
    public static String encode(String param) {
    	String newEncode=null;
    	try {
    		newEncode=URLEncoder.encode(param, "GBK");//转码
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return  newEncode;
    }
}
