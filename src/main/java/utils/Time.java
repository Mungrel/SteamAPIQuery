package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

	public static String unixToNormalTime(long unixTime) {
		Date date = new Date(unixTime * 1000);
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss a");
		return sdf.format(date);
	}

}
