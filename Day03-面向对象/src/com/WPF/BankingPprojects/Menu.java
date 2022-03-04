package com.WPF.BankingPprojects;

import java.util.Scanner;

/**
 * 菜单类
 */
public class Menu {

	private Integer menuIndex;  //记录菜单编号
	private Integer users_index;    //记录用户在数据中位置编号
	private DateBase dateBase;  //存储数据库对象

	private Scanner scanner = new Scanner(System.in);   //全局扫描器

	/**
	 * 构造方法,初始化数据库对象,菜单界面
	 * @param dateBase  数据库对象
	 */
	public Menu(DateBase dateBase) {
		this.dateBase = dateBase;   //数据库对象赋值
		while (true) {
			initializeMenu();
			System.out.print("请输入菜单编号:>");
			menuIndex = scanner.nextInt();
			scanner.nextLine();
			if (menuIndex == 1) {
				login();    //登录方法
			} else if (menuIndex == 0) {
				break;
			} else {
				System.out.println("菜单输入错误,请重新输入");
			}
		}
	}

	/**
	 * 初始化菜单
	 */

	public void initializeMenu() {
		System.out.println("==============         欢迎使用王潘锋银行系统             =============");
		System.out.println("==============              请选择菜单                   =============");
		System.out.println("==============                                          =============");
		System.out.println("==============             1.登录银行                    =============");
		System.out.println("==============                                           =============");
		System.out.println("==============             0.退出系统                     =============");
		System.out.println("==============                                            =============");
		System.out.println("==============          欢迎使用王潘锋银行系统             =============");
	}

	/**
	 * 用户菜单
	 */

	public void userMenu() {
		System.out.println("==============         欢迎使用王潘锋银行系统              =============");
		System.out.println("==============              请选择菜单                    =============");
		System.out.println("==============                                            =============");
		System.out.println("==============               1.存钱                        =============");
		System.out.println("==============               2.取钱                        =============");
		System.out.println("==============               3.查看信息                    =============");
		System.out.println("==============               4.修改信息                     =============");
		System.out.println("==============                                            =============");
		System.out.println("==============               0.退出系统                    =============");
		System.out.println("==============                                            =============");
		System.out.println("==============          欢迎使用王潘锋银行系统             =============");
	}

	/**
	 * 管理员菜单
	 */

	public void adminMenu() {
		System.out.println("==============         欢迎使用王潘锋银行系统              =============");
		System.out.println("==============              请选择菜单                    =============");
		System.out.println("==============                                            =============");
		System.out.println("==============            1.查看用户信息                  =============");
		System.out.println("==============            2.修改用户信息                   =============");
		System.out.println("==============            3.删除用户信息                  =============");
		System.out.println("==============            4.添加用户信息                  =============");
		System.out.println("==============                                            =============");
		System.out.println("==============              0.退出系统                    =============");
		System.out.println("==============                                            =============");
		System.out.println("==============          欢迎使用王潘锋银行系统             =============");
	}

	/**
	 * 登录方法
	 */
	public void login() {
		System.out.print("请输入用户名:>");
		String u_id = scanner.nextLine();
		System.out.print("请输入密码:>");
		String u_password = scanner.nextLine();
		users_index = dateBase.checkUser(u_id, u_password); //检测是否存在此用户
		if (users_index == -1) {
			System.out.println("密码或用户名错误");
		} else if (users_index == 0) {
			while (true) {
				adminMenu();    //管理员菜单
				System.out.print("请输入菜单编号:>");
				menuIndex = scanner.nextInt();
				scanner.nextLine();
				if (menuIndex == 0)
					break;
				else {
					admin(menuIndex);   //管理员模式
				}
			}
		} else {
			while (true) {
				userMenu();     //用户菜单
				System.out.print("请输入菜单编号:>");
				menuIndex = scanner.nextInt();
				scanner.nextLine();
				if (menuIndex == 0)
					break;
				else {
					user(menuIndex, users_index);   //用户模式
				}
			}
		}
	}

	/**
	 * 管理员模式
	 * @param menuIndex 菜单编号
	 */

	public void admin(Integer menuIndex) {
		/**
		 * 用户信息
		 */
		int i;  //用户在数据库位置
		String u_id;
		String u_password;
		String u_name;
		String gender;
		Integer age;
		Double money;
		if (menuIndex == 1) {
			dateBase.showAllUsers();    //显示所有用户
		} else if (menuIndex == 2) {
			System.out.print("输入需要修改的用户位置:>");
			i = scanner.nextInt();
			scanner.nextLine();
			if (i > dateBase.getUserNum())
				System.out.println("无此用户");
			else {
				System.out.print("输入修改的用户id:>");
				u_id = scanner.nextLine();
				System.out.print("输入修改的用户密码:>");
				u_password = scanner.nextLine();
				System.out.print("输入修改的用户姓名:>");
				u_name = scanner.nextLine();
				System.out.print("输入修改的用户性别:>");
				gender = scanner.nextLine();
				System.out.print("输入修改的用户年龄:>");
				age = scanner.nextInt();
				scanner.nextLine();
				System.out.print("输入修改的用户存款:>");
				money = scanner.nextDouble();
				scanner.nextLine();
				/**
				 * 更新用户
				 */
				dateBase.updateUser(new User(u_id, u_password, u_name, gender, age, money), i);
			}
		} else if (menuIndex == 3) {
			System.out.print("输入需要删除的用户位置:>");
			i = scanner.nextInt();
			scanner.nextLine();
			if (i > dateBase.getUserNum())
				System.out.println("无此用户");
			else {
				dateBase.deleteUser(i); //删除用户
			}
		} else if (menuIndex == 4) {
			System.out.print("输入添加的用户id:>");
			u_id = scanner.nextLine();
			System.out.print("输入添加的用户密码:>");
			u_password = scanner.nextLine();
			System.out.print("输入添加的用户姓名:>");
			u_name = scanner.nextLine();
			System.out.print("输入添加的用户性别:>");
			gender = scanner.nextLine();
			System.out.print("输入添加的用户年龄:>");
			age = scanner.nextInt();
			scanner.nextLine();
			System.out.print("输入添加的用户存款:>");
			money = scanner.nextDouble();
			scanner.nextLine();
			/**
			 * 添加用户
			 */
			dateBase.insertUser(new User(u_id, u_password, u_name, gender, age, money));
		} else
			System.out.println("菜单输入错误,请重新输入");
	}

	/**
	 * 用户模式
	 * @param menuIndex 菜单编号
	 * @param users_index   用户在数据库位置
	 */
	public void user(Integer menuIndex, Integer users_index) {
		/**
		 * 用户信息
		 */
		String u_id;
		String u_password;
		String u_name;
		String gender;
		Integer age;
		Double money;
		if (menuIndex == 2) {
			System.out.print("输入取款数:>");
			money = scanner.nextDouble();
			scanner.nextLine();
			dateBase.withdrawal(money, users_index);//取钱
		} else if (menuIndex == 1) {
			System.out.print("输入存款数:>");
			money = scanner.nextDouble();
			dateBase.saving(money, users_index);    //存钱
		} else if (menuIndex == 3) {
			dateBase.showUser(users_index);
		} else if (menuIndex == 4) {
			System.out.print("输入修改的用户id:>");
			u_id = scanner.nextLine();
			System.out.print("输入修改的用户密码:>");
			u_password = scanner.nextLine();
			System.out.print("输入修改的用户姓名:>");
			u_name = scanner.nextLine();
			System.out.print("输入修改的用户性别:>");
			gender = scanner.nextLine();
			System.out.print("输入修改的用户年龄:>");
			age = scanner.nextInt();
			scanner.nextLine();
			System.out.print("输入修改的用户存款:>");
			money = scanner.nextDouble();
			scanner.nextLine();
			/**
			 * 更新信息
			 */
			dateBase.updateUser(new User(u_id, u_password, u_name, gender, age, money), users_index);
		} else
			System.out.println("菜单输入错误,请重新输入");
	}
}
