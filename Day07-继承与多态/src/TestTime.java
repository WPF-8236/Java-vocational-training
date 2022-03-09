import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestTime {
	public static String getTime(String pattern) {
		//获取时间
		Date date = new Date();
		//格式化时间
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	public static String getTime2() {
		Calendar calendar = Calendar.getInstance();
		int year= calendar.get(Calendar.YEAR);
		return null;
	}

	public static void main(String[] args) {

	}
}
