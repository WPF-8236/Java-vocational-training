package 工厂模式;

public class Plane implements Moveable {

	@Override
	public void move() {
		System.out.println("--- 飞机飞过去 ---");
	}
}
