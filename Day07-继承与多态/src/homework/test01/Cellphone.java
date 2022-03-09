package homework.test01;

public class Cellphone extends Electricity {
	public Cellphone() {
	}

	public Cellphone(String name) {
		super(name);
	}

	@Override
	public void discharge() {
		super.discharge();
	}

	public void call() {
		System.out.println(name + "打电话");
	}

	public void play() {
		System.out.println(name + "玩游戏");
	}
}
