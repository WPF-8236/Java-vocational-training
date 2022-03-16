package 抽象工厂.Protoss;

import 抽象工厂.Drinkable;

public class Water implements Drinkable {
	@Override
	public void drinking() {
		System.out.println("--- 神仙水 ---");
	}
}
