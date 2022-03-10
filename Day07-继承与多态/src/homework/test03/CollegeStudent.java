package homework.test03;

import java.util.Calendar;
import java.util.Date;

public class CollegeStudent extends Student {
	private String time;

	public CollegeStudent() {
		Date fd = TimeUtil.setTime(super.time, "yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fd);
		calendar.set(Calendar.MONTH, Calendar.MONTH + 10);
		time = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + 1 + "-" + calendar.get(Calendar.DAY_OF_MONTH);
	}

	@Override
	public void seeTime() {
		System.out.println(super.time);
		System.out.println(time);
	}
}
