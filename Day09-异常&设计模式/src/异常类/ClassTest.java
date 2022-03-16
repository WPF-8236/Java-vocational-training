package 异常类;

import java.io.IOException;
import java.util.InputMismatchException;

/*
课堂练习：
1：由键盘输入一个int数组的长度
2：由键盘输入这个数组的值
3：处理所有异常。
 */
public class ClassTest {
	public static String input() {
		byte[] bytes = new byte[50];
		try {
			System.in.read(bytes);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO异常");
		}
		return new String(bytes).trim();
	}

	public static void main(String[] args) {
		while (true) {
			try {
				System.out.print("输入一个数字确认数组长度:>");
				int i = Integer.parseInt(input());
				int[] ints = new int[i];
				System.out.print("输入这个数组(空格间隔)：>");
				String string = input();
				String[] strings = string.split(" ");
				for (int j = 0; j < i; j++)
					ints[j] = Integer.parseInt(strings[j]);
				for (int j = 0; j < i; j++) {
					System.out.println(ints[j]);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("输入非数字");
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				System.out.println("数组下标越界");
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.out.println("未输入有效值");
			}
		}
	}
}
