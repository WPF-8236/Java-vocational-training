package homework.test01;

public class Electricity {
	protected String name;

	public Electricity() {
	}

	public Electricity(String name) {
		this.name = name;
	}

	public void discharge() {
		System.out.println(name + "用电");
	}

}
