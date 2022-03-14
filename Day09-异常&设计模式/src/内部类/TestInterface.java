package 内部类;

public class TestInterface {
	public static void main(String[] args) {
		OuterInterface.outStaticMethod();
		OuterInterface.InnerInterface.innnerStaticMethod();

		TestOuterInterface testOuterInterface = new TestOuterInterface();
		testOuterInterface.outInterfaceMethod();

		//实现类对象不可以调用接口的静态方法

		TestInnerInterface testInnerInterface = new TestInnerInterface();
		testInnerInterface.innnerMethod();
	}
}
