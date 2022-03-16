package 抽象工厂.Orc;

import 抽象工厂.Drinkable;

public class Blood implements Drinkable {
	@Override
	public void drinking() {
		System.out.println("--- 兽人饮血 ---");
	}
}
