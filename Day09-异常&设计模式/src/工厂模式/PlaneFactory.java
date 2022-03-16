package 工厂模式;

public class PlaneFactory extends SimpleFactory{

	@Override
	public Moveable makeMoveable() {
		return new Plane();
	}
}
