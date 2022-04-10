import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class JDBCTest08 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入“desc”或“asc”来选择升序或降序查询：");
		String keyWords = scanner.nextLine();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		String driver = resourceBundle.getString("driver");
		String url = resourceBundle.getString("url");
		String user = resourceBundle.getString("user");
		String password = resourceBundle.getString("password");

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			String sql = "select userName from my_user order by userName " + keyWords;
			resultSet = statement.executeQuery(sql);
			while (resultSet.next())
				System.out.println(resultSet.getString("userName"));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		}

	}
}
