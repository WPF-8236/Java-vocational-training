package homework.test02;

public class Test {
	public static void main(String[] args) {
		MyRectangle myRectangle = new MyRectangle(12, 12);
		MyCircle myCircle = new MyCircle(5);
		System.out.println(myCircle.calculateArea());
		System.out.println(myRectangle.calculateArea());
	}
}
