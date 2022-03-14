package homework.test01;

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
		int arr[] = new int[10];
		for (int i = 0; i < 10; ) {
			System.out.print("请输入第" + i + "号位置的数字:>");
			try {
				arr[i] = Integer.parseInt(input());
				i++;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("你输入的不是数字");
			}
		}

		while (true) {
			System.out.println("=== 1.按照索引查找 = 2.按照值查找 = 0.退出 ===");
			System.out.print("输入菜单编号:>");
			String menuIndex = input();
			if ("1".equals(menuIndex)) {
				try {
					System.out.print("输入查询的索引值:>");
					int i = Integer.parseInt(input());
					System.out.println("你要查找的数组对象:>" + arr[i]);
				} catch (ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
					System.out.println("下标超过数组大小");
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println("你输入的不是数字");
				}
			} else if ("2".equals(menuIndex)) {
				try {
					System.out.print("输入查询的值:>");
					int i = Integer.parseInt(input());
					System.out.println("你找的元素的下标为:>" + findArrayByValue(i, arr));
				} catch (NumberNotFoundException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println("你输入的不是数字");
				}
			} else if ("0".equals(menuIndex)) {
				break;
			} else {
				System.out.println("输入错误");
			}
		}
	}

	public static int findArrayByValue(int i, int[] arr) throws NumberNotFoundException {
		if (i < 0)
			throw new NumberNotFoundException("数字不能小于0");
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == i)
				return j;
		}
		throw new NumberNotFoundException("数字不存在");
	}
}
