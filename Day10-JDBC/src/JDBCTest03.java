import java.sql.*;

/*
注册驱动的另一种方式--常用方式
 */
public class JDBCTest03 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			//1.注册驱动
			/*Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);*/
			//注册驱动的第二种方式,为什么这种方式常用?因为参数是一个字符串,字符串可以写到xxx.properties文件中
			//以下方式不需要接受返回值,只需要进行类加载行为
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.获取连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tianyan?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
					"root", "WPF@8236");
			System.out.println(connection);
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
