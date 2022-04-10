package com.wpf.jdbc.service;

import com.wpf.jdbc.domain.User;
import com.wpf.jdbc.util.PageModel;

import java.util.List;

public interface UserService {

	int save(User user);

	int change(User user);

	int delete(User user);

	List<User> get();

	List<User> getUsersLimit(int pageSize, int currentPage);

	List<User> getUsersLimitUpPage();

	List<User> getUsersLimitDownPage();
}
