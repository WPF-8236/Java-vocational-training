
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 作者：王潘锋
 * 测试DBUtil
 * 模糊查询
 */
public class JDBCTest11 {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//获取连接
			connection = DBUtil.getConnecttion();
			//获取预编译数据库操作对象
			String sql = "select ename from emp where ename like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "_A%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
				System.out.println(resultSet.getString("ename"));
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			//释放资源
			DBUtil.close(connection, preparedStatement, resultSet);
		}
	}
}
