package 工厂模式;

/*
	现有问题:
		1.一个人开车去另一个地方,要有车(Car类);限制:如果只能开一辆车,那么用单例模式
		2.如果想换交通工具,如何做代码的统一?对所有的交通工具抽取一个move()方法
		3.如何定制交通工具的生产过程.

 */
public class TestVehicle {
	public static void main(String[] args) {
//		CarFactory carFactory = new CarFactory();
//		Car car = carFactory.makeCar();
//		car.move();
//
//		PlaneFactory planeFactory = new PlaneFactory();
//		Plane plane = planeFactory.makePlane();
//		plane.move();

		//当我们要换交通工具时,只需换一个工厂对象,现实中开发工厂通过框架配置文件配置
		SimpleFactory factory=new PlaneFactory();
		Moveable m = factory.makeMoveable();
		m.move();

		factory=new CarFactory();
		m = factory.makeMoveable();
		m.move();
	}
}
