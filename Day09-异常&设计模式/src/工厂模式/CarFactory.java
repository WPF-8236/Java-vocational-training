package 工厂模式;

public class CarFactory extends SimpleFactory{

	@Override
	public Moveable makeMoveable() {
		return new Car();
	}
}
