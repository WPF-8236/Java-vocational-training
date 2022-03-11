package homework.test03;

public class Test {
	public static void main(String[] args) {
		Center center = new Center();
		Teacher teacher = new Teacher("王五");
		center.print(center, new ColorPrinter());
		center.print(teacher, new BaWPrinter());

	}
}
