package homework.test03;

public class BaWPrinter extends Printer {
	@Override
	public void print(Introduce introduce) {
		System.out.println("黑白打印机");
		System.out.println(introduce.detail());
	}
}
