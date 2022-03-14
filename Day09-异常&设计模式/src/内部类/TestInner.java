package 内部类;

public class TestInner {
	public static void main(String[] args) {

		//匿名内部类
		//这是有一个类去实现了Pci接口，只是我们不知道这个类的名字
		Pci pci = new Pci() {
			@Override
			public void run() {
				System.out.println("-- 启动 --");
			}

			@Override
			public void stop() {
				System.out.println("-- 关闭 --");
			}
		};

		pci.run();
		pci.stop();


		//普通内部类
		Outer.Inner inner = new Outer().new Inner();
		inner.seeOut();

		//静态内部类
		Outer.Inner2 inner2 = new Outer.Inner2();
		inner2.seeOut();


		/*内部类.One one = new 内部类.One() {
			@Override
			public String msg() {
				return "hello,one";
			}
		};*/

		One one = () -> "hello";
		one.msg();


	}
}
