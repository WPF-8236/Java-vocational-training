
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 开启查询事务并使用行级锁，锁住相关记录
 */
public class JDBCTest12 {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnecttion();
			connection.setAutoCommit(false);

			String sql = "select * from emp where job = ? for update";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "MANAGER");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
				System.out.println(resultSet.getString("ename") + "," +
						resultSet.getString("job") +
						"," + resultSet.getDouble("sal"));
			connection.commit();
		} catch (SQLException throwables) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			throwables.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
	}
}
