package com.WPF.arrayJava;

import java.util.Arrays;

public class TestArray4 {

	public static void main(String[] args) {
		int[] arr = {32,11,5,78,99,100,2,9,102};
		
		// 得到数组里的最大值
/*		int max = 0;
		for(int i=0; i<arr.length; i++) {
			// 如果你比我大,那么,我就把你的值拿过来
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(max);*/
		
		// 数组的排序
		/*Arrays.sort(arr);
		for(int i:arr) {
			System.out.print(i+"\t");
		}*/
		
		// 自定义排序
		/*
		int a = 1;
		int b = 999;
		// 值交换,应该有个第三方变量
		int temp = a;
		a = b;
		b = temp;
		*/
		int temp = 0;
		// 第一个循环,取每一个位置的值
		for(int i=0; i<arr.length; i++) {
			// 第二个循环,把取得的值,和后面的每一个位置进行比较
			for(int j=i+1; j<arr.length;j++) {
				// 如果我比你大,那么我和你交换位置 
				if(arr[i] < arr[j]) {
					// 值交换
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int i:arr) {
			System.out.print(i+"  ,  ");
		}
		
		
	}

}







