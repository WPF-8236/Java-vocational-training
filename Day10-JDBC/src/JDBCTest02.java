import java.sql.*;

/*
JDBC完成delete
 */
public class JDBCTest02 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			//1.注册驱动
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//2.获取连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tianyan?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
					"root", "WPF@8236");
			//3.获取数据库操作对象
			statement = connection.createStatement();
			//4.执行sql语句
			/*String sql = "delete from my_user where id=1";
			int count = statement.executeUpdate(sql);
			System.out.println(count == 1 ? "删除成功" : "删除失败");*/
			/*String sql = "update  my_user set password='123456' where id = 2";
			int count = statement.executeUpdate(sql);
			System.out.println(count == 1 ? "修改成功" : "修改失败");*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6.释放资源
			//为了保证资源一定释放,在finally语句块中关闭资源
			//并且要遵循从小到大依次关闭
			//分别对其try..catch
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
