import java.io.IOException;
import java.util.Locale;

public class TestTwo {
	public static String input() {
		byte[] bytes = new byte[50];
		try {
			//用try包住，可能出现的异常
			System.in.read(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(bytes).trim();
	}

	public static void checkStr(String str) throws MyException/*声明异常，告诉本方法的调用者，我这个方法是有异常的*/ {
		if (str.toLowerCase(Locale.ROOT).contains("sb"))
			//抛出异常
//			throw new MyException();
			throw new MyException("我们应该文明用语");
	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("你说:>");
			String s = input();
			//对得到的s字符串，进行检测，没有问题才输出
			try {
				checkStr(s);
				if ("exit".equalsIgnoreCase(s)) {
					break;
				}
				System.out.println("你说的话: " + s);

			} catch (MyException e) {
//				System.out.println("请文明用语");
				System.out.println(e.getMessage());
			}

		}
	}
}
