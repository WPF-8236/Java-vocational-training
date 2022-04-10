import java.sql.*;
import java.util.ResourceBundle;

//将连接数据库的所有信息配置到配置文件中
public class JDBCTest05 {
	public static void main(String[] args) {
		//使用资源绑定器定属性配置文件
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		ResultSet resultSet = null;
		Statement statement = null;
		Connection connection = null;
		try {
			//1.注册驱动
			Class.forName(driver);
			//2.获取链接
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接对象 = " + connection);
			//3.获取数据库操作对象
			statement = connection.createStatement();
			//4.执行sql
			String sql = "select * from my_user";
			resultSet = statement.executeQuery(sql);
			//5.处理查询结果
			while (resultSet.next()) {
//				int id = resultSet.getInt(1);
//				String userName = resultSet.getString(2);
//				String password2 = resultSet.getString(3);
				int id = resultSet.getInt("id");
				String userName = resultSet.getString("userName");
				String password2 = resultSet.getString("password");
				System.out.println(id + "\t" + userName + "\t" + password2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//6.释放资源
			//为了保证资源一定释放,在finally语句块中关闭资源
			//并且要遵循从小到大依次关闭
			//分别对其try..catch
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
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
