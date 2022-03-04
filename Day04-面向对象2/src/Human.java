public class Human {
	
	private String name;
	private int age;
	
	{
		System.out.println("--普通代码块--");
	}
	static {
		System.out.println("---静态代码块---");
	}
	
	public Human() {
		System.out.println("-- 无参的构造方法  --");
	}
	
	
	public Human(String name, int age) {
		super();
		System.out.println("name: "+this.name);
		this.name = name;
		this.age = age;
		System.out.println("-- 两个参数据的构造方法  --");
	}
	
	public static void testStatic() {
		// testNoraml();
		System.out.println("--这是静态方法--");
	}
	public void testNormal() {
		testStatic();
		System.out.println("--这是普通方法---");
	}


	public void breath() {
		System.out.println(name +"要呼吸 ---");
	}
	
	// 依赖关系
	public void run(Car car) {
		//System.out.println("--- 人类会跑步 ---");
		car.drive();
	}
	
	
// ---------get  set------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + "]";
	}


	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("----human 垃圾回收运行了 ----");
	}
	
}
