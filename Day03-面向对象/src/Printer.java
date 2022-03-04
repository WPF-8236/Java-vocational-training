public class Printer {
	/**
	 * 打印从1 到 x的所有数字
	 *
	 * @param x 结束数字
	 */
	public void print(int x) {
		for (int i = 1; i <= x; i++) {
			System.out.println(i);
		}
	}

	/**
	 * 打印从x 到y的所有数字
	 *
	 * @param x 起始数字
	 * @param y 结束数字
	 */
	public void print(int x, int y) {
		for (int i = x; i <= y; i++) {
			System.out.println(i);
		}
	}

	/**
	 * 打印从x到y的所有数字，步长为z
	 *
	 * @param x 起始数字
	 * @param y 结束数字
	 * @param z 步长
	 */
	public void print(int x, int y, int z) {
		for (int i = x; i <= y; i += z) {
			System.out.println(i);
		}
	}
}
