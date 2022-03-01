package com.WPF.baseJava;

public class TestOne {
	public static void main(String[] args) {
		//Java中的变量相当于一个容器，用来存数据
		/*int a = 1000;
		a = (int) (a + a * 0.05);
		System.out.println(a);*/

		//Java里的数据类型:1.基础数据类型   2.引用数据类型
		//基本数据类型:八种
		byte a = 10;    //字节型,占一个字节,可以代表256个数
		System.out.println(Byte.MAX_VALUE);//127
		System.out.println(Byte.MIN_VALUE);//-128
		short b = 100;  //短整型,占两个字节,2^15-1 ~ -2^15
		System.out.println(Short.MAX_VALUE);//32767
		System.out.println(Short.MIN_VALUE);//-32768
		int c = 1000;   //整形占四个字节,-2^31 ~ 2^31-1
		long d = 222L;  //长整型占8个字节,-2^63 ~ 2^31-1

		float f = 5.5F; //小数(实数):占4个字节;单精度浮点型
		System.out.println(Float.MAX_VALUE);//3.4028235E38
		System.out.println(Float.MIN_VALUE);//1.4E-45
		//java中所有的小数默认时double,占8个字节;双精度浮点型
		double ff = 7.7;

		boolean g = true;   //布尔型 只有两个值:true false
		System.out.println(g);//true

		char h ='x';    //字符型(不是字符串)占两个字节
		System.out.println(h);

	}
}
