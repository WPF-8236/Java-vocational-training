package 内部类;

public class Outer {
	private static String name;
	private int age;

	//普通内部类
	class Inner {
		private String innerName;

		public void seeOut() {
			System.out.println("-- 外部类的属性：" + name);
		}
	}

	//静态内部类
	static class Inner2 {
		public void seeOut() {
			System.out.println("-- 静态内部类，访问外部资源：" + name);
		}
	}

	//局部内部类
	public void test() {
		class Inner3 {
			String name;

			public void seeOut() {
				System.out.println("--- test ----");
			}
		}

		Inner3 inner3 = new Inner3();
		inner3.seeOut();
	}
}
