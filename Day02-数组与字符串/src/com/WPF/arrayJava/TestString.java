package com.WPF.arrayJava;

public class TestString {

	public static void main(String[] args) {
		// java里的数据类型: 
		//1:基本数据类型(八大)     
		//2:引用数据类型(数组类型, 接口, 自定义类...)
		int a = 0;
		float b = 0.0f;
		boolean f = false;
		char c = '\u0000';
		
		// 字符串(最大特性: 不可变 )  ; 用双引号引起来的一串字符   
		String str = "hello";  // null 代表没有引用
		String str3 = "hello";
		
		String str2 = new String("hello");
		String str4 = new String("hello");
		
//		System.out.println(str == str2);  // == 在引用数据类型进行判断的时候,比的是内存地址
//		System.out.println(str == str3);
//		System.out.println(str2 == str4);
//		// 比较字符串的值用equals()方法
//		System.out.println(str.equals(str4));
		
		str3 = str3+",java";
		System.out.println(str3);
		System.out.println(str);

	}

}
