package com.WPF.arrayJava;

import java.util.Scanner;

public class HomeWork {
	/*输入一句话，取反输出，按以下两种方式。
	例如：输入的是hello java，输出为java hello、avaj olleh。

	写一个方法,用来排序自定义数组  (int型数组) 从大到小

	写一个public String replace(String str, char oldChar, char newChar)
	方法实现String类里replace(char oldchar, char newchar)方法类似功能;

	数组的复制(自己写一个方法实现系统的arraycopy()方法的功能)
	int[] arrone = new int[]{1,2,3,4};//源数组
	int[] arrtwo = new int[]{21,22,23,24,25,26,27};//目标数组
System.arraycopy(arrone, 0, arrtwo, 2, 3);*/

	public static void myReversion() {
		StringBuffer str = new StringBuffer(new Scanner(System.in).nextLine());
		System.out.println(str + "、" + str.reverse());
	}

	public static void mySort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static String myReplace(String str, char oldChar, char newChar) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (oldChar == chars[i])
				chars[i] = newChar;
		}
		return new String(chars);
	}

	public static void myArrayCopy(int[] arrone, int oneIndex, int[] arrtwo, int twoIndex, int lenth) {
		for (int i = 0; i < lenth; i++) {
			arrtwo[twoIndex] = arrone[oneIndex];
			twoIndex++;
			oneIndex++;
		}
	}

	public static void main(String[] args) {
		HomeWork.myReversion();
		System.out.println("--------------");
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		HomeWork.mySort(arr);
		for (int i :
				arr) {
			System.out.println(i);
		}
		System.out.println("--------------");
		String str = HomeWork.myReplace("holle,java", 'a', 'v');
		System.out.println(str);
		System.out.println("--------------");
		int[] arr2 = {11, 12, 13, 14, 15, 16, 17, 18, 19};
		HomeWork.myArrayCopy(arr, 3, arr2, 5, 3);
		for (int i :
				arr2) {
			System.out.println(i);
		}
	}

}
