package homework.test02;

public class Dog extends Animal {
	public Dog() {
	}

	public Dog(String species) {
		super(species);
	}

	@Override
	public void call() {
		System.out.println(species + "叫了一声");
	}
}
