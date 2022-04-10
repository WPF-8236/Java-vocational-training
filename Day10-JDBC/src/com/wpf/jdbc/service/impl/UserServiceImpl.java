package com.wpf.jdbc.service.impl;

import com.wpf.jdbc.dao.UserDao;
import com.wpf.jdbc.dao.UserDaoImpl;
import com.wpf.jdbc.domain.JDBC;
import com.wpf.jdbc.domain.User;
import com.wpf.jdbc.service.UserService;
import com.wpf.jdbc.util.DButil;
import com.wpf.jdbc.util.PageModel;
import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
	private PageModel<User> userPageModel;

	@Override
	public int save(User user) {
		JDBC jdbc = new JDBC();
		UserDao userDao = new UserDaoImpl();
		int num = 0;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			num = userDao.insert(jdbc, user);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return num;
	}

	@Override
	public int change(User user) {
		JDBC jdbc = new JDBC();
		UserDao userDao = new UserDaoImpl();
		int num = 0;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			num = userDao.update(jdbc, user);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return num;
	}

	@Override
	public int delete(User user) {
		JDBC jdbc = new JDBC();
		UserDao userDao = new UserDaoImpl();
		int num = 0;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			num = userDao.delete(jdbc, user);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return num;
	}

	@Override
	public List<User> get() {
		JDBC jdbc = new JDBC();
		UserDao userDao = new UserDaoImpl();
		List<User> users = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			users = userDao.getUsers(jdbc);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return users;
	}

	@Override
	public List<User> getUsersLimit(int pageSize, int currentPage) {
		JDBC jdbc = new JDBC();
		UserDao userDao = new UserDaoImpl();
		List<User> users = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			userPageModel = userDao.userModel(jdbc, pageSize, currentPage);
			users = userPageModel.getList();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return users;
	}

	@Override
	public List<User> getUsersLimitUpPage() {
		JDBC jdbc = new JDBC();
		UserDao userDao = new UserDaoImpl();
		List<User> users = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			userPageModel = userDao.userModel(jdbc, userPageModel.getPageSize(), userPageModel.getPageUp());
			users = userPageModel.getList();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return users;
	}

	@Override
	public List<User> getUsersLimitDownPage() {
		JDBC jdbc = new JDBC();
		UserDao userDao = new UserDaoImpl();
		List<User> users = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			userPageModel = userDao.userModel(jdbc, userPageModel.getPageSize(), userPageModel.getPageDown());
			users = userPageModel.getList();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return users;
	}
}
