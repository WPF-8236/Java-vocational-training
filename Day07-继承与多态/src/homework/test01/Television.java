package homework.test01;

public class Television extends Electricity {
	public Television() {
	}

	public Television(String name) {
		super(name);
	}

	@Override
	public void discharge() {
		super.discharge();
	}

	public void putOnAMovie() {
		System.out.println(name + "看电影");
	}
}
