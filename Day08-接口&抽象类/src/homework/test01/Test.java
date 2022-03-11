package homework.test01;

public class Test {
	public static void main(String[] args) {
		ComputeTotalSales[] computeTotalSales = new ComputeTotalSales[]{
				new Computer(123.5), new Mobile(232.5), new Television(6555.5)
		};

		Shop shop = new Shop();
		shop.setComputeTotalSales(computeTotalSales);
		System.out.println(shop.totalSalesByYear());
	}
}
