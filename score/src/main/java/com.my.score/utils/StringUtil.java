package com.my.score.utils;
/**
*
* @ClassName:StringUtil.java
* @description:
* @author: wangjunpeng
* @date: 2018年5月15日 下午5:35:50
* @version: v1.0.0
*
**/
public class StringUtil {
	//查询某个字符出现第几次次是的 下表
	public static Integer getStrIndex(String str,char s,Integer number){
		int count=0;
		for(int i=0;i<str.length();i++)
		{
			
			if(str.charAt(i)==s)  
			{
		      count++;  //如果=s就加
		      if(count==number)
		         return i+1;//返回所寻找的字符第N次出现的索引       ///因为i是从0开始的所以加一才是长度
			}

		}
		return -1;
	}
}
