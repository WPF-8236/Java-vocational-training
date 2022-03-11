package 抽象类;

/*
	1.抽象类是天然的父类
	2.一个类继承另一个抽象类时，必须重写抽象类的抽象方法
	3.属性和普通类的一样
	4.抽象类可以有抽象方法，也可以没有
	5.抽象类有构造方法，但不能new对象,他是给子类new对象时使用
	6.抽象类可以继承另一个类
	7.抽象类可以实现接口，而不重写接口的抽象方法，交由子类重写，也可以重写接口的抽象方法

	final和static 不能与abstract共存

 */
public abstract class Human {
	String id;
	String name;
	Integer age;
	String gender;


	public Human() {
		System.out.println("--- Human 的构造方法 ----");
	}

	public void eating() {
		System.out.println("--- 人类要吃饭 ---");
	}

	public abstract void breath();
}
