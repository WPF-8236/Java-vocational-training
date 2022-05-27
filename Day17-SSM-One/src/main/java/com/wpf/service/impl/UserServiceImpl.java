package com.wpf.service.impl;

import com.wpf.service.UserService;

public class UserServiceImpl implements UserService {
	@Override
	public void save(String name) {
		System.out.println("添加用户" + name);
	}

	@Override
	public void update(String name) {
		System.out.println("更新用户" + name);
	}
}
