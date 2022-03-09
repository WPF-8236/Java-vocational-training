package homework.test05;

public class OrdinaryMember extends User {
	public static final double member = 1.0;
	public static final String member_name = "普通会员";

	public OrdinaryMember(String id, String password, String name, Integer age, String gender, double money) {
		super(id, password, name, age, gender, money);
	}

	public double getMember() {
		return member;
	}

	@Override
	public String toString() {
		return member_name + "{" +
				"id='" + id + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				", money=" + money +
				"} ";
	}
}
