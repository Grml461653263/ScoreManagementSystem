package com.my.score.utils;

import javax.servlet.http.Cookie;

/**
*
* @ClassName:CookieUtil.java
* @description:
* @author: wangjunpeng
* @date: 2018年5月30日 上午11:35:50
* @version: v1.0.0
*
**/
public class CookieUtils {
	
	public static String getCookieValue(String keyName,Cookie[] cookie) {
		String value=null;
		if(null !=cookie && cookie.length>0) {
			for (Cookie cookie2 : cookie) {
				if(cookie2.getName().equals(keyName)) {
					value=cookie2.getValue();
					break;
				}
			}
		}
		return value;
	}
}
