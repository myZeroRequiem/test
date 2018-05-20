package bbs.dao;

import java.sql.*;
import java.util.ArrayList;

import bbs.db.dbConnection;
//import bbs.javabean.Fans;
import bbs.javabean.User;

public class FansDao {
	Connection conn = dbConnection.getConnection();

	PreparedStatement ps = null;

	ResultSet rs = null;

	public int getFansSum(String uid) {
		int i = 0;
		try {
			String sql = "select count(*) as fans from fans where uid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			rs.next();
			i = rs.getInt("fans");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(ps);
			dbConnection.close(conn);
		}
		return i;
	}

	public int getfollowsSum(String uid) {
		int i = 0;
		try {
			String sql = "select count(*) as follows from fans where fansid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			rs.next();
			i = rs.getInt("follows");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbConnection.close(ps);
			dbConnection.close(conn);
		}
		return i;
	}
	//获取粉丝信息
	public ArrayList<User> getFans(String uid){
		ArrayList<User> user=new ArrayList<User>();
		try{
			String sql="select * from fans where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs=ps.executeQuery();
			while(rs.next()){
				String fansid=rs.getString(3);
				UserDao ud=new UserDao();
				User u=ud.getInfo(fansid);
				user.add(u);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbConnection.close(ps);
			dbConnection.close(conn);
		}
		return user;
	}
	//获取关注的信息
	public ArrayList<User> getFollows(String uid){
		ArrayList<User> user=new ArrayList<User>();
		try{
			String sql="select * from fans where fansid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs=ps.executeQuery();
			while(rs.next()){
				String followsid=rs.getString(2);
				UserDao ud=new UserDao();
				User u=ud.getInfo(followsid);
				user.add(u);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbConnection.close(ps);
			dbConnection.close(conn);
		}
		return user;
	}
	public boolean addFans(String uid,String fansid){
		boolean result=false;
		try{
			String sql="insert into fans (uid,fansid)value(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, fansid);
			ps.setString(2, uid);
			int i=ps.executeUpdate();
			if(i==1){
				result=true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbConnection.close(ps);
			dbConnection.close(conn);
		}
		return result;
	}
	//删除关注用户，uid为用户，followid为该用户要取消关注的用户id
	public boolean deleteFans(String uid,String followsid){
		boolean result=false;
		try{
			String sql="delete from fans where uid=?and fansid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, followsid );
			ps.setString(2, uid);
			int i=ps.executeUpdate();
			if(i>0){
				result=true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbConnection.close(ps);
			dbConnection.close(conn);
		}
		return result;
	}
	//查询是否已关注
	public boolean isFollows(String uid,String followsid){
		boolean result=false;
		try{
			String sql="select * from fans where uid=?and fansid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, followsid );
			ps.setString(2, uid);
			rs=ps.executeQuery();
			while(rs.next()){
				result=true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbConnection.close(ps);
			dbConnection.close(conn);
		}
		return result;
	}
	
	//删除用户时删除该用户的粉丝及关注
	public boolean deleteUser(String uid){
		boolean result=false;
		try{
			String sql="delete from fans where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			int i=ps.executeUpdate();
			if(i>0){
				result=true;
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
