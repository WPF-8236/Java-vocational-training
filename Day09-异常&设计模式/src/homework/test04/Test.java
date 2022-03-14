package homework.test04;

import java.io.IOException;
import java.util.regex.Pattern;

public class Test {
	public static String input() {
		byte[] bytes = new byte[50];
		try {
			System.in.read(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(bytes).trim();
	}

	public static void main(String[] args) {
		try {
			System.out.print("输入一串字符:>");
			String s = input();
			checkString(s);
			System.out.println("你输入的是：>" + s);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void checkString(String args) throws Exception {
		if (args == null || "".equals(args.trim()))
			throw new InvalidInputException("是空串");
		if (Pattern.matches(".*\\d+.*", args))
			throw new IncludeNumberException("存在数字");
	}
}
