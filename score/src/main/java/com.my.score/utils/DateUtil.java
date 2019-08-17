package com.my.score.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
*
* @ClassName:DateUtil.java
* @description:时间工具类 
* @author: wangjunpeng
* @date: 2018年5月16日 上午11:25:11
* @version: v1.0.0
*
**/
public class DateUtil {
	//取到 hours 以前时间
	public static Date headDate(String date ,int hours) throws ParseException{
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new SimpleDateFormat("yyyy-MM-dd HH").parse(date));
	    cal.add(Calendar.HOUR_OF_DAY, hours);
	    return cal.getTime();
	}
	
	/**
     * date2比date1多的天数
     * @param date1    
     * @param date2
     * @return    
     */
	 public static int differentDays(Date date1,Date date2)
	    {
	        Calendar cal1 = Calendar.getInstance();
	        cal1.setTime(date1);
	        
	        Calendar cal2 = Calendar.getInstance();
	        cal2.setTime(date2);
	       int day1= cal1.get(Calendar.DAY_OF_YEAR);
	        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
	        
	        int year1 = cal1.get(Calendar.YEAR);
	        int year2 = cal2.get(Calendar.YEAR);
	        if(year1 != year2)   //同一年
	        {
	            int timeDistance = 0 ;
	            for(int i = year1 ; i < year2 ; i ++)
	            {
	                if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
	                {
	                    timeDistance += 366;
	                }
	                else    //不是闰年
	                {
	                    timeDistance += 365;
	                }
	            }
	            
	            return timeDistance + (day2-day1) ;
	        }
	        else    //不同年
	        {
	            //System.out.println("判断day2 - day1 : " + (day2-day1));
	            return day2-day1;
	        }
	    }
	 
	 	/**
	     * 通过时间秒毫秒数判断两个时间的间隔
	     * @param date1
	     * @param date2
	     * @return
	     */
	    public static int differentDaysByMillisecond(Date date1,Date date2)
	    {
	        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
	        return days;
	    }
	    
	  //取到 多少天 以前时间
		public static Date dayDate(String date ,int day) throws ParseException{
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
		    cal.add(Calendar.DATE, day);
		    return cal.getTime();
		}
		
		//取到 多少天 以前时间     ///应该是月
		public static Date dayMonth(String date ,int mouth) throws ParseException{
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(new SimpleDateFormat("yyyy-MM").parse(date));
		    cal.add(Calendar.MONTH, mouth);
		    return cal.getTime();
		}
		
		//两个时间相差多少月
		public static int differentMouth(Date date1,Date date2) {
			Calendar bef = Calendar.getInstance();  
	        Calendar aft = Calendar.getInstance();
	        bef.setTime(date1);  
	        aft.setTime(date2);  
	        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);  
	        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;  
	        return Math.abs(month + result);
		}
		//取到 多少年 以前时间
		public static Date YearMonth(String date ,int year) throws ParseException{
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(new SimpleDateFormat("yyyy").parse(date));
		    cal.add(Calendar.YEAR, year);
		    return cal.getTime();
		}
}
