package 抽象工厂.Protoss;

import 抽象工厂.Food;

public class Pill implements Food {
	@Override
	public void eating() {
		System.out.println("--- 嗑仙丹 ---");
	}
}
