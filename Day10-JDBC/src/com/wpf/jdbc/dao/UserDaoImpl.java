package com.wpf.jdbc.dao;

import com.wpf.jdbc.domain.JDBC;
import com.wpf.jdbc.domain.User;
import com.wpf.jdbc.util.PageModel;
import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
	@Override
	public int insert(JDBC jdbc, User user) throws Exception {
		String sql = "insert into my_user(userName,password) values (?,?)";
		Object[] params = {user.getUserName(), user.getPassword()};
		return this.exeUpdate(jdbc, sql, params);
	}

	@Override
	public int update(JDBC jdbc, User user) throws Exception {
		String sql = "update my_user set userName = ?,password = ? where id = ?";
		Object[] params = {user.getUserName(), user.getPassword(), user.getId()};
		return this.exeUpdate(jdbc, sql, params);
	}

	@Override
	public int delete(JDBC jdbc, User user) throws Exception {
		String sql = "delete from my_user where id = ?";
		Object[] params = {user.getId()};
		return this.exeUpdate(jdbc, sql, params);
	}

	@Override
	public List<User> getUsers(JDBC jdbc) throws Exception {
		List<User> users = new ArrayList<>();
		String sql = "select * from my_user";
		ResultSet resultSet = this.exeQuery(jdbc, sql, null);
		while (resultSet.next()) {
			User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			users.add(user);
		}
		return users;
	}

	@Override
	public PageModel<User> userModel(JDBC jdbc, int pageSize, int currentPage) throws Exception {
		String sql = "select * from my_user limit ?,?";
		Object[] params = {(currentPage - 1) * pageSize, pageSize};
		ResultSet resultSet = this.exeQuery(jdbc, sql, params);
		PageModel<User> pageModel = new PageModel<>();
		List<User> users = new ArrayList<>();
		while (resultSet.next()) {
			User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			users.add(user);
		}
		pageModel.setList(users);
		pageModel.setCurrentPage(currentPage);
		pageModel.setPageSize(pageSize);
		String table = "select count(*) from my_user";
		pageModel.setTotalRecord(this.getTotalDate(jdbc, table, null));
		return pageModel;
	}
}
