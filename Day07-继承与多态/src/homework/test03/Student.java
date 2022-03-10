package homework.test03;

import java.util.Date;

public class Student {
	protected String name;
	protected String time;

	public Student() {
		time = TimeUtil.getTime("yyyy-MM-dd");
	}

	public void seeTime() {
		System.out.println(time);
	}

}
