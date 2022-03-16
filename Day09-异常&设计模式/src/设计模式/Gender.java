package 设计模式;

/*
	多例实现条件:
	1.构造方法私有化
	2.指定几个,本类对象为属性
	3.多例的属性就是本类对象的匿名内部类对象

	枚举类:
		本质与多例一样,jdk1.5之前用多例之后用枚举
 */

//多例模式---固定几个
public abstract class Gender {

	public static final Gender MALE = new Gender("男") {
		@Override
		public void action() {
			System.out.println("--- 男性强壮,爱运动 ---");
		}
	};
	public static final Gender FEMALE = new Gender("女") {
		@Override
		public void action() {
			System.out.println("--- 女性娇弱 ---");
		}
	};

	private String value;

	private Gender(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public abstract void action();

	@Override
	public String toString() {
		return "Gender{" +
				"value='" + value + '\'' +
				'}';
	}
}
