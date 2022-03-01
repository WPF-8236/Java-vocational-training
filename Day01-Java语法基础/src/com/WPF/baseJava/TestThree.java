package com.WPF.baseJava;

public class TestThree {
	public static void main(String[] args) {
		int a = 100;
		//流程控制 if(){...}
		if (a >= 0)
			System.out.println("a是正数");
		else
			System.out.println("a是负数");

		char gender = 'a';

		if (gender == '男') {
			System.out.println("--- 是个男的---");

		} else if (gender == '女') {
			System.out.println("--- 是个女的---");

		} else {
			System.out.println("-- 性别错误 ---");
		}

		if (gender == '女') {
			System.out.println("--是个女的--");
		}

		// 60-70 一般;  70-80良    80-90 优    90-100 非常好
		int score = 1590;

		if (score <= 100 && score > 90) {
			System.out.println("--非常好--");

		} else if (score <= 90 && score > 80) {
			System.out.println("--优--");

		} else if (score > 70) {
			System.out.println("--良--");

		} else if (score >= 60) {
			System.out.println("-- 一般 --");

		} else {
			System.out.println("-- 不及格 ---");
		}

		//   & 与  &&短路与     | 或   ||短路或
		// 短路与和短路或  : 特点, 当可以提前知道运算结果时, 后面的表达式不进行运算; 可以提高效率
		int c = 0;
		int d = 100;

		c = c + 1;
		System.out.println(++a); // a++ 先执行,后运算     ;  ++a先运算再执行

		if (++c > 10 & ++d > 200) {
			System.out.println("c:" + c + "    d:" + d);
		}
		if (++c > 0 || ++d > 200) {
			System.out.println("c:" + c + "    d:" + d);
		}

		// 三目运算可以看成是一个特殊的if语句
		char x = c > d ? '真' : '假';

	}
}
