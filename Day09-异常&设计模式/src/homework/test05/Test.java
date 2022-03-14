package homework.test05;

import java.io.IOException;

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
		System.out.print("输入一串字符:>");
		String s = input();
		s = s.replace("sb", "*");
		System.out.println(s);
	}

}
