package com.WPF.arrayJava;

public class TestArray2 {

	public static void main(String[] args) {
		//int[] arr = new int[6];    //动态初始化
		
		//int arr[] = {1,2,3,4,5,6,7}; //静态初始化
//		int[] arr = new int[] {11,22,33,44,55,66,77};
//		
//		for(int i=0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		// -- 二维数组的定义
		//int[][] arr = new int[3][4];
		//arr[1][2] = 12;
		
		int[][] arr = { {11,12,13},{22,33,44,55,66},{333,444,555,666,777,888}};
		
		//System.out.println(arr[1][2]);
		// 二维数组的遍历
		
		// 第一个循环取每一层的值
		for(int i=0; i<arr.length; i++) {
			// 第二个循环,取每一个列的值
			for(int j=0; j< arr[i].length ; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("=======================");
		
		for (int[] is : arr) {
			for (int i : is) {
				System.out.print(i+"\t");
			}
			System.out.println();
		}
		
	}

}
