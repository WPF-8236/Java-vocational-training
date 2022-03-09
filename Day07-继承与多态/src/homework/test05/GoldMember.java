package homework.test05;

public class GoldMember extends User {
	public static final double member = 0.8;
	public static final String member_name = "金卡会员";

	public GoldMember(String id, String password, String name, Integer age, String gender, double money) {
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
