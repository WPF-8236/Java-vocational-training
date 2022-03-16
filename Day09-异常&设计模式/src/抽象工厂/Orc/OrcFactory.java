package 抽象工厂.Orc;

import 抽象工厂.AbstractFactory;
import 抽象工厂.Drinkable;
import 抽象工厂.Food;
import 抽象工厂.Vehicle;

public class OrcFactory extends AbstractFactory {
	@Override
	public Food makeFood() {
		return new Meat();
	}

	@Override
	public Vehicle makeVehicle() {
		return new Horse();
	}

	@Override
	public Drinkable makeDrink() {
		return new Blood();
	}
}
