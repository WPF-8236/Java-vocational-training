package com.wpf.jsp.service.impl;

import com.wpf.jsp.dao.UserDao;
import com.wpf.jsp.dao.UserDaoImpl;
import com.wpf.jsp.domain.JDBC;
import com.wpf.jsp.domain.User;
import com.wpf.jsp.service.UserService;
import com.wpf.jsp.util.DButil;
import com.wpf.jsp.util.PageModel;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
	private PageModel<User> userPageModel;
	private static UserServiceImpl userService;

	private UserServiceImpl() {

	}

	private static class Inner {
		static final UserServiceImpl userService = new UserServiceImpl();
	}

	public static UserServiceImpl getUserService() {
		return Inner.userService;
	}

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
	public User getUserByUser(User user) {
		JDBC jdbc = new JDBC();
		UserDao userDao = new UserDaoImpl();
		User user1 = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			user1 = userDao.selectUserByUser(jdbc, user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return user1;

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
	public User getOne(String id) {
		JDBC jdbc = new JDBC();
		UserDao userDao = new UserDaoImpl();
		User user = null;
		try {
			jdbc.setConnection(DButil.getConnecttion());
			user = userDao.getUser(jdbc, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(jdbc);
		}
		return user;
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
	public List<User> getUsersLimitFirst() {
		return this.getUsersLimit(userPageModel.getPageSize(), 1);
	}

	@Override
	public List<User> getUsersLimitEnd() {
		return this.getUsersLimit(userPageModel.getPageSize(), userPageModel.getTotalPage());
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
