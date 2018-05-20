package bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bbs.db.dbConnection;
import bbs.javabean.Admin;

public class AdminDao {
	Connection conn = dbConnection.getConnection();

	PreparedStatement ps = null;

	ResultSet rs = null;
	
	public boolean login(Admin a){
		boolean result=false;
		try{
			String sql="select * from admin where admin=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, a.getAdmin());
			ps.setString(2, a.getPassword());
			rs=ps.executeQuery();
			while(rs.next()){
				result=true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(ps);
			dbConnection.close(rs);
			dbConnection.close(conn);
		}
		return result;
	}
	
	
	
}
