package com.my.score.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 日期常用方法类
 */
public class DateUtils {

	private static Logger log = LoggerFactory.getLogger(DateUtils.class);

	public static final String globalTimeFormater = "yyyyMMdd HH:mm:ss";

	private static final String DATE_PATTERN = "yyyy-MM-dd";

	private static final String DATE_NUMBER_PATTERN = "yyyyMMdd";

	private static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	private static final String TIME_ONLY_PATTERN = "HHmmss";

	private static final String MONEY_PATTERN = "############0.00";

	private static final String CURRENCY_PATTERN = "#,###,###,###,##0.00";

	private static final String TIME_HHMMSS_PATTERN = "HH:mm:ss";

	private static final String DATE_YYYYMM_PATTERN = "yyyyMM";

	public static final String DATE_YYYYMMDDHH_PATTERN = "yyyyMMddHH";

	public static final String DATE_HH_PATTERN = "HH";

	public static final String DATE_YYYYMMDDHHMM_PATTERN = "yyyy:MM:dd HH:mm";

	public static final String DATE_YYYYMMDDHHZERO_PATTERN = "yyyy:MM:dd HH";

	public static final String DATE_PATTERN_CN = "yyyy年MM月dd日";

	public static final String seqnoTimeFormater = "yyyyMMddHHmmssSSS";

	public static final String DATE_DD_PATTERN = "dd";

	/**
	 * 由日期返回 dd 格式的字符串
	 *
	 * @param date
	 * @return
	 */
	public static String getDay(Date date) {
		if (date == null)
			return null;
		return dateToNumber(date).substring(6, 8);
	}

	/**
	 * 由日期返回 mm 格式的字符串
	 *
	 * @param date
	 * @return
	 */
	public static String getMonth(Date date) {
		if (date == null)
			return null;
		return dateToNumber(date).substring(4, 6);
	}

	/**
	 * 由yyyy-MM-dd格式的字符串返回日期
	 *
	 * @param date
	 * @return
	 */
	public static Date stringToDate(String string) {
		if (string == null)
			return null;

		if (string.trim().length() == 0)
			return null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
		try {
			return simpleDateFormat.parse(string);
		} catch (ParseException e) {
			log.error("stringToDate exception : ", e);
		}
		return null;
	}

	/**
	 * 由yyyy-MM-dd HH:mm:ss格式的字符串返回日期
	 *
	 * @param date
	 * @return
	 */
	public static Date stringToTime(String string) {
		if (string == null)
			return null;
		if (string.trim().length() == 0)
			return null;
		if (string.indexOf(":") == -1) {
			string += " 00:00:00";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_PATTERN);
		try {
			return simpleDateFormat.parse(string);
		} catch (ParseException e) {
			log.error("stringToTime exception : ", e);
		}
		return null;
	}

	/**
	 * 由日期返回yyyy-MM-dd格式的字符串
	 *
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		if (date == null)
			return null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
		return simpleDateFormat.format(date);
	}

	/**
	 * 由日期返回yyyyMMdd格式的字符串
	 *
	 * @param date
	 * @return
	 */
	public static String dateToNumber(Date date) {
		if (date == null)
			return null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_NUMBER_PATTERN);
		return simpleDateFormat.format(date);
	}

	public static Date parseGlobalTime(String globalTime) {
		if (StringUtils.isEmpty(globalTime)) {
			return null;
		}
		try {
			return (new SimpleDateFormat(globalTimeFormater)).parse(globalTime);
		} catch (ParseException e) {
			log.info("globalTime_error:" + globalTime);
			return null;
		}
	}

	public static String parseGlobalTime(Date globalTime) {
		if (null == globalTime) {
			return "";
		}
		SimpleDateFormat fullDate = new SimpleDateFormat(globalTimeFormater);
		return fullDate.format(globalTime);
	}

	/**
	 * String(yyyy-MM-dd) -> Date
	 * 
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date parse10Date(String strDate) {
		if (strDate == null) {
			return null;
		}

		try {
			return (new SimpleDateFormat("yyyy-MM-dd")).parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + strDate + "解析为 " + "yyyy-MM-dd" + "格式的日期时发生异常:", e);
		}
	}

	/**
	 * String(yyyy-MM-dd HH:mm:ss) -> Date
	 * 
	 * @param dateTime 时间字符串(yyyy-MM-dd HH:mm:ss)
	 * @return
	 */
	public static Date parseFullDateTime(String dateTime) {
		if (StringUtils.isEmpty(dateTime)) {
			return null;
		}

		try {
			return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(dateTime);
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + dateTime + "解析为 yyyy-MM-dd HH:mm:ss" + "格式的日期时发生异常:", e);
		}
	}

	/**
	 * Date -> String(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param date
	 * @return
	 */
	public static String formatFullDate(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat fullDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return fullDate.format(date);
	}

	/**
	 * 把日期，时间转化为格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getDateTime() {
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
	}

	/**
	 * 取得当前日期字符串; 日期格式:yyyyMMdd
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		return (new SimpleDateFormat("yyyyMMdd")).format(new Date());
	}

	/**
	 * Date -> String(yyyyMMddHHmmss)
	 * 
	 * @param date
	 * @return
	 */
	public static String get14Date(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat fullDate = new SimpleDateFormat("yyyyMMddHHmmss");
		return fullDate.format(date);
	}

	/**
	 * 取得日期字符串; 日期格式:yyyyMMdd
	 * 
	 * @return
	 */
	public static String get8Date(Date date) {
		return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
	}

	/**
	 * 取得日期字符串; 日期格式:yyyyMMdd
	 *
	 * @return
	 */
	public static String get8DatePoint(Date date) {
		return (new SimpleDateFormat("yyyy.MM.dd")).format(date);
	}

	/**
	 * 取得日期字符串; 日期格式:yyyyMMdd
	 * 
	 * @return
	 */
	public static String get10Date(Date date) {
		return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
	}

	/**
	 * 取得日期字符串; 日期格式:yyyyMMdd
	 * 
	 * @return
	 */
	public static String get8Time(Date date) {
		return (new SimpleDateFormat("HH:mm:ss")).format(date);
	}

	/**
	 * 取得当前日期字符串; 日期格式:yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getCurrentPageDate() {
		return (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
	}

	/**
	 * 取得当前日期字符串; 日期格式:yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getCurrentPageDate(Date date) {
		return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
	}

	/**
	 * Date -->> yyyy年MM月dd HH:mm:ss
	 * 
	 * @param date
	 */
	public static String formatLocalDate(Date date) {
		return (new SimpleDateFormat("yyyy年MM月dd HH:mm:ss")).format(date);
	}

	public static String getCompactCurrentTime() {
		return (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
	}

	public static Date getCompactCurrentTime(String strDate) {
		if (strDate == null) {
			return null;
		}

		try {
			return (new SimpleDateFormat("yyyyMMddHHmmss")).parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + strDate + "解析为 " + "yyyy-MM-dd" + "格式的日期时发生异常:", e);
		}
	}

	/**
	 * HH:mm:ss ->> HHmmss
	 * 
	 * @param pageTime
	 * @return
	 */
	public static String pageTimeToDbTime(String pageTime) {
		return pageTime.replaceAll(":", "");
	}

	/**
	 * 将日期转换为指定格式
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formateDate2Str(Date date, String pattern) {
		SimpleDateFormat s = new SimpleDateFormat(pattern);
		return s.format(date);
	}

	/**
	 * @Title formateStr2Date
	 * @Description 指定格式字符串转换为日期
	 * @author liguopeng
	 * @param data
	 * @param pattern
	 * @return
	 */
	public static Date formateStr2Date(String data, String pattern) {
		SimpleDateFormat s = new SimpleDateFormat(pattern);
		try {
			return s.parse(data);
		} catch (Exception e) {
			throw new RuntimeException("时间转换失败，字符串:" + data + "，格式" + pattern, e);
		}
	}

	/**
	 * 将日期中的2007-1-1转化为20070101格式
	 * 
	 * @param datestr
	 * @return
	 */
	public static String dateStringFormat(String datestr) {
		if (datestr == null || datestr.equals(""))
			return null;
		String[] str1 = datestr.split("-");
		if (str1.length == 3) {
			if (str1[1].length() == 1) {
				str1[1] = "0" + str1[1];
			}
			if (str1[2].length() == 1) {
				str1[2] = "0" + str1[2];
			}
		} else
			return datestr;
		datestr = str1[0] + str1[1] + str1[2];
		return datestr;
	}

	public static Date addDay(Date oriDate, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(oriDate);
		cal.add(Calendar.DAY_OF_MONTH, amount);
		return cal.getTime();
	}

	public static Date addMinutes(Date oriDate, int interval) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(oriDate);
		cal.add(Calendar.MINUTE, interval);
		return cal.getTime();
	}

	public static Date addSeconds(Date oriDate, int interval) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(oriDate);
		cal.add(Calendar.SECOND, interval);
		return cal.getTime();
	}

	/**
	 * 取得指定格式的当前时间
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getTime(String pattern) {
		return new SimpleDateFormat(pattern).format(new Date());
	}

	/**
	 * 取得指定时间的偏移时间
	 * 
	 * @param transferTime 原始时间（yyyy-MM-dd HH:ss:mm）
	 * @param calendarType 偏移单位（Calendar的常量）
	 * @param i            偏移量
	 * @return
	 */
	public static String getExcursionTime(String transferTime, int calendarType, int i) {
		Date parseFullDateTime = parseFullDateTime(transferTime);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parseFullDateTime);
		calendar.add(calendarType, i);
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(calendar.getTime());
	}

	/**
	 * 取得当前时间的偏移时间
	 * 
	 * @param              calendarType（yyyy-MM-dd HH:ss:mm）
	 * @param calendarType 偏移单位（Calendar的常量）
	 * @param i            偏移量
	 * @return
	 */
	public static String getExcursionTime(int calendarType, int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(calendarType, i);
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(calendar.getTime());
	}

	/**
	 * 取得指定时间的偏移时间
	 * 
	 * @param calendarType 偏移单位（Calendar的常量）
	 * @param i            偏移量
	 * @param 日期格式
	 * @return
	 */
	public static String getExcursionTime(String transferTime, int calendarType, int i, String pattern) {
		try {
			SimpleDateFormat f = new SimpleDateFormat(pattern);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(f.parse(transferTime));
			calendar.add(calendarType, i);
			return new SimpleDateFormat(pattern).format(calendar.getTime());
		} catch (Exception e) {
			throw new RuntimeException("将字符串" + transferTime + "按照 " + pattern + "格式进行转换和计算时发生异常:", e);
		}
	}

	/**
	 * 取得指定时间的偏移时间
	 * 
	 * @param calendarType 偏移单位（Calendar的常量）
	 * @param i            偏移量
	 * @param 日期格式
	 * @return
	 */
	public static String getExcursionTime(int calendarType, int i, String pattern) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(calendarType, i);
		return new SimpleDateFormat(pattern).format(calendar.getTime());
	}

	/**
	 * 取得当前时间的偏移时间 格式为（yyyyMMdd）+1为往后一天，-1为向前一天，0为当天
	 */
	public static String getAboutDate(int i) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DAY_OF_MONTH, i);
		String mDateTime = (new SimpleDateFormat("yyyyMMdd")).format(rightNow.getTime());
		return mDateTime;
	}

	/**
	 * yyyy-MM-dd HH:mm:ss转换成毫秒数
	 * 
	 * @param new_date_f
	 * @return
	 */
	public static long conversion(String new_date_f) {
		try {
			long millisecond = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(new_date_f).getTime();
			return millisecond;
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + new_date_f + "按照 yyyy-MM-dd HH:mm:ss" + "格式进行转换毫秒时发生异常:", e);
		}
	}

	/**
	 * 当月第一天
	 * 
	 * @return
	 */
	public static String monthStart() {
		Calendar curCal = Calendar.getInstance();
		curCal.set(Calendar.DAY_OF_MONTH, 1);
		Date beginTime = curCal.getTime();
		String sTime = (new SimpleDateFormat("yyyy-MM-dd")).format(beginTime) + " 00:00:00";
		return sTime;
	}

	/**
	 * 当月第一天Date
	 * 
	 * @return
	 */
	public static Date monthStartDate(Date date) {
		Calendar curCal = Calendar.getInstance();
		curCal.setTime(date);
		curCal.set(Calendar.DAY_OF_MONTH, 1);
		return curCal.getTime();
	}

	/**
	 * 当月最后一天Date
	 * 
	 * @return
	 */
	public static Date monthEndDate(Date date) {
		Calendar curCal = Calendar.getInstance();
		curCal.setTime(date);
		curCal.set(Calendar.DATE, 1);
		curCal.roll(Calendar.DATE, -1);
		return curCal.getTime();
	}

	/**
	 * 日初
	 * 
	 * @return
	 */
	public static String dayStart() {
		Calendar curCal = Calendar.getInstance();
		Date beginTime = curCal.getTime();
		String sTime = (new SimpleDateFormat("yyyy-MM-dd")).format(beginTime) + " 00:00:00";
		return sTime;
	}

	/**
	 * 日末
	 * 
	 * @return
	 */
	public static String dayEnd() {
		Calendar curCal = Calendar.getInstance();
		Date endTime = curCal.getTime();
		String eTime = (new SimpleDateFormat("yyyy-MM-dd")).format(endTime) + " 23:59:59";
		return eTime;
	}

	/**
	 * 
	 * @param protoDate
	 * @param dayOffset
	 * @return
	 */
	public static Date getOffsetDate(Date protoDate, int dayOffset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(protoDate);
		cal.add(Calendar.DATE, -dayOffset);
		return cal.getTime();
	}

	/**
	 *
	 * @param date        YYYY-MM-DD
	 * @param monthOffset
	 * @return
	 */
	public static String getMonthDate(Date beginDate, int monthOffset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);
		cal.add(Calendar.MONTH, monthOffset);
		Date nextDate = cal.getTime();
		String next = get10Date(nextDate);
		return next;
	}

	/**
	 *
	 * @param date        YYYY-MM-DD
	 * @param monthOffset
	 * @return
	 */
	public static String getMonthDate(String date, int monthOffset) {
		Date beginDate = get8Date(date);

		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);
		cal.add(Calendar.MONTH, monthOffset);
		Date nextDate = cal.getTime();
		String next = get10Date(nextDate);
		return next;
	}

	/**
	 *
	 * @param date        YYYY-MM-DD
	 * @param monthOffset
	 * @return Date
	 */
	public static Date getMonthDate2Date(String date, int monthOffset) {
		Date beginDate = get8Date(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);
		cal.add(Calendar.MONTH, monthOffset);
		Date nextDate = cal.getTime();
		return nextDate;
	}

	/**
	 * 取得日期字符串; 日期格式:yyyy-MM-dd
	 *
	 * @return
	 */
	public static Date get8Date(String date) {
		try {
			return (new SimpleDateFormat("yyyy-MM-dd")).parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				return (new SimpleDateFormat("yyyy-MM-dd")).parse("2016-10-25");
			} catch (Exception e1) {
				return null;
			}
		}
	}

	/**
	 * 
	 * @param protoDate
	 * @param dayOffset
	 * @return
	 */
	public static Date getAddsetHour(Date protoDate, int dayOffset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(protoDate);
		cal.add(Calendar.HOUR, dayOffset);
		return cal.getTime();
	}

	public static Date[] getBeginTimeAndEndTime(Date date) {
		return getBeginTimeAndEndTime(date, 1);
	}

	/**
	 * 从date的0时，到interval天后的0时
	 * 
	 * @param date
	 * @param interval
	 * @return
	 */
	public static Date[] getBeginTimeAndEndTime(Date date, int interval) {
		if (null == date) {
			date = new Date();
		}
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.set(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH), cl.get(Calendar.DATE), 0, 0, 0);
		Date beginTime = cl.getTime();

		Calendar cl1 = Calendar.getInstance();
		cl1.setTime(date);
		cl1.add(Calendar.DATE, interval);
		cl1.set(cl1.get(Calendar.YEAR), cl1.get(Calendar.MONTH), cl1.get(Calendar.DATE), 0, 0, 0);
		Date endTime = cl1.getTime();
		Date[] dates = new Date[2];
		dates[0] = beginTime;
		dates[1] = endTime;
		return dates;
	}

	/**
	 * 
	 * 输入时间 2013-11-11 12:12:12 ;interval =5 返回2013-11-11 12:12:00:00 | 2013-11-11
	 * 17:00:00
	 * 
	 * @return
	 */
	public static Date[] getBeginHourAndEndHour(int type, int before, int interval) {
		Calendar cl = Calendar.getInstance();
		cl.add(type, before);
		cl.set(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH), cl.get(Calendar.DATE), cl.get(Calendar.HOUR_OF_DAY), 0,
				0);
		Date endTime = cl.getTime();

		Calendar cl1 = Calendar.getInstance();
		cl1.add(type, before - interval);
		cl1.set(cl1.get(Calendar.YEAR), cl1.get(Calendar.MONTH), cl1.get(Calendar.DATE), cl1.get(Calendar.HOUR_OF_DAY),
				0, 0);
		Date beginTime = cl1.getTime();

		Date[] dates = new Date[2];
		dates[1] = endTime;
		dates[0] = beginTime;
		return dates;
	}

	/**
	 * 返回指定两个时间间隔的分钟数，误差小于1分钟</br>
	 * 采用进位算法，如果不满1分钟以1分钟来计算.
	 * 
	 * @param startDate 开始时间
	 * @param endDate   结束时间
	 * @return
	 */
	public static int getIntervalMinutes(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			return -1;
		}
		int minute = 1000 * 60;
		long im = endDate.getTime() - startDate.getTime();
		return (int) (im % minute == 0 ? im / minute : (im / minute + 1));
	}

	/***
	 * 比较是不是同一天
	 * 
	 * @param workDay
	 * @param currTime
	 * @return
	 */
	public static boolean compWorkAndCurrByDate(Date workDay, Date currTime) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(workDay);
		c2.setTime(currTime);
		if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
				&& c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 移动月份
	 * 
	 * @param date
	 * @param monthOffset
	 * @return
	 */
	public static Date getMonthOffsetDate(Date date, int monthOffset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, monthOffset);
		return cal.getTime();
	}

	/**
	 * 设置日期中的日
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date setDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	/**
	 * 
	 * <div/>输入2014-08-28 17:00:29 和 0 的到 2014-08-28 00:00:00 <div/>输入2014-08-28
	 * 17:00:29 和 1 的到 2014-08-29 00:00:00 <div/>输入2014-08-28 17:00:29 和 -1 的到
	 * 2014-08-27 00:00:00
	 * 
	 * @param curDate 时间
	 * @param offset  偏移日期
	 * @return
	 */
	public static Date getBeginTimeByOffsetDate(Date curDate, int offset) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(curDate);
		c1.add(Calendar.DATE, offset);
		c2.set(c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DATE), 0, 0, 0);
		return c2.getTime();
	}

	/*
	 * 计算两个日期几件间隔的天数
	 */
	public static int daysBetween(Date startDate, String endDateStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			startDate = sdf.parse(sdf.format(startDate));
			cal.setTime(startDate);
			long time1 = cal.getTimeInMillis();
			Date endDate = sdf.parse(endDateStr);
			cal.setTime(endDate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * 计算两个日期几件间隔的天数
	 */
	public static int daysBetween(Date startDate, Date endDate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			startDate = sdf.parse(sdf.format(startDate));
			endDate = sdf.parse(sdf.format(endDate));
			cal.setTime(startDate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(endDate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * 计算两个日期几件间隔的天数
	 */
	public static int daysBetween(String startDateStr, Date endDate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = sdf.parse(startDateStr);
			endDate = sdf.parse(sdf.format(endDate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(endDate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * 计算两个日期几件间隔的天数
	 */
	public static int daysBetween(String startDateStr, String startDateEnd) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = sdf.parse(startDateStr);
			Date endDate = sdf.parse(startDateEnd);

			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(endDate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(DateUtils.daysBetween("2014-10-09", new Date()));
		System.out.println(DateUtils.daysBetween(new Date(), "2017-08-25"));
		System.out.println(DateUtils.daysBetween("2017-08-25", new Date()));
	}

	/**
	 * @Title daysBetween
	 * @Description 计算两个时间相隔天数
	 * @author liguopeng
	 * @param smdate
	 * @param bdate
	 * @param pattern
	 * @return
	 */
	public static int daysBetween(String smdate, String bdate, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(smdate));
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + smdate + "解析为" + pattern + "格式的日期时发生异常:", e);
		}
		long time1 = cal.getTimeInMillis();
		try {
			cal.setTime(sdf.parse(bdate));
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + smdate + "解析为" + pattern + "格式的日期时发生异常:", e);
		}
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 得到对应日期的对应时间 如00:00:00:000或 23:59:59:999
	 * 
	 * @param date
	 * @param hour
	 * @param minute
	 * @param second
	 * @param milliSecond
	 * @return
	 */
	public static Date getNeedTime(Date date, int hour, int minute, int second, int milliSecond) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		calendar.set(Calendar.MILLISECOND, milliSecond);
		return calendar.getTime();
	}

	/**
	 * 获取当日剩余时间毫秒数(当日截止时间23:59:59 减 当前时间)
	 * 
	 * @return
	 */
	public static long getRemainingTimeInToday() {
		long currentTime = new Date().getTime();
		long endTime = Timestamp.valueOf(DateUtils.dayEnd()).getTime();
		return endTime - currentTime;
	}

	/**
	 * 由日期返回yyyy-MM-dd HH:mm:ss格式的字符串
	 *
	 * @param time
	 * @return
	 */
	public static String timeToString(Date time) {
		if (time == null)
			return null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_PATTERN);
		return simpleDateFormat.format(time);
	}

	/**
	 * 转化成时间的字符串HH:MM:SS.XX
	 */
	public static String millisecondToString(long time) {
		long tmptime = time;
		int hh = (int) Math.floor(tmptime / (60 * 60 * 1000)); // 小时
		tmptime = tmptime % (60 * 60 * 1000);
		int mm = (int) Math.floor(tmptime / (60 * 1000)); // 分钟
		tmptime = tmptime % (60 * 1000);
		int ss = (int) Math.floor(tmptime / 1000); // 秒
		int millisecond = (int) tmptime % 1000;
		return hh + ":" + mm + ":" + ss + "." + millisecond;
	}

	/**
	 * 计算两个日期相隔的天数
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDaysBetween(Date startDate, Date endDate) {
		Calendar calendarStartDate = Calendar.getInstance();
		Calendar calendarEndDate = Calendar.getInstance();

		// 设日历为相应日期
		calendarStartDate.setTime(startDate);
		calendarEndDate.setTime(endDate);
		if (startDate.after(endDate)) {
			Calendar swap = calendarStartDate;
			calendarStartDate = calendarEndDate;
			calendarEndDate = swap;
		}

		int days = calendarEndDate.get(Calendar.DAY_OF_YEAR) - calendarStartDate.get(Calendar.DAY_OF_YEAR);
		int y2 = calendarEndDate.get(Calendar.YEAR);
		while (calendarStartDate.get(Calendar.YEAR) < y2) {
			days += calendarStartDate.getActualMaximum(Calendar.DAY_OF_YEAR);
			calendarStartDate.add(Calendar.YEAR, 1);
		}

		return days;
	}

	/**
	 * 根据起始日和相隔月数计算终止日
	 *
	 * @param startDate
	 * @param months
	 * @return
	 */
	public static Date getEndDateByMonths(Date startDate, int months) {
		Calendar calendarStartDate = Calendar.getInstance();
		calendarStartDate.setTime(startDate);
		calendarStartDate.add(Calendar.MONTH, months);
		return calendarStartDate.getTime();
	}

	/**
	 * 根据起始日和相隔天数计算终止日
	 *
	 * @param startDate
	 * @param days
	 * @return
	 */
	public static Date getEndDateByDays(Date startDate, int days) {
		Calendar calendarStartDate = Calendar.getInstance();
		calendarStartDate.setTime(startDate);
		calendarStartDate.add(Calendar.DAY_OF_YEAR, days);
		return calendarStartDate.getTime();
	}

	/**
	 * 得到上一天的日期(昨天)
	 * 
	 * @param today
	 * @return
	 */
	public static Date getYesterDay(Date today) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 得到下一天的日期(昨天)
	 * 
	 * @param today
	 * @return
	 */
	public static Date getNextDay(Date today) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	/**
	 * 得到下一秒的日期
	 * 
	 * @param today
	 * @return
	 */
	public static Date getNextSecond(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.SECOND, 1);
		return cal.getTime();
	}

	/**
	 * 根据当天日期 和 天数 ， 得到某天的日期(昨天) 天数负数表示 历史某天， 正数表示未来某天
	 * 
	 * @param today
	 * @return
	 */
	public static Date getSomeDay(Date today, int someDay) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, someDay);
		return cal.getTime();
	}

	/**
	 * 获取上一个月 日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastMonth(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(Calendar.MONTH, -1);
		return gc.getTime();
	}

	/**
	 * 获取上一个月初(上月首日)
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastMonthFirst(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(Calendar.MONTH, -1);
		gc.set(Calendar.DAY_OF_MONTH, 1);
		return gc.getTime();
	}

	/**
	 * 获取上一个月末(上月末日)
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastMonthEnd(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(Calendar.MONTH, -1);
		gc.set(Calendar.DAY_OF_MONTH, 1);
		return monthEndDate(gc.getTime());
	}
}