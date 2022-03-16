package 抽象工厂.Human;

import 抽象工厂.Vehicle;

public class Plane implements Vehicle {
	@Override
	public void moving() {
		System.out.println("--- 人类的飞机飞的快 ---");
	}
}
