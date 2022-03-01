package com.WPF.arrayJava;

public class TestArray5 {

	public static void main(String[] args) {
		// 从数组里面找值; 打印出索引
		int[] arr = {2,3,4,5,6,7,8,9,10,102,105,};
		int num = 9;
		/*for(int i=0; i<arr.length; i++) {
			count++;
			if(num == arr[i]) {
				System.out.println("要找的值的位置是:"+i);
				break;
			}
		}*/
		
		// 二分法查找  
		int begin = 0; 			 // 开始的位置
		int last = arr.length-1; // 最后的位置
		int index = -1;          // 默认-1 没有找到
		int count = 0;			 // 找的次数
		int middle; // 定义一个中间数
		
		while(last >= begin) {
			count++;
			// 确定中间的位置
			middle = (begin+last)/2;
			// 如果正好是中间的数相等
			if(num == arr[middle]) {
				index = middle;
				break;
			// 否则如果,要找的数大于中间数
			}else if(num > arr[middle]) {
				begin = middle+1;
			// 否则如果,要找的数小于中间数
			}else if(num < arr[middle]) {
				last = middle-1;
			}
		}
		System.out.println("找了 "+count+" 次: 位置是:"+index);
	}

}
