package com.WPF.BankingPprojects;

import java.util.Arrays;

public class DateBase {
	public static final int MAX_NUM = 101;  //数据库最大数量
	private static User[] users;            //数据库用户
	private int userNum;                    //数据库用户数量

	/**
	 * 初始化数据库
	 * 初始化数据库用户数量
	 */
	public DateBase() {
		userNum = 5;
		initializeDate();
	}

	public DateBase(User[] users) {
		this.users = users;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	@Override
	public String toString() {
		return "DateBase{" +
				"users=" + Arrays.toString(users) +
				'}';
	}


	/**
	 * 初始化数据库用户信息
	 */
	public void initializeDate() {
		users = new User[MAX_NUM];
		users[0] = new User("admin", "admin", "admin", "admin", 0, 0.0);
		users[1] = new User("1", "1", "张三", "男", 23, 355.5);
		users[2] = new User("2", "2", "王五", "男", 24, 357.5);
		users[3] = new User("3", "3", "李四", "男", 25, 35.52);
		users[4] = new User("4", "4", "潘六", "男", 26, 35.05);
		users[5] = new User("5", "5", "小二", "男", 27, 350.5);
	}

	/**
	 * 检查是否存在用户
	 *
	 * @param u_id       用户id
	 * @param u_password 用户密码
	 * @return 用户在数据库的下标
	 */
	public int checkUser(String u_id, String u_password) {
		int i = -1;
		for (int j = 0; j <= userNum; j++) {
			if (users[j].getU_id().equals(u_id) && users[j].getU_password().equals(u_password))
				return j;
		}
		return i;
	}

	public int checkUser(String u_id) {
		int i = -1;
		for (int j = 0; j <= userNum; j++) {
			if (users[j].getU_id().equals(u_id))
				return j;
		}
		return i;
	}

	/**
	 * 展示所有用户
	 */
	public void showAllUsers() {
		for (int i = 1; i <= userNum; i++) {
			System.out.println(users[i]);
		}
	}

	/**
	 * 更新用户在数据库的信息
	 *
	 * @param user 新的用户对象数据
	 * @param i    //用户在数据库中的下标
	 */
	public void updateUser(User user, int i) {
		users[i] = user;
	}


	/**
	 * 删除用户
	 *
	 * @param i 用户下标
	 */
	public void deleteUser(int i) {
		for (int j = i; j < userNum; j++) {
			users[j] = users[j + 1];
		}
		userNum--;
	}

	/**
	 * 添加用户
	 *
	 * @param user 需要添加用户信息
	 */
	public void insertUser(User user) {
		if (checkUser(user.getU_id()) == -1) {
			userNum++;
			users[userNum] = user;
		} else
			System.out.println("用户已存在");
	}

	/**
	 * 取钱
	 *
	 * @param money       取钱数目
	 * @param users_index 用户下标
	 */
	public void withdrawal(Double money, Integer users_index) {
		if (money <= 0) {
			System.out.println("请输入正确金额");
		} else {
			Double u_money = users[users_index].getMoney();
			if (u_money < money)
				System.out.println("余额不足");
			else {
				System.out.println("取款 " + money + "元");
				users[users_index].setMoney(u_money - money);
			}
		}
	}

	/**
	 * 存钱
	 *
	 * @param money       存钱数据
	 * @param users_index 用户下标
	 */
	public void saving(Double money, Integer users_index) {
		if (money <= 0) {
			System.out.println("请输入正确金额");
		} else {
			Double u_money = users[users_index].getMoney();
			users[users_index].setMoney(u_money + money);
		}
	}

	/**
	 * 展示某一个用户信息
	 *
	 * @param users_index 用户下标
	 */
	public void showUser(Integer users_index) {
		System.out.println(users[users_index]);
	}
}

