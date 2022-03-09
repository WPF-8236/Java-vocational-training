package homework.test05;

public class Animal {
	protected String name;      //动物名字
	protected Integer age;      //动物年龄
	protected String color;     //动物颜色
	protected String gender;    //动物性别
	protected double money;     //动物价格

	/**
	 * 空参构造
	 */
	public Animal() {
	}

	/**
	 * 有参构造
	 *
	 * @param name   //动物名字
	 * @param age    //动物年龄
	 * @param color  //动物颜色
	 * @param gender //动物性别
	 * @param money  //动物价格
	 */
	public Animal(String name, Integer age, String color, String gender, double money) {
		this.name = name;
		this.age = age;
		this.color = color;
		this.gender = gender;
		this.money = money;
	}


	//============= set And get ===============
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
}
