package com.my.score.utils;
/**
*
* @ClassName:FinalVariable.java
* @description:常量公用类
* @author: wangjunpeng
* @date: 2018年5月29日 下午4:50:28
* @version: v1.0.0
*
**/
public class FinalVariable {
	public static final String uploadPath = "/home/az-user/apps/package/weima/weimaFile/uploadFile/"; //下载路径
	public static final String importPath = "/home/az-user/apps/package/weima/weimaFile/importFile/";//上传路径
	public static final String templetPath = "/home/az-user/apps/package/weima/weimaFile/templetFile/";//模板路径
	//public final static String  datasyncweima="http://42.159.91.94:8082/";//更新评论数
	public static final String datasyncweima = "http://localhost:8082/";//测试 更新评论数
	//public final static String  datasyncweima="http://localhost:8082/";//生产 更新评论数
	public final static String  weixin = "http://139.196.33.124:8082/push/pushweb";//微信推送
	//public final static String  weixin = "http://139.219.7.149:19200/sendMessage";//微信推送
}
