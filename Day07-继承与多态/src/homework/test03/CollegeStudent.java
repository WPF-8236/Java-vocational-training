package homework.test03;

import java.util.Date;

public class CollegeStudent extends Student {
	public Date graduationTime;

	public CollegeStudent() {
		this.graduationTime = new Date(super.graduationTime.getTime() + 2592000000L);
	}
}
