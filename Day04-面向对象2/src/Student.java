// static 关键字:
public class Student {
	// 学生的属性

	// static关键字修饰的属性和方法 --> 直属于类, 可以直接以类名调用
	// 静态属性: 全局属性(所有的对象共用一个属性)
	// 静态方法: 
	// static 可以修饰代码块
	// static 还可以修饰内部类
	public final static String SCHOOLNAME ="一中"; 
	
	// final修饰的属性是常量(常量不可变); 一般情况下,常量大写; 一般都设成public static final
	public String name;
	int age;
	char gender;
	
	{
		System.out.println("--- 这是代码块");
	}
	static {
		System.out.println("--- 这是静态代码块----");
	}
	
	public Student() {
	}
	
	public Student(String name) {
		super();
		
	}

	public Student(String name, int age, char gender) {
		super();
		this.age = age;
		this.gender = gender;
	}

// 在静态修饰符内部, 不可以直接出现非静的东西
	public static void study() {
		System.out.println(/*name+*/", 在学习 ----");
	}
	// 静态方法,直接以类名调用
	public static void run() {
		System.out.println("--- 静态的跑步的方法 ---");
	}
	
	// final修饰的方法,不可以被重写
	public final void eating() {
		System.out.println("--- 学生吃东西 ----");
	}
	
	

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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [schoolName=" + SCHOOLNAME + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
// --- 静态的内部类 ----
	static class Inner{
		String innerName;
		public void test() {
			System.out.println("---");
		}
	}

}
