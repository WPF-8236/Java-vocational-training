package com.WPF.arrayJava;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Day02Home {
	//输入一句话，取反输出，按以下两种方式。
	//例如：输入的是hello java，输出为java hello、avaj olleh。
	public void one() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一句话:");
		String str = input.nextLine();
		
		String[] arr = str.split(" ");
		for(int i=arr.length-1; i>=0; i--) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		char[] arr2 = str.toCharArray();
		for(int i=arr2.length-1; i>=0; i--) {
			System.out.print(arr2[i]);
		}
	}
	/*
	 
		写一个public String replace(String str, char oldChar, char newChar) 
		方法实现String类里replace(char oldchar, char newchar)方法类似功能; 
	  
	 * */
	public String replace(String str, char oldChar, char newChar) {
		char[] arr = str.toCharArray();
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == oldChar) {
				arr[i] = newChar;
			}
		}
		return String.valueOf(arr);
	}
	/*
	数组的复制(自己写一个方法实现系统的arraycopy()方法的功能)
		int[] arrone = new int[]{1,2,3,4};//源数组
		int[] arrtwo = new int[]{21,22,23,24,25,26,27};//目标数组
	*/
	public void mycopy(int[] one, int x, int[] two, int y, int z) {
		
		for(int i=0; i<z; i++) {
			two[y] = one[x];
			y++;
			x++;
		}
	}
	

	public static void main(String[] args) {
		Day02Home d = new Day02Home();
		//d.one();
		
		/*String str = "hello,java";
		//String r = str.replace('a', 'x');
		String r = d.replace(str, 'a', 'x');
		System.out.println(r);*/
		
		int[] arrone = new int[]{1,2,3,4};//源数组
		int[] arrtwo = new int[]{21,22,23,24,25,26,27};//目标数组
		
		System.arraycopy(arrone, 1, arrtwo, 2, 2);
		
		for(int i: arrtwo) {
			System.out.print(i+" , ");
		}
		System.out.println();
		int[] one = new int[]{1,2,3,4};//源数组
		int[] two = new int[]{21,22,23,24,25,26,27};//目标数组
		d.mycopy(one, 1, two, 2, 2);
		for(int i: two) {
			System.out.print(i+" * ");
		}
	}

}
