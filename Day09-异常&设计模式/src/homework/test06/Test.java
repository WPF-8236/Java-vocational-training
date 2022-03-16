package homework.test06;

public class Test {
	public static void main(String[] args) {
		CarDriver carDriver = new CarDriver();
		Car car = new Car(carDriver);
		Station station = new Station(car);
		station.check();
	}
}
