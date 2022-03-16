package 抽象工厂.Protoss;

import 抽象工厂.AbstractFactory;
import 抽象工厂.Drinkable;
import 抽象工厂.Food;
import 抽象工厂.Vehicle;

public class ProtossFactory extends AbstractFactory {
	@Override
	public Food makeFood() {
		return new Pill();
	}

	@Override
	public Vehicle makeVehicle() {
		return new Cloud();
	}

	@Override
	public Drinkable makeDrink() {
		return new Water();
	}
}
