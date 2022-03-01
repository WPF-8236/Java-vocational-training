package com.WPF.arrayJava;

import java.util.Scanner;

public class TestMethod {
// 方法的重载
	
// 访问权限	返回值申明     方法名(){...}
	public void oneToTen() {
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
	}
//                      参数:形参(方法定义时写的参数,要写参数的类型)	
	public void oneToTen(int num) {
		for(int i=1; i<= num ; i++) {
			System.out.println(i);
		}
	}
	
	public void oneToTen(int x, int y) {
		for(int i=x; i<= y ; i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		// 方法: 就是能实现某种功能的代码集 
		//Scanner input = new Scanner(System.in);
		//String str = input.next();
		
		// ---------------------------------
		// 方法的调用: 用方法所在类的对象来调用
		TestMethod t = new TestMethod();
		
		// 使用方法时提供的参数: 实参: 不用写类型,只能提供相应的类型即可
		t.oneToTen(2,20);
		
		

	}

}
