package 工厂模式;

public class Car implements Moveable{
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public void move() {
		System.out.println("--- 小汽车跑得快 ---");
	}
}
