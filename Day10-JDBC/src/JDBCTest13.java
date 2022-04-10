
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 修改锁定的记录
 */
public class JDBCTest13 {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int count;

		try {
			connection = DBUtil.getConnecttion();
			connection.setAutoCommit(false);
			String sql = "update emp set sal = sal *1.1 where job = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "MANAGER");
			count = preparedStatement.executeUpdate();
			System.out.println(count);
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
			DBUtil.close(connection, preparedStatement, null);
		}
	}
}
