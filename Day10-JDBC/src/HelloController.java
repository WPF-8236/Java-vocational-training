import java.sql.*;

public class HelloController {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//加载数据库驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//建立连接:实际上是用驱动管理去获取一个连接
			connection = DriverManager.getConnection(
//					数据库的地址
					"jdbc:mysql://127.0.0.1:3306/tianyan?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
//					账号
					"root",
//					密码
					"WPF@8236"
			);
			//准备一个sql语句
			String sql = "insert into my_user(userName,password) values(?,?)";
			//准备一个执行器，预编译
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "王潘锋");
			preparedStatement.setString(2, "123");
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
