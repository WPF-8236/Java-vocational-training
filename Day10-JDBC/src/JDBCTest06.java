import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class JDBCTest06 {
	public static void main(String[] args) {

		Map<String, String> userLoginInfo = initUI();
		boolean loginSuccess = login(userLoginInfo);
		System.out.println(loginSuccess ? "登录成功" : "登录失败");

	}

	private static boolean login(Map<String, String> userLoginInfo) {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		boolean loginSuccess = false;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//1.注册驱动
			//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName(driver);
			//2.获取链接
			conn = DriverManager.getConnection(url, user, password);
			//3.获取数据库操作对象
			stmt = conn.createStatement();
			//4.执行sql
			String sql = "select * from my_user where userName='"+
					userLoginInfo.get("LoginName")+"' and password='"+userLoginInfo.get("LoginPwd")+"'";
			rs = stmt.executeQuery(sql);
			//5.处理查询结果
			if (rs.next())
				loginSuccess=true;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//6.释放资源
			//从小到大关闭,分别对其try...catch
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return loginSuccess;
	}

	private static Map<String, String> initUI() {
		Map<String, String> userLoginInfo = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		System.out.print("用户名：");
		userLoginInfo.put("LoginName", scanner.nextLine());
		System.out.print("密码：");
		userLoginInfo.put("LoginPwd", scanner.nextLine());
		return userLoginInfo;
	}
}