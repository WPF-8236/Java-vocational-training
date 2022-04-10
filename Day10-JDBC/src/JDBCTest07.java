import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * 作者:王潘锋
 */
public class JDBCTest07 {
	public static void main(String[] args) {

		Map<String, String> userLoginInfo = initUI();
		boolean loginSuccess = login(userLoginInfo);
		System.out.println(loginSuccess ? "登录成功" : "登录失败");

	}

	/**
	 * 用户登录
	 *
	 * @param userLoginInfo 用户登录信息
	 * @return 是否成功
	 */
	private static boolean login(Map<String, String> userLoginInfo) {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		boolean loginSuccess = false;

		Connection conn = null;
		PreparedStatement stmt = null;//预编译数据库
		ResultSet rs = null;
		try {
			//1.注册驱动
			//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName(driver);
			//2.获取链接
			conn = DriverManager.getConnection(url, user, password);
			//3.获取预编译数据库操作对象
			String sql = "select * from my_user where userName = ? and password = ?";
			stmt = conn.prepareStatement(sql);
			//给占位符传值（下标从1开始）
			stmt.setString(1, userLoginInfo.get("LoginName"));
			stmt.setString(2, userLoginInfo.get("LoginPwd"));
			//4.执行sql
			rs = stmt.executeQuery();
			//5.处理查询结果
			if (rs.next())
				loginSuccess = true;
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

	/**
	 * 初始化
	 *
	 * @return 用户登录信息
	 */
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
