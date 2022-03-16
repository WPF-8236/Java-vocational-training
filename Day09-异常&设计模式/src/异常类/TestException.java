package 异常类;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
课堂练习：
1：由键盘输入一个int数组的长度
2：由键盘输入这个数组的值
3：处理所有异常。
 */
public class TestException {
	//标准输入
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


	public static void main(String[] args) {
		/*while (true) {
//			Scanner scanner = new Scanner(System.in);
			System.out.print("请输入:>");
			try {
				//这里运行是，可能出现问题，运行是异常
//				int i = scanner.nextInt();
				int i = Integer.parseInt(input());
				System.out.println("你输入的数字是:" + i);
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("对不起，只能输入整形");
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("对不起，只能输入整形");
			}
		}*/

		int arr[] = null;

		while (true) {
			try {
				System.out.println("请输入一个数组的长度:");
				String num = input();
				int len = Integer.parseInt(num);
				arr = new int[len];
				break;
			} catch (NumberFormatException e) {
				System.out.println("对不起，数组的长度只能是整数! ");
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println("请输入" + i + "位置的值:");
			try {
				arr[i] = Integer.parseInt(input());
			} catch (NumberFormatException e) {
				i--;
				System.out.println("对不起，本数组的值只能是整数! ");
			} finally {
				//通常用在关闭资源和释放资源的操作中
				System.out.println("无论代码是否异常都会执行的代码");
			}
		}
		for (int i : arr) {
			System.out.print(i + "\t");

		}
	}
}