package 抽象工厂.Protoss;

import 抽象工厂.Vehicle;

public class Cloud implements Vehicle {
	@Override
	public void moving() {
		System.out.println("--- 腾云驾雾 ---");
	}
}
