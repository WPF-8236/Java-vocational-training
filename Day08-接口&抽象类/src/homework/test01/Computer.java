package homework.test01;

public class Computer implements ComputeTotalSales {
	private static final String name = "电脑";
	private double sales;

	public Computer() {
	}

	public Computer(double sales) {
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
