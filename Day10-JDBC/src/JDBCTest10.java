/**
 * 作者：王潘锋
 * <p>
 * sql脚本：
 * drop table if exists t_act;
 * create table t_act (
 * actno int,
 * balance double(7,2) //7:有效数位，2:小数位数
 * );
 * insert into t_act(actno,balance) values(111,2222);
 * insert into t_act(actno,balance) values(222,0);
 * commit;
 * select * from t_act;
 *
 *
 * 重点代码
 * connection.setAutoCommit(false);
 * connection.rollback;
 * connection.commit;
 *
 */

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCTest10 {
	public static void main(String[] args) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		String driver = resourceBundle.getString("driver");
		String url = resourceBundle.getString("url");
		String user = resourceBundle.getString("user");
		String password = resourceBundle.getString("password");

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//注册驱动
			Class.forName(driver);
			//获取链接
			connection = DriverManager.getConnection(url, user, password);
			//将自动提交机制修改为手动提交
			connection.setAutoCommit(false);
			//获取预编译数据库操作对象
			String sql = "update t_act set balance = ? where actno = ?";
			preparedStatement = connection.prepareStatement(sql);
			//给赋值位赋值
			preparedStatement.setInt(2, 111);
			preparedStatement.setDouble(1, 100000);
			//提交执行sql
			int count = preparedStatement.executeUpdate();

			String s = null;
			s.toString();


			//给赋值位赋值
			preparedStatement.setInt(2, 222);
			preparedStatement.setDouble(1, 100000);
			//提交执行sql
			count += preparedStatement.executeUpdate();

			connection.commit();
		} catch (ClassNotFoundException | SQLException e) {
			//回滚事务
			if(connection!=null) {
				try {
					connection.rollback();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}

			e.printStackTrace();
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
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		}
	}
}
