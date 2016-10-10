package calendar;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DOBM {

	private static int year;
	private static int month;
	private static int day;
	private static Date time;

	public static Date getTime() {
		return time;
	}

	public static void setTime(Date time) {
		DOBM.time = time;
	}

	public static String presentDate() {

		GregorianCalendar cal = new GregorianCalendar();
		Date date = cal.getTime();
		time = cal.getTime();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DAY_OF_MONTH);
		 DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT);
		//DateFormat df1 = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT);
		String dateformat = df1.format(date);
		// System.out.println(date);
		return dateformat;

	}

	public static int getYear() {
		return year;
	}

	public static void setYear(int year) {
		DOBM.year = year;
	}

	public static int getMonth() {
		return month;
	}

	public static void setMonth(int month) {
		DOBM.month = month;
	}

	public static int getDay() {
		return day;
	}

	public static void setDay(int day) {
		DOBM.day = day;
	}

}
