package 抽象工厂;

public abstract class AbstractFactory {
	public String name;
	public Double createPrices;

	public abstract Food makeFood();
	public abstract Vehicle makeVehicle();
	public abstract Drinkable makeDrink();

}
