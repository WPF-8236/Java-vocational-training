package com.wpf.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public JDBC() {
	}

	public JDBC(Connection connection, Statement statement, ResultSet resultSet) {
		this.connection = connection;
		this.statement = statement;
		this.resultSet = resultSet;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
}
