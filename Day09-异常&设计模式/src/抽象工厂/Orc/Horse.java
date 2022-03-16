package 抽象工厂.Orc;

import 抽象工厂.Vehicle;

public class Horse implements Vehicle {
	@Override
	public void moving() {
		System.out.println("--- 兽人骑马 ---");
	}
}
