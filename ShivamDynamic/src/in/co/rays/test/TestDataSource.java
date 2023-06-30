package in.co.rays.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JdbcDataSource;

public class TestDataSource {

	public static void main(String[] args) throws Exception {

		for (int i = 1; i < 25; i++) {
			System.out.println("Connection = " + i);
			testDcp(1);
			System.out.println("============================");

		}

	}

	private static void testDcp(int id) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from marksheet where id = ?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		UserBean Bean = null;

		while (rs.next()) {

			Bean = new UserBean();

			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getInt(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
	}

}
