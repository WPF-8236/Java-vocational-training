public class TestHuman {
	public static void main(String[] args) {
		/*Man man = new Man();
		man.id = "No.001";
		man.name = "张三";
		man.age = 12;
		*//*man.gender = "男";*//*
		*//*man.setGender("男");*//*
		System.out.println(man);*/

		/*
			实现多态的前置条件：（动态绑定机制：系统会自动找到引用所指对象所在类的方法）、继承、重写、上转型
			多态：相同类型变量，调用相同方法，实现不同功能
			父类声明，子类实例化（上转型）：属性看声明，方法看对象，子类失去特有的属性和方法，实现多态

		 */
		Human man = new Man();
		Human woman = new Woman();

		man.eating();
		woman.eating();

		/*
			下转型：
				1.子类失去的特有属性和方法又回来了
				2.失去多态
				3.强转之前使用instance of 判断是否是目标实例
		 */

	}
}
