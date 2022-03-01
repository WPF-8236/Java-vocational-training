package com.WPF.arrayJava;

public class TestPackage {

	public static void main(String[] args) {
		// 包装类,是对基本数据类型的封装;
		// 包装类: 是基本数据类型面向对象的表现形式;
		/*
		 *		byte      --->    Byte
		 *		short     --->    Short 
		 *		int       --->    Integer 
		 *		long      --->    Long 
		 *		float     --->    Float 
		 *		double    --->    Double 
		 *		boolean   --->    Boolean 
		 * 		char      --->    Character
		 * 
		 * 
		 * */
		byte a = 100;
		Byte a1 = new Byte(a);
	
		
		int b = 200;
		
		String num = "12345";
		int c = Integer.parseInt(num); // 包装类里面的方法
		System.out.println(c+"---------------");
		
		System.out.println(c-10000);
		
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);

	}

}
