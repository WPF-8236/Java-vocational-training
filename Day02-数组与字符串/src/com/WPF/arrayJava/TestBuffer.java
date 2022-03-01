package com.WPF.arrayJava;

public class TestBuffer {

	public static void main(String[] args) {
		//   是String 的增强版; 是可变的字符串序列 ;
		StringBuffer strbuf1 = new StringBuffer("hello");
		StringBuffer strbuf2 = strbuf1;

		strbuf2.append(",java");

		System.out.println(strbuf2 == strbuf1);

		System.out.println("------------------------------------");
		
		StringBuilder str1 = new StringBuilder("java");
		StringBuilder str2 = str1;

		str2.append("!!!!!");

		System.out.println(str1 == str2);

	}

}
