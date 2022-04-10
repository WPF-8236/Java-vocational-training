import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC简化类
 */
public class DBUtil {
	/**
	 * 工具类的构造方法私有化
	 */
	private DBUtil() {
	}

	//静态代码块类加载时执行且执行一次
	static {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		String driver = resourceBundle.getString("driver");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接对象
	 * @return  返回数据库连接对象
	 * @throws SQLException
	 */
	public static Connection getConnecttion() throws SQLException{
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		String url = resourceBundle.getString("url");
		String user = resourceBundle.getString("user");
		String password = resourceBundle.getString("password");
		return DriverManager.getConnection(url, user, password);
	}

	public static void close(Connection connection, Statement statement, ResultSet resultSet){
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
