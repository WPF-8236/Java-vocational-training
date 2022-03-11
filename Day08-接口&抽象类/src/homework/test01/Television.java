package homework.test01;

public class Television implements ComputeTotalSales {
	private static final String name = "电视";
	private double sales;

	public Television() {
	}

	public Television(double sales) {
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
