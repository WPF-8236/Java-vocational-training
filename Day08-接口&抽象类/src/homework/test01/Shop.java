package homework.test01;

public class Shop implements ComputeTotalSales {
	private String name;
	private ComputeTotalSales[] computeTotalSales;
	private double sales;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ComputeTotalSales[] getComputeTotalSales() {
		return computeTotalSales;
	}

	public void setComputeTotalSales(ComputeTotalSales[] computeTotalSales) {
		this.computeTotalSales = computeTotalSales;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	@Override
	public double totalSalesByYear() {
		for (ComputeTotalSales computeTotalSale : computeTotalSales) {
			sales += computeTotalSale.totalSalesByYear();
		}
		return sales;
	}
}
