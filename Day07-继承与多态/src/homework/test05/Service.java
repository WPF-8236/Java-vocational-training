package homework.test05;

import java.io.IOException;

public class Service {
	private DataBase dataBase;  //数据库对象
	private User[] users = DataBase.getUsers(); //数据库中用户数据
	private Animal[] animals = DataBase.getAnimals();   //数据库中动物数据

	/**
	 * 输入方法
	 *
	 * @return 输入的结果
	 */
	public String input() {
		byte[] bytes = new byte[50];
		try {
			System.in.read(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(bytes).trim();
	}

	/**
	 * 初始化数据库
	 * @param dataBase 数据库对象
	 */

	public Service(DataBase dataBase) {
		this.dataBase = dataBase;
	}

	/**
	 * 核对用户是否存在
	 * @param u_id  用户id
	 * @param u_password    用户密码
	 * @return  用户下标
	 */
	public Integer checkUser(String u_id, String u_password) {
		int i = -1;
		for (int j = 0; j <= dataBase.getUserNum(); j++) {
			if (users[j].getId().equals(u_id) && users[j].getPassword().equals(u_password))
				return j;
		}
		return i;
	}
	/**
	 * 核对用户是否存在
	 * @param u_id  用户id
	 * @return  用户下标
	 */
	public Integer checkUser(String u_id) {
		int i = -1;
		for (int j = 0; j <= dataBase.getUserNum(); j++) {
			if (users[j].getId().equals(u_id))
				return j;
		}
		return i;
	}

	/**
	 * 显示所有用户
	 */
	public void showAllUsers() {
		for (int i = 1; i <= dataBase.getUserNum(); i++) {
			System.out.println("位置：" + i + " " + users[i]);
		}
	}

	/**
	 * 更改用户信息
	 * @param user  用户对象
	 * @param i 用户下标
	 */

	public void changeUser(User user, int i) {
		users[i] = user;
	}

	/**
	 * 获取数据库用户数据个数
	 * @return  用户对象个数
	 */
	public int getUserNum() {
		return dataBase.getUserNum();
	}
	/**
	 * 获取数据库动物数据个数
	 * @return  动物对象个数
	 */
	public int getAnimalNum() {
		return dataBase.getAnimalNum();
	}

	/**
	 * 删除用户
	 * @param i 用户下标
	 */
	public void deleteUser(int i) {
		for (int j = i; j < dataBase.getUserNum(); j++) {
			users[j] = users[j + 1];
		}
		int num = dataBase.getUserNum();
		dataBase.setUserNum(--num);
	}

	/**
	 * 添加用户
	 * @param user 用户对象
	 */
	public void insertUser(User user) {
		if (checkUser(user.getId()) == -1) {
			int num = dataBase.getUserNum();
			users[++num] = user;
			dataBase.setUserNum(num);
		} else
			System.out.println("用户已存在");
	}

	/**
	 * 显示所有动物
	 */
	public void showAllAnimals() {
		for (int i = 1; i <= dataBase.getAnimalNum(); i++) {
			System.out.println("位置：" + i + " " + animals[i]);
		}
	}

	/**
	 * 删除动物
	 * @param index 动物对象
	 */
	public void deleteAnimal(int index) {
		for (int j = index; j < dataBase.getAnimalNum(); j++) {
			animals[j] = animals[j + 1];
		}
		int num = dataBase.getAnimalNum();
		dataBase.setAnimalNum(--num);
	}

	/**
	 * 获取动物种类
	 * @param index 动物下标
	 * @return 动物种类
	 */
	public String getAnimalSpecies(int index) {
		Animal animal = animals[index];
		if (animal instanceof Cat)
			return ((Cat)animal).getSpecies();
		else if (animal instanceof Dog)
			return ((Dog)animal).getSpecies();
		else
			return ((Hamster)animal).getSpecies();
	}

	/**
	 * 更改动物信息
	 * @param animal 动物对象
	 * @param index 对象下标
	 */
	public void changeAnimal(Animal animal, int index) {
		animals[index] = animal;
	}

	/**
	 * 添加动物
	 * @param animal 动物对象
	 */
	public void insertAnimal(Animal animal) {
		if (checkAnimal(animal.getName()) == -1) {
			int num = dataBase.getAnimalNum();
			animals[++num] = animal;
			dataBase.setAnimalNum(num);
		} else
			System.out.println("动物名字已存在");
	}

	/**
	 * 核对动物姓名
	 * @param name 动物名字
	 * @return 动物下标
	 */
	public int checkAnimal(String name) {
		int i = -1;
		for (int j = 1; j <= dataBase.getAnimalNum(); j++) {
			if (animals[j].getName().equals(name))
				return j;
		}
		return i;
	}

	/**
	 * 获取用户对象
	 * @param index 用户下标
	 * @return 用户对象
	 */
	public User getAUser(int index) {
		return users[index];
	}

	/**
	 * 增加用户金额
	 * @param users_index 用户下标
	 * @param u_money 金额
	 */
	public void addUserMoney(Integer users_index, Double u_money) {
		double money = users[users_index].getMoney();
		users[users_index].setMoney(money + u_money);
	}

	/**
	 * 展示用户信息
	 * @param users_index 用户下标
	 */
	public void showUser(Integer users_index) {
		System.out.println(users[users_index]);
	}

	/**
	 * 按种类查询动物信息
	 * @param species 物种
	 */
	public void showAnimalsBySpecies(String species) {
		if ("狗".equals(species)) {
			for (int i = 1; i <= dataBase.getAnimalNum(); i++) {
				if (animals[i] instanceof Dog)
					System.out.println("位置：" + i + " " + animals[i]);
			}
		} else if ("猫".equals(species)) {
			for (int i = 1; i <= dataBase.getAnimalNum(); i++) {
				if (animals[i] instanceof Cat)
					System.out.println("位置：" + i + " " + animals[i]);
			}
		} else {
			for (int i = 1; i <= dataBase.getAnimalNum(); i++) {
				if (animals[i] instanceof Hamster)
					System.out.println("位置：" + i + " " + animals[i]);
			}
		}
	}

	/**
	 * 按颜色查询动物信息
	 * @param color 颜色
	 */
	public void showAnimalsByColor(String color) {
		for (int i = 1; i <= dataBase.getAnimalNum(); i++) {
			if (animals[i].getColor().equals(color))
				System.out.println("位置：" + i + " " + animals[i]);
		}
	}

	/**
	 * 按价格查询动物信息
	 * @param money 价格
	 */
	public void showAnimalsByMoney(double money) {
		for (int i = 1; i <= dataBase.getAnimalNum(); i++) {
			if (animals[i].getMoney() == money)
				System.out.println("位置：" + i + " " + animals[i]);
		}
	}

	/**
	 * 按名字查询动物信息
	 * @param name 名字
	 */
	public void showAnimalsByName(String name) {
		for (int i = 1; i <= dataBase.getAnimalNum(); i++) {
			if (animals[i].getName().equals(name))
				System.out.println("位置：" + i + " " + animals[i]);
		}
	}

	/**
	 * 按年龄查询动物信息
	 * @param age 年龄
	 */
	public void showAnimalsByAge(Integer age) {
		for (int i = 1; i <= dataBase.getAnimalNum(); i++) {
			if (animals[i].getAge() == age)
				System.out.println("位置：" + i + " " + animals[i]);
		}
	}

	/**
	 * 购买动物
	 * @param user 用户对象
	 * @param animals_index 动物下标
	 */
	public void buyAnimal(User user, Integer animals_index) {
		double u_money = user.getMoney();
		double a_money = animals[animals_index].getMoney();
		double member;
		if (user instanceof DiamondMember) {
			System.out.println("你好钻石会员");
			member = ((DiamondMember) user).getMember();
		} else if (user instanceof GoldMember) {
			System.out.println("你好金卡会员");
			member = ((GoldMember) user).getMember();
		} else if (user instanceof SilverMember) {
			System.out.println("你好银卡会员");
			member = ((SilverMember) user).getMember();
		} else {
			System.out.println("你好普通用户");
			member = ((OrdinaryMember) user).getMember();
		}
		double z_money = a_money * member;
		System.out.println("用户余额为: " + u_money + "宠物价格为: " + a_money + "折后价格为: " + z_money);
		if (u_money >= z_money) {
			System.out.println("购买成功");
			u_money -= z_money;
			user.setMoney(u_money);
			deleteAnimal(animals_index);
		} else {
			System.out.println("余额不足,请再支付: " + (z_money - u_money));
			input();
			System.out.println("购买成功");
			user.setMoney(0.0);
			deleteAnimal(animals_index);
		}
	}
}
