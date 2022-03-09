package homework.test02;

public class Cat extends Animal {
	public Cat() {
	}

	public Cat(String species) {
		super(species);
	}

	@Override
	public void call() {
		System.out.println(species + "叫了一声");
	}
}
