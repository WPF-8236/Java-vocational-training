package homework.test02;

public class Test {
	public static void main(String[] args) {
		Animal animal=new Animal();
		Animal cat = new Cat("猫");
		Animal dog = new Dog("狗");

		animal.call();
		cat.call();
		dog.call();
	}
}
