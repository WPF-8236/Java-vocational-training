package 抽象工厂;

import 抽象工厂.Human.HumanFactory;
import 抽象工厂.Orc.OrcFactory;
import 抽象工厂.Protoss.ProtossFactory;

public class TestBattle {
	public static void main(String[] args) {
//替换系列产品,只需要替换一个工厂对象即可
		//后面的工厂对象,也是由框架配置文件,配置进来
		//		AbstractFactory humanFactory = new HumanFactory();
//		AbstractFactory factory = new ProtossFactory();
		AbstractFactory factory = new OrcFactory();

		Drinkable drinkable = factory.makeDrink();
		Food food = factory.makeFood();
		Vehicle vehicle = factory.makeVehicle();

		drinkable.drinking();
		food.eating();
		vehicle.moving();
	}
}
