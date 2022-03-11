public class User {
	private String u_id;
	private String u_password;
	private String u_name;
	private String gender;
	private Integer age;
	private Double money;

	public User() {
	}

	public User(String u_id, String u_password, String u_name, String gender, Integer age, Double money) {
		this.u_id = u_id;
		this.u_password = u_password;
		this.u_name = u_name;
		this.gender = gender;
		this.age = age;
		this.money = money;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "User{" +
				"u_id='" + u_id + '\'' +
				", u_password='" + u_password + '\'' +
				", u_name='" + u_name + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				", money=" + money +
				'}';
	}
}
