public class Method {
	/**
	 * 交换int型 i，j的值。
	 *
	 * @param i
	 * @param j
	 */
	public void exchange(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
	}

	/**
	 * 交互对象Purse的值
	 *
	 * @param purse_01
	 * @param purse_02
	 */
	public void exchange(Purse purse_01, Purse purse_02) {
		Purse temp = purse_01;
		purse_01 = purse_02;
		purse_02 = temp;
	}

	/**
	 * 交换对象Purse中的double型的money的值.
	 *
	 * @param purse_01
	 * @param purse_02
	 */
	public void exchangeMoney(Purse purse_01, Purse purse_02) {
		double money = purse_01.getP_money();
		purse_01.setP_money(purse_02.getP_money());
		purse_02.setP_money(money);
	}

}
