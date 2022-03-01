package com.WPF.arrayJava;

public class TestString2 {

	public static void main(String[] args) {
		String str = "hello,java";
		//String newStr = str.concat("---------");
		//str = str+"------"; // + 号除了是运算符,也可以是连接符; 字符吕与任何数相加,都把它变成字符串
		//boolean b = true;
		//str = str+b;
		//char c = str.charAt(0); // 返回指定索引处的 char 值
		//System.out.println(str.endsWith("xe")); // 返回的是boolean
		
//		int i = str.indexOf("a");
	/*	int i = str.lastIndexOf("a");
		System.out.println(i);
		System.out.println(str.isEmpty());
		System.out.println(str.length());
		
		String newStr = str.replace('a', 'x');
		System.out.println(newStr);
		
		String[] arr = str.split(",");
		for (String s : arr) {
			System.out.print(s+"      ");
		}
		*/
		
		String newStr = str.substring(6);
		System.out.println(newStr);
		
		String substring = str.substring(4, 7);
		System.out.println(substring);
		
		char[] arr = str.toCharArray();
		for(char c: arr) {
			System.out.print(c+" , ");
		}
		System.out.println("---------------------");
		String str2 = String.valueOf(arr);
		System.out.println(str2);
		
	}

}
