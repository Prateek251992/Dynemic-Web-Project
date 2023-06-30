package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JdbcDataSource;

public class UserModel {

	public Integer nextPK() throws Exception {
		int PK = 0;
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("Select max(id) from user");
		ResultSet rs = ps.executeQuery();
		while (rs.next())
			PK = rs.getInt(1);

		return PK + 1;

	}

	public void add(UserBean bean) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?,?,?)");

		ps.setInt(1, nextPK());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setString(6, bean.getAddress());

		int i = ps.executeUpdate();

		System.out.println("Data Inserted " + i);

	}

	public void delete(int id) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");
		ps.setInt(1, id);
		int i = ps.executeUpdate();

	}

	public List search() throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user");
		ResultSet rs = ps.executeQuery();

		ArrayList list = new ArrayList();
		while (rs.next()) {

			UserBean bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));

			list.add(bean);

		}
		return list;

	}

	public void update(UserBean Bean) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"update user set First_Name=?,Last_name=?, Login_Id=?, Password=?,Address=? where Id = ?");
		
		ps.setString(1, Bean.getFirstName());
		ps.setString(2, Bean.getLastName());
		ps.setString(3, Bean.getLoginId());
		ps.setString(4, Bean.getPassword());
		ps.setString(5, Bean.getAddress());
		ps.setInt(6, Bean.getId());
		int i = ps.executeUpdate();
		System.out.println("Data Updated " + i);

	}

	public UserBean findById(int id) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
		}
		return bean;
	}

	public UserBean authenticcate(String login, String password) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where Login_Id =? and Password = ?");
		ps.setString(1, login);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
		}

		return bean;

	}

}
