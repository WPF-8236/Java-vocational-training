package com.skeyedu.day04obj;

public class TestHuman {
	// 初始化的顺序
	/*
	 *  先申明,后赋值
	 * 	先属性,后方法
	 *  先静态,后非静态
	 *  先父类,后子类
	 * 
	 * */

	public static void main(String[] args) {
		
		Human human1 = new Human("jack",22);
		Human human2 = new Human("rose",22);
		Human human3 = new Human("tom",22);
		
		human1 = null;
		human2 = null;
		
		System.gc(); // 相当于一个通知,告诉jvm垃圾回收器,要回收了. 具体什么时候执行,由jvm自己控制.
		
		
		
		
	}

}
