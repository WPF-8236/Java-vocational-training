import java.sql.*;

/*
JDBC完成insert
 */
public class JDBCTest01 {
	public static void main(String[] args) {
		Statement statement = null;
		Connection connection = null;
		try {
			//1.注册驱动
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//2.获取链接
			/*
				url:统一资源定位符(网络中某个资源的绝对路径)
			 */
			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/tianyan?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
					"root", "WPF@8236"
			);
			System.out.println("数据库连接对象 = " + connection);
			//3.获取数据库操作对象
			statement = connection.createStatement();
			//4.执行sql
			String sql = "insert into my_user(userName,password) values('王潘锋','123')";
			//专门执行DML语句的(insert delete update)
			//返回值是"影响数据库中的记录条数"
			//5.处理查询结果
			int count = statement.executeUpdate(sql);
			System.out.println(count == 1 ? "保存成功" : "保存失败");
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
