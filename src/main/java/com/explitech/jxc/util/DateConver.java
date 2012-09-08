
package com.explitech.jxc.util;

import java.util.*;
import java.text.*;

public class DateConver {
	/**
	 * @return  MM/dd/yyyy HH:mm:ss
	 */
	public static Date getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
	 * @return  MM/dd/yyyy
	 */
	public static Date getNowDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
	 * @return  MM/dd/yyyy HH:mm:ss
	 */
	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * @return MM/dd/yyyy
	 */
	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * HH:mm:ss
	 * @return
	 */
	public static String getTimeShort() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 *  MM/dd/yyyy HH:mm:ss
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 *  MM/dd/yyyy HH:mm:ss
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong(java.util.Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 *   MM/dd/yyyy
	 * 
	 * @param dateDate
	 * @param k
	 * @return
	 */
	public static String dateToStr(java.util.Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * MM/dd/yyyy
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * @return
	 */
	public static Date getNow() {
		Date currentTime = new Date();
		return currentTime;
	}
 

	/**
	 * @return  MM/dd/yyyy HHmmss
	 */
	public static String getStringToday() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
 
}