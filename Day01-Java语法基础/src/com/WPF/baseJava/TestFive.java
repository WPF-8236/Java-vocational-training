package com.WPF.baseJava;

public class TestFive {
	// 1: 整数型之间的转换
	// 小范转的可以直接赋值给大范围的
	// 大范转的给小范转的,要强转, 可能会损失精度
	// 2: 实数(小数) 类型之间的转换
	// 小范转的可以直接赋值给大范围的
	// 大范转的给小范转的,要强转, 可能会损失精度
	// 3: 实数和整数之间的转换
	// 整形可以直接赋值给实数型
	// 实数型要强转才能变成整数型(强转后,小数点后全部去掉)
	// 4: 字符型与整数型之间的转换
	// 字符转int , long 可以直接的转, 转short 和 byte 要强转
	// byte short int long 转到char 都要强转
	// 常量赋值给char 不用强转
	// 5: 字符和实数型之间的转换
	// 字符型的值可以直接给到实数型变量
	// 实数型转到字符型,要强转, 可能损失精度
	// 6: 布尔型不可以转成其它类型

	public static void main(String[] args) {
		byte a = 3;
		byte b = 100;
		// java里整数默认都是int型
		byte c = (byte) (a + b); // 强转; 可能会损失精度
		System.out.println(c);
		int x = 128;
		byte y = (byte) x;
		System.out.println(y);
		x = a;
		System.out.println(x);


		float f = 5.5f;
		double d = 9.9; // java里所有的小数默认都是double型
		//f = (float) d;
		d = f;

		/*long c = 100L;
		float d = 5.999999f;
		//f = a;
		c = (long) d;
		System.out.println(c);

		char x = 'A';
		long y = 100L;
		x = 97;
		System.out.println(x);*/

		char q = 'b';
		float w = 66.999f;
		q = (char) w;

		System.out.println(q);
	}
}
