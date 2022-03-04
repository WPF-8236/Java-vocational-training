public class TestClassRoom {

	public static void main(String[] args) {
		/*
		ClassRoom room = new ClassRoom("java100班",20);
		Student stu = new Student("张三",18,'男');
		room.setStu(stu); // 给教室的stu属性赋值,
		
		Student stu2 = room.getStu();
		System.out.println("学生:"+stu2);
		
		int num = room.getNum();
		System.out.println("教室人数:"+num);
		*/
		
		// 数组知识的回顾
//		int[] arr = new int[5];
//		arr[0] = 3;  // 数组里的每个存数据的位置,相当于一个该类型的变量
//		arr[1] = 100;
		
//		String[] arr = new String[3];
//		arr[0] = "hello";
//		arr[1] = ",";
//		arr[2] = "java";
		
		// 自定义类型的数组的定义和使用
		Student[] arr = new Student[4];
		arr[0] = new Student("jack",18,'男');
		arr[1] = new Student("rose",17,'女');		
		arr[3] = new Student("tom",20,'男');		
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
	}

}
