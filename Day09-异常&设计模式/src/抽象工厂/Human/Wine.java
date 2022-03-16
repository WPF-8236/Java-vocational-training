package 抽象工厂.Human;

import 抽象工厂.Drinkable;

public class Wine implements Drinkable {
	@Override
	public void drinking() {
		System.out.println("--- 美味的茅台 ---");
	}
}
