package 抽象类;

//一个类继承另一个抽象类时，必须重写抽象类的抽象方法
public class Woman extends Human {
	public static final String GENDER = "female";

	@Override
	public void breath() {
		System.out.println("--- 女人呼吸 ---");
	}
}
