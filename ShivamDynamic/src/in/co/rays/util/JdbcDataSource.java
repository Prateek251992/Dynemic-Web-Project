package in.co.rays.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public final class JdbcDataSource {

	private static JdbcDataSource jds = null;
	private ComboPooledDataSource cpds = null;

	private JdbcDataSource() {
		try {
			ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.appn");
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass(rb.getString("Driver"));
			cpds.setJdbcUrl(rb.getString("Url"));
			cpds.setUser(rb.getString("User"));
			cpds.setPassword(rb.getString("Password"));
			cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initial")));
			cpds.setAcquireIncrement(Integer.parseInt(rb.getString("increment")));
			cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxpool")));

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private static JdbcDataSource getinstance() {
		if (jds == null) {
			jds = new JdbcDataSource();
		}
		return jds;

	}

	public static Connection getConnection() {
		try {
			return getinstance().cpds.getConnection();
		} catch (SQLException e) {
			return null;
		}

	}

	public static void CloseConnection(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void CloseConnection(Connection conn, Statement stmt) {
		CloseConnection(conn, stmt, null);

	}

	public static void CloseConnection(Connection conn) {
		CloseConnection(conn, null, null);
	}

}
