package 抽象工厂.Orc;

import 抽象工厂.Food;

public class Meat implements Food {
	@Override
	public void eating() {
		System.out.println("--- 吃兽肉 ---");
	}
}
