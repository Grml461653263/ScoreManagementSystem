package com.my.score.utils;

import java.util.Date;

public class CheckStact {
	private volatile static CheckStact checkstact;
	private CheckStact(){}
	public static int [] oldResult=null;
	public static int num=0;
	private  static Date dates;
	
	public static Date getDates() {
		return dates;
	}

	public static CheckStact getCheckstact(){
	     if(checkstact == null){
	           synchronized(CheckStact.class){
	               if(checkstact == null){
	            	   checkstact = new CheckStact();
	               }
	           }
	     }
	     return checkstact;
	}
	
	public static Date setDate(Date date) {
		if(num<1) {
			num=1;
			dates=date;
		}else {
			return null;
		}
		
		return date;
	}
	
	}
	


