

//继承：一个类从另外一个类继承它的一些相关属性和方法
//
//关键字：extends
/*
	继承用来描述类与类之间关系
	继承减少冗余代码
	java中是单继承
	java中所有类默认继承object，object是所有类的超类
	继承：
		属性：
			1.子类可以继承父类的非私有属性，私有属性可以通过父类提供的方法访问
			2.子类可以有自己特有属性
			3.子类也可以写父类重名属性，则会覆盖父类属性

		方法：
			1.子类可以继承父类的非私有方法
			2.子类可以有自己特有方法
			3.子类也可以写父类重名方法，则会覆盖父类方法
				重写：
					访问权限：要大于等于父类权限
					返回值类型：要与父类保持一致
					参数：要与父类保持一致
					异常：小于等于异常
				总结：除了方法体其他都一样，权限放大异常缩小
		构造方法：
			1.构造方法不能被继承
			2.实例化子类类型对象时，先实例化父类类型
			3.调用父类方法使用super方法，一定要放在第一句
 */
public class Man extends Human {
	String beard;
	public static final String gender = "男";

	@Override
	public void eating() {
		System.out.println("男生喝酒");
	}

	@Override
	public String toString() {
		return "Man{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", beard='" + beard + '\'' +
				", gender='" + gender + '\'' +
				"} ";
	}
}
