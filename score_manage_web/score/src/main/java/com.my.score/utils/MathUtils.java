package com.my.score.utils;
/**
*
* @ClassName:MathUtils.java
* @description:
* @author: wangjunpeng
* @date: 2018年6月5日 下午5:45:55
* @version: v1.0.0
*
**/
public class MathUtils {
	/**
	 * 两个数比值
	 * @param a
	 * @param b
	 */
	public static String minScale(int a, int b) {
		String bizhi="0:0";
	    int tmp = a;
	    if(a > b) {
	        tmp = b;
	    }
	    for(int i = tmp; i > 0; i--) {
	        if(a % i == 0 && b % i ==0) {
	        	bizhi=(a / i)+":"+(b / i);
	            System.out.println(a + ":" + b + "=" + (a / i) + ":" + (b / i));
	            break;
	        }
	    }
	    return bizhi;
	}
}
