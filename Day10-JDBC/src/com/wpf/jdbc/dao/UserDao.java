package com.wpf.jdbc.dao;

import com.wpf.jdbc.domain.JDBC;
import com.wpf.jdbc.domain.User;
import com.wpf.jdbc.util.PageModel;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
	int insert(JDBC jdbc, User user) throws Exception;

	int update(JDBC jdbc, User user) throws Exception;

	int delete(JDBC jdbc, User user) throws Exception;

	List<User> getUsers(JDBC jdbc) throws Exception;

	PageModel<User> userModel(JDBC jdbc,int pageSize,int currentPage)throws Exception;
}
