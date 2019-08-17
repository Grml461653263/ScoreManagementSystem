package com.my.score.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 将字符串格式的日期转换为Date类型，精确到时分秒
 */
public class StringToDate {
	
	public Date stringToDate(String str) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date=null;
		try {
			
			date = dateFormat.parse(str);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
}
