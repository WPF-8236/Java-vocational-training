package com.wpf.jsp.dao;

import com.wpf.jsp.domain.JDBC;
import com.wpf.jsp.domain.User;
import com.wpf.jsp.util.PageModel;

import java.util.List;

public interface UserDao {
	int insert(JDBC jdbc, User user) throws Exception;

	int update(JDBC jdbc, User user) throws Exception;

	int delete(JDBC jdbc, User user) throws Exception;

	List<User> getUsers(JDBC jdbc) throws Exception;

	PageModel<User> userModel(JDBC jdbc, int pageSize, int currentPage) throws Exception;

	User selectUserByUser(JDBC jdbc, User user) throws Exception;

	User getUser(JDBC jdbc, String id) throws Exception;
}
