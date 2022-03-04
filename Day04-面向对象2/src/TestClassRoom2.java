package com.skeyedu.day04obj;

public class TestClassRoom2 {

	public static void main(String[] args) {
		ClassRoom room = new ClassRoom("java001",6);

		/*Student[] arr = new Student[room.getNum()];*/
		Student stu1 = new Student("jack",18,'男');
		Student stu2 = new Student("rose",17,'女');		
		Student stu3 = new Student("lili",19,'女');	
		Student stu4 = new Student("tom",20,'男');
		Student stu5 = new Student("张三",20,'男');
		// 给教室里的学生数组赋值
		//room.setStus(arr);
		
//		Student[] arr = new Student[5];
		
//		room.getIn(stu1);
//		room.getIn(stu4);
		
		room.getInMore(stu1,stu2,stu3,stu4,stu5);
		room.showAllNames();

	}

}
