package com.wpf.service.impl;

import com.wpf.service.UserService;

public class UserServiceProxy implements UserService {
	UserService userService = new UserServiceImpl();

	@Override
	public void save(String name) {
		System.out.println("hello 你好！");
		userService.save(name);
		System.out.println("再见！");
	}

	@Override
	public void update(String name) {
		System.out.println("hello 你好！");
		userService.update(name);
		System.out.println("再见！");
	}
}
