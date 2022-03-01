package com.WPF.arrayJava;

public class TestArray3 {

	public static void main(String[] args) {
		// 多维数组
		int[][][] arr = new int[3][3][3];
		// 第一个循环; 取每一层
		for(int i=0; i<arr.length; i++) {
			// 第二个循环; 取的是每一个条
			for(int j=0; j<arr[i].length; j++) {
				// 第三个循环; 取的是第一个格子
				for(int k=0; k<arr[i][j].length; k++) {
					arr[i][j][k] = (i+1)*100 +(j+1)*10 + k+1;
				}
			}
		}
	// --- 三维数组的遍历  -------------
		// 第一个循环; 取每一层
		for(int i=0; i<arr.length; i++) {
			// 第二个循环; 取的是每一个条
			for(int j=0; j<arr[i].length; j++) {
				// 第三个循环; 取的是第一个格子
				for(int k=0; k<arr[i][j].length; k++) {
					System.out.print(arr[i][j][k]+"\t");
				}
				System.out.println();
			}
			System.out.println("-------------------");
		}

	}

}
