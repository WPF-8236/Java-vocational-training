package com.WPF.baseJava;

import java.util.Scanner;

public class Day01Home {
	// 从屏幕上输入两个实数，计算他们的和，差，积，然后输出
	public void one() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入第一个数:");
		float f1 = input.nextFloat();
		System.out.println("请输入第二个数:");
		float f2 = input.nextFloat();

		System.out.println("和是:"+(f1+f2));
		System.out.println("差是:"+(f1-f2));
		System.out.println("积是:"+(f1*f2));
	}

	// 用户从屏幕上输入圆的半径，然后打印出该圆的直径、周长和面积。
	//注意：∏的值可以使用预定义常量Math.PI。该常量要比3.14159精确
	public void two() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入圆的半径:");
		float f = input.nextFloat();

		System.out.println("直径是:"+(f*2));
		System.out.println("周长是:"+(2*f*Math.PI));
		System.out.println("面积是:"+(Math.PI*f*f));
	}

	// 编写一个应用程序，读取用户输入的一个整数，判断该整数的奇偶性，        	并将结果显示在控制台上。提示：使用求模运算符。
	//可以循环输入判断，当输入0时退出程序
	public void three() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个数:");
		int a = input.nextInt();
		if(a%2 == 0) {
			System.out.println("该数是偶数");
		}else {
			System.out.println("该数是奇数");
		}
	}

	// 写出乘法口诀表
	public void four() {
		// 第一层循环控制行数的输出
		for(int i=1; i<=9; i++) {
			// 第二层循环,控制列数的输出
			for(int j=1; j<=i; j++) {
				System.out.print(j+" * "+i+" = "+(i*j)+"\t");
			}
			// 当里面的循环走完,说明列输了结束
			System.out.println();

		}
	}
	//5:编写一个程序，输入一个任意位数的整数，将输入数分离成单个数字，然后打印出这些数字，个数字间间隔3个*符号。
	//提示：使用整除除法和求模运算符。   例如：如果用户输入：42933,	那么输出是：	4***2***9***3***3
	public void five(String num) {
		int[] arr = new int[num.length()];
		int n = Integer.parseInt(num);

		int x = 10;
		int y = 1;

		for(int i=0; i<arr.length; i++) {
			arr[i] = n % x  / y ;
			x*=10;
			y*=10;
		}

		for(int i=arr.length-1; i>=0; i--) {
			if(i ==0) {

				System.out.print(arr[i]);
			}else {
				System.out.print(arr[i]+"***");
			}
		}
	}

	public void five2(String num) {
		char[] arr = num.toCharArray();

		for(int i=0; i<arr.length; i++) {
			if(i == arr.length-1) {
				System.out.print(arr[i]);
			}else {
				System.out.print(arr[i]+"***");

			}
		}
	}


	public static void main(String[] args) {
		Day01Home d = new Day01Home();

		//d.one();
		//d.two();
		//d.three();
		//d.four();
		//d.five2("6289043");

		double a = 5.459999999;
		String num = String.format("%.2f", a);
		System.out.println(num);
	}
}
