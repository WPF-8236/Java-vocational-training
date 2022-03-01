package com.WPF.arrayJava;

public class ArrayTest_Binarylookup {
	public static void main(String[] args) {
		int[] arr = {32, 11, 5, 78, 99, 100, 2, 9, 102};
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i : arr) {
			System.out.println(i);
		}

		int begin = 0;
		int last = arr.length - 1;
		while (last >= begin) {
			int middle = (begin + last) / 2;
			if (arr[middle] == 78) {
				System.out.println("找到78");
				break;
			} else if (arr[middle] < 78)
				begin = middle + 1;
			else
				last = middle - 1;
		}
	}
}
