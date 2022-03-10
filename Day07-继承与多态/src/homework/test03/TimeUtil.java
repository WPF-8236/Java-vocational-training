package homework.test03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
	public static final String getTime(String pattern) {
		//获取时间
		Date date = new Date();
		//格式化时间
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	public static final Date setTime(String time, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			return simpleDateFormat.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

	}
}
