package 设计模式;

//单例模式
public class SuperMan {
	//	private static SuperMan superMan; 懒汉式
//	private static SuperMan superMan = new SuperMan();//饿汉式
	private static SuperMan superMan;//静态内部类
	private String name;
	private String gender;
	private int age;

	private SuperMan() {
	}

	public void fly() {
		System.out.println("超人可以飞");
	}


	private static class Inner {

		static final SuperMan superMan = new SuperMan();
	}

	public static SuperMan getSuperMan() {
		/*懒汉式--有线程安全问题
		if (superMan == null) {
			superMan = new SuperMan();
		}*/
//		return superMan;
		return Inner.superMan;//静态内部类
	}

}
