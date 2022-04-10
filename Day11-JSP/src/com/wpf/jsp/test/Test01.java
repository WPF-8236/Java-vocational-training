package com.wpf.jsp.test;

import com.wpf.jsp.domain.User;
import com.wpf.jsp.service.UserService;
import com.wpf.jsp.service.impl.UserServiceImpl;

import java.util.List;

public class Test01 {
	public static void main(String[] args) {
//		User user = new User("123", "123");
//		userService.save(user);
//		User user = new User(4, "wpf", "wpf");
//		userService.change(user);
//		User user = new User(4);
//		userService.delete(user);
//		List<User> users = userService.get();
//		System.out.println(users);
		UserService userService = new UserServiceImpl();
		List<User> users1 = userService.getUsersLimit(2, 2);
		List<User> users2 = userService.getUsersLimitUpPage();
		List<User> users3 = userService.getUsersLimitDownPage();
		System.out.println(users1);
		System.out.println(users2);
		System.out.println(users3);
	}

}
