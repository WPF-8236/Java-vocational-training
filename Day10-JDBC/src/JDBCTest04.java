import java.sql.*;
import java.util.ResourceBundle;

//将连接数据库的所有信息配置到配置文件中
public class JDBCTest04 {
	public static void main(String[] args) {
		//使用资源绑定器定属性配置文件
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		Connection connection = null;
		try {
			//1.注册驱动
			Class.forName(driver);
			//2.获取链接
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接对象 = " + connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//6.释放资源
			//为了保证资源一定释放,在finally语句块中关闭资源
			//并且要遵循从小到大依次关闭
			//分别对其try..catch
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
