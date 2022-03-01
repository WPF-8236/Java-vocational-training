package com.WPF.baseJava;

public class TestTwo {
	public static void main(String[] args) {
		//标识符
		int a = 200;    //    =   号是赋值符号
		int b = 2;

		//运算符 + - * /
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);

		//逻辑运算符 > < >= <= == != & && | ||
		System.out.println(a > b);
		System.out.println(a < b);
		System.out.println(a >= b);
		System.out.println(a <= b);
		System.out.println(a == b);
		System.out.println(a != b);

		//位运算符 <<左移 >>右移
		int x = a << 1;
		System.out.println(x);
		int y = a >> 1;
		System.out.println(y);

		int aa = 3;
		int bb = 11;
		//位运算 & 与
		System.out.println(aa & bb);
		//^ 异或
		System.out.println(aa ^ bb);
		//| 按位与
		System.out.println(aa | bb);
		//~按位取反
		System.out.println(~bb);
		//三目运算
		char c = aa < bb ? '真' : '假';
		System.out.println(c);
	}
}
