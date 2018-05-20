package bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bbs.db.dbConnection;
import bbs.javabean.Type;


public class TypeDao {
	Connection conn = dbConnection.getConnection();

	PreparedStatement ps = null;

	ResultSet rs = null;
	
	public ArrayList<Type> getType(){
		ArrayList<Type> type=new ArrayList<Type>();
		conn=dbConnection.getConnection();
		try{
			String sql="select * from type";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Type t=new Type();
				t.setTypeid(rs.getInt(1));
				t.setType(rs.getString(2));
				type.add(t);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return type;
	}
	public boolean addType(Type t) {
		ps = null;
		boolean result = false;
		try {
			String sql = "insert into Type(typeid,type)value(?,?)";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, t.getTypeid());
			ps.setString(2, t.getType());
			
			int i = ps.executeUpdate();
			if (i == 1) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(ps);
			dbConnection.close(conn);
		}
		return result;
	}
}
