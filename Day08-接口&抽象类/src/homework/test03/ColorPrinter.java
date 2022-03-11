package homework.test03;

public class ColorPrinter extends Printer {
	@Override
	public void print(Introduce introduce) {
		System.out.println("彩色打印机");
		System.out.println(introduce.detail());
	}
}
