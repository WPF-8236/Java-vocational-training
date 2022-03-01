package com.WPF.arrayJava;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class TestString3 {

	public static void main(String[] args) {
		/*String str = "hello";
		String str2 = new String("hello");
		
		char[] arr = {'j','a','v','a'};
		
		String str3 = new String(arr);
		System.out.println(str3);
		
		String str4 = String.valueOf(arr);
		System.out.println(str4);
		*/
		/*
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一句话");
		String str = input.next();
		System.out.println("你输入的是:"+str+";  长度是:"+str.length());
		*/
		
		/*String name = "小明";
		String password = "xiaoming";
		Scanner input = new Scanner(System.in);
		*/
		
		/*while(true) {
			System.out.println("欢迎使用XX系统");
			System.out.println("1: 登录     2: 退出");
			String op = input.next();
			
			if("1".equals(op)) {
				System.out.println("请输入用户名:");
				String userName = input.next();
				System.out.println("请输入密码");
				String userPass = input.next();
				if(userName.equals(name) && userPass.equals(password)) {
					System.out.println("---登录成功---");
				}else {
					System.out.println("--用户名或密码错误--");
				}
				
			}else if("2".equals(op)) {
				break;
			}
		}
		*/
		/*
		String mail = "123123qq.com";
		if(mail.indexOf("@") >0 && mail.indexOf(".")>0) {
			System.out.println("------mail  ok------");
		}else {
			System.out.println("------mail  error------");
		}
		*/
		String str = "    hello,      ";
		str = str.trim();
		str += "小鱼儿和花无缺!";
		
		System.out.println(str.substring(6, 9));
		System.out.println("---end---");
		
	}

}












