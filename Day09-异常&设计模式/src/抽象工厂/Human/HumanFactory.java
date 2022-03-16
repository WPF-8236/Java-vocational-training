package 抽象工厂.Human;

import 抽象工厂.AbstractFactory;
import 抽象工厂.Drinkable;
import 抽象工厂.Food;
import 抽象工厂.Vehicle;

public class HumanFactory extends AbstractFactory {

	@Override
	public Food makeFood(){
		return new Bread();
	}
	@Override
	public Vehicle makeVehicle(){
		return new Plane();
	}
	@Override
	public Drinkable makeDrink(){
		return new Wine();
	}
}
