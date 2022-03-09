package homework.test05;

import java.io.IOException;

public class Menu {
	private String menuIndex;  //记录菜单编号
	private Integer users_index;    //记录用户在数据中位置编号
	private Integer animals_index;    //记录动物在数据中位置编号
	private Service service;    //数据库服务操作

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
	 * 构造方法 初始化数据库
	 * @param dataBase  数据库对象
	 */
	public Menu(DataBase dataBase) {
		this.service = new Service(dataBase);
		while (true) {
			initializeMenu();
			System.out.print("请输入菜单编号:>");
			menuIndex = input();
			if ("1".equals(menuIndex)) {
				login();    //登录方法
			} else if ("0".equals(menuIndex)) {
				break;
			} else {
				System.out.println("菜单输入错误,请重新输入");
			}
		}
	}

	/**
	 * 登录方法
	 */
	private void login() {
		System.out.print("请输入用户名:>");
		String u_id = input();
		System.out.print("请输入密码:>");
		String u_password = input();
		users_index = service.checkUser(u_id, u_password); //检测是否存在此用户
		if (users_index == -1) {
			System.out.println("密码或用户名错误");
		} else if (users_index == 0) {
			while (true) {
				adminMenu();    //管理员菜单
				System.out.print("请输入菜单编号:>");
				menuIndex = input();
				if ("0".equals(menuIndex))
					break;
				else {
					admin(menuIndex);   //管理员模式
				}
			}
		} else {
			while (true) {
				userMenu();     //用户菜单
				System.out.print("请输入菜单编号:>");
				menuIndex = input();
				if ("0".equals(menuIndex))
					break;
				else {
					user(menuIndex, users_index);   //用户模式
				}
			}
		}
	}

	/**
	 * 用户模式
	 * @param menuIndex 菜单下标
	 * @param users_index 用户下标
	 */
	private void user(String menuIndex, Integer users_index) {
		String id;
		String password;
		String u_name;
		Integer u_age;
		String u_gender;
		Double member;  //用户会员等级
		Double u_money;

		if ("1".equals(menuIndex)) {
			System.out.print("输入存款数:>");
			u_money = Double.parseDouble(input());
			if (u_money > 0.0) {
				service.addUserMoney(users_index, u_money); //增加用户余额
			} else
				System.out.println("输入正确金额");
		} else if ("2".equals(menuIndex)) {
			while (true) {
				buyMenu();     //购买菜单
				System.out.print("请输入菜单编号:>");
				menuIndex = input();
				if ("0".equals(menuIndex))
					break;
				else {
					buy(menuIndex, users_index);   //购买模式
				}
			}
		} else if ("3".equals(menuIndex)) {
			service.showUser(users_index);  //展示用户自己信息
		} else if ("4".equals(menuIndex)) {
			User user = service.getAUser(users_index);  //获取用户自己对象
			id = user.getId();
			u_money = user.getMoney();
			if (user instanceof DiamondMember) {
				member = ((DiamondMember) user).getMember();
			} else if (user instanceof GoldMember) {
				member = ((GoldMember) user).getMember();
			} else if (user instanceof SilverMember) {
				member = ((SilverMember) user).getMember();
			} else {
				member = ((OrdinaryMember) user).getMember();
			}
			System.out.print("输入修改的用户密码:>");
			password = input();
			System.out.print("输入修改的用户姓名:>");
			u_name = input();
			System.out.print("输入修改的用户年龄:>");
			u_age = Integer.parseInt(input());
			System.out.print("输入修改的用户性别:>");
			u_gender = input();
			//根据会员等级更新对应会员等级对象
			if (member == 0.7)
				service.changeUser(new DiamondMember(id, password, u_name, u_age, u_gender, u_money), users_index);
			else if (member == 0.8)
				service.changeUser(new GoldMember(id, password, u_name, u_age, u_gender, u_money), users_index);
			else if (member == 0.9)
				service.changeUser(new SilverMember(id, password, u_name, u_age, u_gender, u_money), users_index);
			else
				service.changeUser(new OrdinaryMember(id, password, u_name, u_age, u_gender, u_money), users_index);
		} else
			System.out.println("菜单输入错误,请重新输入");

	}

	/**
	 * 购买模式
	 * @param menuIndex 菜单下标
	 * @param users_index 用户下标
	 */
	private void buy(String menuIndex, Integer users_index) {
		User user = service.getAUser(users_index);  //获取用户自己对象
		String species;
		String name;
		Integer age;
		String color;
		String gender;
		double money;

		if ("1".equals(menuIndex)) {
			service.showAllAnimals();   //展示所有动物
		} else if ("2".equals(menuIndex)) {
			System.out.print("输入需要查看的动物类型:>");
			species = input();
			service.showAnimalsBySpecies(species);  //根据种类查找
		} else if ("3".equals(menuIndex)) {
			System.out.print("输入需要查看的动物颜色:>");
			color = input();
			service.showAnimalsByColor(color);  //根据颜色查找
		} else if ("4".equals(menuIndex)) {
			System.out.print("输入需要查看的动物价格:>");
			money = Double.parseDouble(input());
			service.showAnimalsByMoney(money);  //根据金额查找
		} else if ("5".equals(menuIndex)) {
			System.out.print("输入需要查看的动物名字:>");
			name = input();
			service.showAnimalsByName(name);    //根据名字查找
		} else if ("6".equals(menuIndex)) {
			System.out.print("输入需要查看的动物年龄:>");
			age = Integer.parseInt(input());
			service.showAnimalsByAge(age);  //根据年龄查找
		} else if ("7".equals(menuIndex)) {
			System.out.print("输入需要购买的动物位置:>");
			animals_index = Integer.parseInt(input());
			if (animals_index > service.getAnimalNum()) {
				System.out.println("无此动物");
			} else {
				service.buyAnimal(user, animals_index); //购买动物
			}
		} else
			System.out.println("菜单输入错误,请重新输入");
	}

	/**
	 * 管理员模式
	 * @param menuIndex 菜单下标
	 */

	private void admin(String menuIndex) {
		//user属性
		String id;
		String password;
		String u_name;
		Integer u_age;
		String u_gender;
		Double member;
		Double u_money;

		//animal属性
		String species;
		String a_name;
		Integer a_age;
		String color;
		String a_gender;
		Double a_money;

		if ("1".equals(menuIndex)) {
			service.showAllUsers(); //展示所有用户
		} else if ("2".equals(menuIndex)) {
			System.out.print("输入需要修改的用户位置:>");
			String i = input();
			int index = Integer.parseInt(i);  //用户在数据库位置
			if (index > service.getUserNum())
				System.out.println("无此用户");
			else {
				id = service.getAUser(index).getId();
				System.out.print("输入修改的用户密码:>");
				password = input();
				System.out.print("输入修改的用户姓名:>");
				u_name = input();
				System.out.print("输入修改的用户年龄:>");
				u_age = Integer.parseInt(input());
				System.out.print("输入修改的用户性别:>");
				u_gender = input();
				System.out.print("输入修改的用户会员等级:>");
				member = Double.parseDouble(input());
				System.out.print("输入修改的用户余额:>");
				u_money = Double.parseDouble(input());
				//根据会员等级更新对应会员等级对象
				if (member == 0.7)
					service.changeUser(new DiamondMember(id, password, u_name, u_age, u_gender, u_money), index);
				else if (member == 0.8)
					service.changeUser(new GoldMember(id, password, u_name, u_age, u_gender, u_money), index);
				else if (member == 0.9)
					service.changeUser(new SilverMember(id, password, u_name, u_age, u_gender, u_money), index);
				else
					service.changeUser(new OrdinaryMember(id, password, u_name, u_age, u_gender, u_money), index);
			}
		} else if ("3".equals(menuIndex)) {
			System.out.print("输入需要删除的用户位置:>");
			String i = input();
			int index = Integer.parseInt(i);  //用户在数据库位置
			if (index > service.getUserNum())
				System.out.println("无此用户");
			else {
				service.deleteUser(index); //删除用户
			}
		} else if ("4".equals(menuIndex)) {
			System.out.print("输入添加的用户id:>");
			id = input();
			System.out.print("输入添加的用户密码:>");
			password = input();
			System.out.print("输入添加的用户姓名:>");
			u_name = input();
			System.out.print("输入添加的用户年龄:>");
			u_age = Integer.parseInt(input());
			System.out.print("输入添加的用户性别:>");
			u_gender = input();
			System.out.print("输入添加的用户会员等级:>");
			member = Double.parseDouble(input());
			System.out.print("输入添加的用户余额:>");
			u_money = Double.parseDouble(input());
			//根据会员等级添加对应会员等级对象
			if (member == 0.7)
				service.insertUser(new DiamondMember(id, password, u_name, u_age, u_gender, u_money));
			else if (member == 0.8)
				service.insertUser(new GoldMember(id, password, u_name, u_age, u_gender, u_money));
			else if (member == 0.9)
				service.insertUser(new SilverMember(id, password, u_name, u_age, u_gender, u_money));
			else
				service.insertUser(new OrdinaryMember(id, password, u_name, u_age, u_gender, u_money));
		} else if ("5".equals(menuIndex)) {
			System.out.print("输入添加的动物种类:>");
			species = input();
			System.out.print("输入添加的动物名字:>");
			a_name = input();
			System.out.print("输入添加的动物年龄:>");
			a_age = Integer.parseInt(input());
			System.out.print("输入添加的动物颜色:>");
			color = input();
			System.out.print("输入添加的动物性别:>");
			a_gender = input();
			System.out.print("输入添加的动物价格:>");
			a_money = Double.parseDouble(input());
			//根据动物种类添加对应动物对象
			if ("猫".equals(species))
				service.insertAnimal(new Cat(a_name, a_age, color, a_gender, a_money));
			else if ("狗".equals(species))
				service.insertAnimal(new Dog(a_name, a_age, color, a_gender, a_money));
			else
				service.insertAnimal(new Hamster(a_name, a_age, color, a_gender, a_money));
		} else if ("6".equals(menuIndex)) {
			System.out.print("输入需要修改的动物位置:>");
			String i = input();
			int index = Integer.parseInt(i);  //动物在数据库位置
			if (index > service.getAnimalNum())
				System.out.println("无此动物");
			else {
				species = service.getAnimalSpecies(index);
				System.out.print("输入修改的动物名字:>");
				a_name = input();
				System.out.print("输入修改的动物年龄:>");
				a_age = Integer.parseInt(input());
				System.out.print("输入修改的动物颜色:>");
				color = input();
				System.out.print("输入修改的动物性别:>");
				a_gender = input();
				System.out.print("输入修改的动物价格:>");
				a_money = Double.parseDouble(input());
				//根据动物种类跟新对应动物对象
				if ("猫".equals(species))
					service.changeAnimal(new Cat(a_name, a_age, color, a_gender, a_money), index);
				else if ("狗".equals(species))
					service.changeAnimal(new Dog(a_name, a_age, color, a_gender, a_money), index);
				else
					service.changeAnimal(new Hamster(a_name, a_age, color, a_gender, a_money), index);
			}
		} else if ("7".equals(menuIndex)) {
			System.out.print("输入需要删除的动物位置:>");
			String i = input();
			int index = Integer.parseInt(i);  //用户在数据库位置
			if (index > service.getAnimalNum())
				System.out.println("无此动物");
			else {
				service.deleteAnimal(index); //删除动物
			}
		} else if ("8".equals(menuIndex)) {
			service.showAllAnimals();
		} else
			System.out.println("菜单输入错误,请重新输入");
	}

	public void initializeMenu() {
		System.out.println();
		System.out.println("==============         欢迎来到王潘锋宠物店             =============");
		System.out.println("==============              请选择菜单                 =============");
		System.out.println("==============                                          =============");
		System.out.println("==============             1.登录用户                    =============");
		System.out.println("==============                                           =============");
		System.out.println("==============             0.退出系统                     =============");
		System.out.println("==============                                            =============");
		System.out.println("==============          欢迎来到王潘锋宠物店             =============");
		System.out.println();
	}


	public void userMenu() {
		System.out.println();
		System.out.println("==============         欢迎来到王潘锋宠物店              =============");
		System.out.println("==============              请选择菜单                    =============");
		System.out.println("==============                                            =============");
		System.out.println("==============               1.存钱                        =============");
		System.out.println("==============               2.购买                        =============");
		System.out.println("==============               3.查看信息                    =============");
		System.out.println("==============               4.修改信息                     =============");
		System.out.println("==============                                            =============");
		System.out.println("==============               0.退出系统                    =============");
		System.out.println("==============                                            =============");
		System.out.println("==============          欢迎来到王潘锋宠物店             =============");
		System.out.println();
	}

	public void adminMenu() {
		System.out.println();
		System.out.println("==============         欢迎来到王潘锋宠物店              =============");
		System.out.println("==============              请选择菜单                    =============");
		System.out.println("==============                                            =============");
		System.out.println("==============            1.查看用户信息                  =============");
		System.out.println("==============            2.修改用户信息                   =============");
		System.out.println("==============            3.删除用户信息                  =============");
		System.out.println("==============            4.添加用户信息                  =============");
		System.out.println("=======================================================================");
		System.out.println("==============            5.添加动物信息                  =============");
		System.out.println("==============            6.修改动物信息                  =============");
		System.out.println("==============            7.删除动物信息                  =============");
		System.out.println("==============            8.查看动物信息                  =============");
		System.out.println("==============                                            =============");
		System.out.println("==============              0.退出系统                    =============");
		System.out.println("==============                                            =============");
		System.out.println("==============          欢迎来到王潘锋宠物店             =============");
		System.out.println();
	}


	public void buyMenu() {
		System.out.println();
		System.out.println("==============         欢迎来到王潘锋宠物店              =============");
		System.out.println("==============              请选择菜单                    =============");
		System.out.println("==============                                            =============");
		System.out.println("==============            1.查看所有动物信息               =============");
		System.out.println("==============            2.按种类查看动物信息             =============");
		System.out.println("==============            3.按颜色查看动物信息             =============");
		System.out.println("==============            4.按价格查看动物信息             =============");
		System.out.println("==============            5.按名字查看动物信息             =============");
		System.out.println("==============            6.按年龄查看动物信息             =============");
		System.out.println("=======================================================================");
		System.out.println("==============            7.购买宠物                      =============");
		System.out.println("==============            0.退出系统                      =============");
		System.out.println("==============                                            =============");
		System.out.println("==============          欢迎来到王潘锋宠物店             =============");
		System.out.println();
	}

}
