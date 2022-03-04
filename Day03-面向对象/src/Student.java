public class Student {

	private String s_id;        //学生学号
	private String s_name;      //学生姓名
	private String s_gender;    //学生性别
	private String s_age;       //学生年龄

	/**
	 * 构造方法
	 */
	public Student() {
	}

	/**
	 * 构造方法
	 *
	 * @param s_id     学生学号
	 * @param s_name   学生姓名
	 * @param s_gender 学生性别
	 * @param s_age    学生年龄
	 */
	public Student(String s_id, String s_name, String s_gender, String s_age) {
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_gender = s_gender;
		this.s_age = s_age;
	}

	/**
	 * get,set方法
	 *
	 * @return
	 */
	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_gender() {
		return s_gender;
	}

	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}

	public String getS_age() {
		return s_age;
	}

	public void setS_age(String s_age) {
		this.s_age = s_age;
	}

	/**
	 * 学习方法
	 */
	public void study() {
		System.out.println(s_name + "在学习");
	}

	@Override
	public String toString() {
		return "Student{" +
				"s_id='" + s_id + '\'' +
				", s_name='" + s_name + '\'' +
				", s_gender='" + s_gender + '\'' +
				", s_age='" + s_age + '\'' +
				'}';
	}
}
