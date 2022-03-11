package 抽象类;

public class TestHuman {
	public static void main(String[] args) {
		Human h1 = new Man();
		Human h2 = new Woman();

		h1.breath();
		h2.breath();

//		Human human = new Human();
	}
}
