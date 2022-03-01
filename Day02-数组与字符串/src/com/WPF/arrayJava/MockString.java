package com.WPF.arrayJava;

import java.util.Scanner;

public class MockString {
	public void Test01() {
		String user = null;
		String password = null;
		do {
			System.out.print("请输入用户名:>");
			user = new Scanner(System.in).nextLine();
			if ("exit".equals(user))
				break;
			System.out.print("请输入密码:>");
			password = new Scanner(System.in).nextLine();
			if ("jack".equals(user) && "love rose".equals(password))
				System.out.println("登陆成功");
			else
				System.out.println("登录失败");
		} while (!"exit".equals(user));
	}

	public void Test02() {
		String password1 = null;
		String password2 = null;
		System.out.println("---欢迎进入学员注册系统---");
		do {
			System.out.print("请输入你的密码:>");
			password1 = new Scanner(System.in).nextLine();
			if ("exit".equals(password1))
				break;
			System.out.print("请确认你的密码:>");
			password2 = new Scanner(System.in).nextLine();
			if (password1 == null || password2 == null) {
				System.out.println("两次密码中有未输入,注册失败!!重新输入!!");
				continue;
			} else if (!password1.equals(password2))
				System.out.println("密码输入不同,注册失败!!重新输入!!");
			else
				System.out.println("注册成功");
		} while (!"exit".equals(password1));
	}

	public void Test03(){
		String word = "Hello,      ";
		word = word.trim();
		String s = word.concat("小鱼儿!");
		System.out.println(s.substring(s.indexOf("小"),s.indexOf("!")));

	}

	public static void main(String[] args) {
		new MockString().Test01();
		new MockString().Test02();
		new MockString().Test03();
	}
}
