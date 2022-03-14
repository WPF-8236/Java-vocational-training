package 内部类;

/*
	接口：接口就是一个标准（规范）
		属性：默认是public static final（公共的静态的常量）

		方法：默认是public abstract（公共的抽象方法）
			以前的说法：接口中的方法都是抽象方法
			1.8之后，接口中可以有静态方法
			还可以有默认方法

		继承：接口与接口的继承是多继承，可以实现多态

		实现：一个类可以实现多个接口
 */
public interface Pci {
	/*
		接口里可以有属性

		接口中的方法是抽象方法，没有方法体
	 */
	/*public static final*/ String NAME = "PCI";

	//没有构造方法
	/*public 接口.内部类.Pci(){	}*/

	/*public abstract*/ void run();

	/*public abstract*/ void stop();

	public static void one() {
		System.out.println("----- test one -----");
	}

	public default void two() {
		System.out.println("----- test two -----");
	}
}
