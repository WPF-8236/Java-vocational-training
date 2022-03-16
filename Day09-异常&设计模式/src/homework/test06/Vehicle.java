package homework.test06;

//交通工具抽象类
public abstract class Vehicle implements Status{
	//驾驶员
	private Driver driver;

	public Vehicle(Driver driver) {
		this.driver = driver;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
}
