package homework.test06;

//汽车类
public class Car extends Vehicle implements Status {
	public Car(Driver driver) {
		super(driver);
	}

	@Override
	public void moving() {
		System.out.println(super.getDriver().getName() + "在开车");
	}
}
