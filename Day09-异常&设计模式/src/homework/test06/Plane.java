package homework.test06;

//飞机类
public class Plane extends Vehicle implements Status {
	public Plane(Driver driver) {
		super(driver);
	}

	@Override
	public void moving() {
		System.out.println(super.getDriver().getName() + "在飞机");
	}
}
