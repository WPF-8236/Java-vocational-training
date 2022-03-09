package homework.test02;

public class Animal {
	protected String species;

	public Animal() {
	}

	public Animal(String species) {
		this.species = species;
	}
	
	public void call(){
		System.out.println("动物在叫");
	}
}
