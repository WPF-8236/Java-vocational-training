package com.skeyedu.day04obj;
/*
 
设计一个教室类（Class_room )（要封装属性）

属性：名字、容纳的人数、学生  <这里是一个学生还是多个？>

新建教室时就要有名字和容纳人数

方法功能：获得学生。获得容纳人数

 * */
public class ClassRoom {
	private String className;
	private int num;
	// private String stuName; // 使用字符串,没有办法完整地描述一个学生
	
	// 自定义类对象,做为另一个类的属性存在(聚合)
	//private Student stu; // Student类型的对象,可以描述出一个学生 
	private Student[] stus; // Student类型的数组, 可以描述出一个教室里有多个学生
	
	// 构造方法: 新建教室的时候,有名字和人数
	public ClassRoom(String className, int num) {
		this.className = className;
		this.num = num;
		stus = new Student[num];  // 这个是组合关系
	}
	
	// 提供一个学生进教室的方法
	public void getIn(Student s) {
		for(int i=0; i<stus.length; i++) {
			if(stus[i] == null) {
				stus[i] = s; // 这个相当于坐到教室的位置上
				break;
			}
		}
	}
	// 一次性可以进多个学生的方法   --- 可变参数,以数组形式存在
	public void getInMore(Student... arr) {
		int j = 0;
		for(int i=0; i<stus.length; i++) {
			// 当前位置为空, 并且j的长度小于传进来的参数的长度
			if(stus[i] == null && j< arr.length) {
				stus[i] = arr[j];
				j++;
			}
		}
		// 判断没有进教室的学生
		if(j<arr.length) {
			for(int i=j; i<arr.length; i++) {
				System.out.println("没进教室的学生:"+arr[i].getName());
			}
		}
	}
	// -------  打印出教室里所有学生 -------------------
	public void showAllNames() {
		for(int i=0; i<stus.length; i++) {  // 空指针错误, null调用了方法或属性
			if(stus[i] != null) {
				System.out.println(stus[i].getName()+"  年龄:"+stus[i].getAge());
			}else {
				System.out.println("--- 位置空  ---");
			}
		}
	}
	
	
//	public void setStus(Student[] stus) {
//		this.stus = stus;
//	}
	public Student[] getStus() {
		return stus;
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

}
