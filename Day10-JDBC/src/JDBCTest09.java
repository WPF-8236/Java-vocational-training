import java.sql.*;
import java.util.ResourceBundle;

public class JDBCTest09 {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		String driver = resourceBundle.getString("driver");
		String url = resourceBundle.getString("url");
		String user = resourceBundle.getString("user");
		String password = resourceBundle.getString("password");

		try {
			Class.forName(driver);
			connection= DriverManager.getConnection(url,user,password);
			String sql="insert into t_user(t_user_idname,t_user_password,t_user_name) values(?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,"wangpanfeng");
			preparedStatement.setString(2,"123");
			preparedStatement.setString(3,"王潘锋");
			int coun=preparedStatement.executeUpdate();

			System.out.println(coun);
		} catch (SQLException | ClassNotFoundException throwables) {
			throwables.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		}


	}
}
