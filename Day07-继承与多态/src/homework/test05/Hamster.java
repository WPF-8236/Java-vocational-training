package homework.test05;

public class Hamster extends Animal {
	public static final String species = "仓鼠";

	public Hamster() {
	}

	public Hamster(String name, Integer age, String color, String gender, double money) {
		super(name, age, color, gender, money);
	}

	public String getSpecies() {
		return species;
	}

	@Override
	public String toString() {
		return species + "{" +
				"name='" + name + '\'' +
				", age=" + age +
				", color='" + color + '\'' +
				", gender='" + gender + '\'' +
				", money=" + money +
				"} ";
	}
}
