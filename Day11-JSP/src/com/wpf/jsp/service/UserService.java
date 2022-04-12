package com.wpf.jsp.service;

import com.wpf.jsp.domain.User;

import java.util.List;

public interface UserService {

	int save(User user);

	int change(User user);

	int delete(User user);

	User getUserByUser(User user);

	List<User> get();

	User getOne(String id);

	List<User> getUsersLimit(int pageSize, int currentPage);

	List<User> getUsersLimitFirst();

	List<User> getUsersLimitEnd();

	List<User> getUsersLimitUpPage();

	List<User> getUsersLimitDownPage();
}
