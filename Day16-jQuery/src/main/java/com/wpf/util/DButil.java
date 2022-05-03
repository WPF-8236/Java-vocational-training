package com.wpf.util;

import com.wpf.domain.JDBC;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC简化类
 */
public class DButil {
	/**
	 * 工具类的构造方法私有化
	 */
	private DButil() {
	}

	//静态代码块类加载时执行且执行一次
	static {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		String driver = resourceBundle.getString("driver");
		try {
			Class.forName(driver);
//			System.out.println("工具--获取驱动");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接对象
	 *
	 * @return 返回数据库连接对象
	 * @throws SQLException
	 */
	public static Connection getConnecttion() throws SQLException {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		String url = resourceBundle.getString("url");
		String user = resourceBundle.getString("user");
		String password = resourceBundle.getString("password");
//		System.out.println("工具--获取连接");
		return DriverManager.getConnection(url, user, password);
	}

	public static void close(JDBC jdbc) {
		ResultSet resultSet = jdbc.getResultSet();
		Statement statement = jdbc.getStatement();
		Connection connection = jdbc.getConnection();
		if (resultSet != null) {
			try {
				resultSet.close();
//				System.out.println("工具--" + resultSet + "关闭");
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
//				System.out.println("工具--" + statement + "关闭");
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
//				System.out.println("工具--" + connection + "关闭");
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}
}
