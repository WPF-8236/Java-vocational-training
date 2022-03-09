package homework.test05;

public class DiamondMember extends User {
	public static final double member = 0.7;
	public static final String member_name = "钻石会员";

	public DiamondMember(String id, String password, String name, Integer age, String gender, double money) {
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
