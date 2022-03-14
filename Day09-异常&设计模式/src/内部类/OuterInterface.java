package 内部类;

public interface OuterInterface {
	void outInterfaceMethod();

	//内部接口特点：默认静态的

	interface InnerInterface {
		void innnerMethod();

		public static void innnerStaticMethod() {
			System.out.println("内部接口的静态方法");
		}

	}

	public static void outStaticMethod() {
		System.out.println("内部接口的静态方法");
	}

}
