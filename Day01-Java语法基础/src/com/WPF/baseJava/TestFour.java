package com.WPF.baseJava;

public class TestFour {
	public static void main(String[] args) {
		// switch(){}
		int a = 100;
		int b = 2;

		String mark = "a";

		switch (mark) {
			case "+":
				System.out.println(a + b);
				break;
			case "-":
				System.out.println(a - b);
				break;
			case "*":
				System.out.println(a * b);
				break;
			case "/":
				System.out.println(a / b);
				break;
			default:
				System.out.println("--运算符错误--");
		}

		// 重复出现的代码,如何处理 ;   用循环
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				//continue;  // 跳过当次循环
				break;       // 结束当前循环
			}
			System.out.println(i);
		}
		// 打印出1 -- 100 所有的10的倍数
		for (int i = 1; i <= 100; i++) {
			if (i % 10 == 0) {
				System.out.println(i);
			}
		}

		// -- 当我们不能明确知道循环的次数时,用while
		// while(){}
		int i = 10;
		while (i < 10) {
			i++;
			/*if(i==5) {
				//continue;
				break;
			}*/
			System.out.println(i);
		}
		System.out.println("--------------------");
		int j = 10;
		do {
			j++;
			System.out.println(j + " === ");
		} while (j < 10);

		// while() 是先判断,再执行 ;   do{} while(); 至少执行一次

	}
}
