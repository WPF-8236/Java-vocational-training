package com.WPF.baseJava;

import java.util.Scanner;

public class TestSix {
	public static void main(String[] args) {
		// 创建一个Scanner对象; 因为我们要使用它里面的方法
		Scanner in = new Scanner(System.in);

		System.out.println("请输入第一个数:");
		int one = in.nextInt();
		System.out.println("请输入第二个数");
		int two = in.nextInt();
		System.out.println(one+"   "+two);

		System.out.println("请输入:");
		//String str = in.next();
		String str = in.nextLine();
		System.out.println(str);
	}
}
