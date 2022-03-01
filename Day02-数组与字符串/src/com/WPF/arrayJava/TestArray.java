package com.WPF.arrayJava;

public class TestArray {
	public static void main(String[] args) {
		// 什么是数组
		// 1: 数组定长, 2:什么类型的数组里面放的是什么类型的数据
		// 整形变量的数组默认值都是 0
		//byte[] arr = new byte[5];
		//short[] arr = new short[4];
		//int[] arr = new int[6];

		// 浮点型的数组默认值都是: 0.0
		//float[] arr = new float[3];

		//boolean[] arr = new boolean[5]; // 默认值是false

		char[] arr = new char[5]; // 默认值是一个空格

		// 往数组里面放数据
//		arr[0] = 12;  // 数组的每一个位置,就相当于这个类型的变量
//		arr[1] = 2;
//		arr[3] = 4;
		// byte数组的每一个位置的默认值是0, 这个给默认值的过程叫 初始化;
		//System.out.println(arr[0]);
		//byte a = 0;
		//System.out.println(a);

		// 数组的遍历 : 就是把数组的每一个位置都访问一遍
		for (int i = 0; i < arr.length; i++) {
			System.out.println("----" + arr[i] + "----");
		}
		System.out.println("------------------");
		//-- 简单循环, 增强循环
//		for (boolean b : arr) {
//			System.out.println(b);
//		}

		char a = '\u0000'; // char的默认值
		System.out.println("---" + a + "---");

	}
}
