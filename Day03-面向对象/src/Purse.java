public class Purse {

	private String p_name;  //钱包的主人
	private double p_money; //钱包的钱

	public Purse() {
	}

	/**
	 * 构造方法
	 *
	 * @param p_name  钱包的主人
	 * @param p_money 钱包的钱
	 */
	public Purse(String p_name, double p_money) {
		this.p_name = p_name;
		this.p_money = p_money;
	}

	/**
	 * get,set方法
	 *
	 * @return
	 */
	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public double getP_money() {
		return p_money;
	}

	public void setP_money(double p_money) {
		this.p_money = p_money;
	}

	/**
	 * 存钱方法
	 *
	 * @param money 存入钱的数量
	 */
	public void saveMoney(double money) {
		p_money += money;
		System.out.println("存钱 " + money + "元,余额 " + p_money + "元");
	}

	/**
	 * 取钱方法
	 *
	 * @param money 取出钱的数量
	 */
	public void withdrawMoney(double money) {
		if (money > p_money)
			System.out.println("余额不足");
		else {
			p_money -= money;
			System.out.println("取钱 " + money + "元,余额 " + p_money + "元");
		}
	}
}
