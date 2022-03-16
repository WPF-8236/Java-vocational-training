package 设计模式;

public class TestGender {
	public static void main(String[] args) {
		System.out.println(Gender.FEMALE);
		System.out.println(Gender.MALE);


		//根据枚举对象,得到名字和索引
		Sex male = Sex.MALE;
		Sex female = Sex.FEMALE;

		String name = male.name();
		System.out.println("枚举的名字：" + name);

		//得到枚举成员的索引（序号）
		int ordinal = female.ordinal();
		System.out.println(ordinal);


		//根据名字得到枚举对象
		Sex sex = Sex.valueOf("FEMALE");
		System.out.println(sex);

		//根据索引得到枚举对象
		Sex sex1 = Sex.values()[1];
		System.out.println(sex1);

	}
}
