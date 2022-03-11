package homework.test01;

public class Mobile implements ComputeTotalSales {
	private static final String name = "手机";
	private double sales;

	public Mobile() {
	}

	public Mobile(double sales) {
		this.sales = sales;
	}


	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	@Override
	public double totalSalesByYear() {
		return sales;
	}
}
