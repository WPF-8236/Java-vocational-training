package com.wpf.dao;

import com.wpf.domain.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	public int exeUpdate(JDBC jdbc, String sql, Object[] params) throws Exception {
		Connection connection = jdbc.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		jdbc.setStatement(preparedStatement);
		int num = 0;
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				preparedStatement.setObject(i + 1, params[i]);
			}
			num = preparedStatement.executeUpdate();
		}
		return num;
	}

	public ResultSet exeQuery(JDBC jdbc, String sql, Object[] params) throws Exception {
		Connection connection = jdbc.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		jdbc.setStatement(preparedStatement);
		preparedStatement = connection.prepareStatement(sql);
		if (params != null)
			for (int i = 0; i < params.length; i++)
				preparedStatement.setObject(i + 1, params[i]);
		ResultSet resultSet = preparedStatement.executeQuery();
		jdbc.setResultSet(resultSet);
		return resultSet;
	}


	public int getTotalDate(JDBC jdbc, String sql, Object[] params) throws Exception {
		ResultSet resultSet = this.exeQuery(jdbc, sql, params);
		if (resultSet.next())
			return resultSet.getInt(1);
		else
			return 0;
	}
}
