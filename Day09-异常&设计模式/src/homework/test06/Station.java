package homework.test06;

//检查站
public class Station {
	//交通工具
	private Vehicle vehicle;

	public Station(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	//检查运行状态
	public void check() {
		vehicle.moving();
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
