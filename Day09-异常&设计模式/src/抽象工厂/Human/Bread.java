package 抽象工厂.Human;

import 抽象工厂.Food;

public class Bread implements Food {
	@Override
	public void eating() {
		System.out.println("--- 人类的面包会有的 ---");
	}
}
