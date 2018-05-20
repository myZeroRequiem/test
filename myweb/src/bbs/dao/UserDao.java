package bbs.dao;

import java.sql.*;
import java.util.ArrayList;

import bbs.db.dbConnection;
import bbs.dao.ImgDao;
import bbs.javabean.User;
import bbs.dao.FansDao;

public class UserDao {
	Connection conn = dbConnection.getConnection();

	PreparedStatement ps = null;

	ResultSet rs = null;

	//用户注册
	public boolean adduser(User u) {
		ps = null;
		boolean result = false;
		try {
			String sql = "insert into user(uid,uname,sex,password,email)value(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);

			ps.setString(1, u.getUid());
			ps.setString(2, u.getUname());
			ps.setInt(3, u.getSex());
			ps.setString(4, u.getPassword());
			//ps.setString(5, "12s34");
			ps.setString(5, u.getEmail());
			//ps.setString(7, "0");
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

	// 登录
	public boolean login(User u) {
		ps = null;
		rs = null;
		boolean result = false;
		try {
			String sql = "select * from user where uid=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUid());
			ps.setString(2, u.getPassword());
			rs = ps.executeQuery();

			if (rs.next()) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(ps);
			dbConnection.close(rs);
			dbConnection.close(conn);
		}
		return result;
	}

	// 查询详细信息
	public User getInfo(String id) {

		User user = new User();
		ImgDao img=new ImgDao();
		FansDao fansDao=new FansDao();
		FansDao followsDao=new FansDao();
		ps = null;
		rs = null;

		try {
			String sql = "select * from user where uid=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setUid(rs.getString(1));
				user.setUname(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setSex(rs.getInt(4));
				user.setImgid(rs.getInt(5));
				user.setEmail(rs.getString(6));
				user.setLevel(rs.getInt(7));
				//String uid = rs.getString(1);
				/*String uname = rs.getString(2);
				String password = rs.getString(3);
				int sex = rs.getInt(4);
				int imgid = rs.getInt(5);
				String email = rs.getString(6);
				int level = rs.getInt(7);
				user.setUid(id);
				user.setEmail(email);
				user.setUname(uname);
				user.setImgid(imgid);
				
				user.setPassword(password);
				user.setSex(sex);
				user.setLevel(level);*/
				user.setMyImg(img.getImg(rs.getInt(5)));
				user.setFans(fansDao.getFansSum(id));
				user.setFollows(followsDao.getfollowsSum(id));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(ps);
			dbConnection.close(rs);
			dbConnection.close(conn);
		}
		return user;
	}
	
	//修改信息
	public boolean updateInfo(User u){
		boolean result=false;
		ps=null;
		rs=null;
		try{
			String sql="update user set uname=?,"+"sex=?,"+"password=?,"+"imgid=?,"+"email=?, "+"level=? where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, u.getUname());
			ps.setInt(2, u.getSex());
			ps.setString(3, u.getPassword());
			ps.setInt(4, u.getImgid());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getLevel());
			
			ps.setString(7, u.getUid());
			
			int i=ps.executeUpdate();
			if(i>0){
				result=true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			dbConnection.close(ps);
			dbConnection.close(rs);
			dbConnection.close(conn);
		}
		
		return result;
	}
	//查询账号是否可用
	public boolean uidIsUsed(String uid){
		boolean result=false;
		try{
			String sql="select * from user where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs=ps.executeQuery();
			while(rs.next()){
				result=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			dbConnection.close(ps);
			dbConnection.close(rs);
			dbConnection.close(conn);
		}
		return result;
	}
	
	public ArrayList<User> AllUser(){
		ArrayList<User> user=new ArrayList<User>();
		try{
			String sql="select * from user";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				User u=new User();
				u.setUid(rs.getString(1));
				u.setUname(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setSex(rs.getInt(4));
				u.setImgid(rs.getInt(5));
				u.setEmail(rs.getString(6));
				u.setLevel(rs.getInt(7));
				user.add(u);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			dbConnection.close(ps);
			dbConnection.close(rs);
			dbConnection.close(conn);
		}
		return user;
	}
	
	public boolean deleteUser(String uid){
		boolean result=false;
		try{
			String sql="delete from user where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			int i=ps.executeUpdate();
			if(i>0){
				result=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			dbConnection.close(ps);
			dbConnection.close(rs);
			dbConnection.close(conn);
		}
		return result;
	}
	public boolean adminAdduser(User u) {
		ps = null;
		boolean result = false;
		try {
			String sql = "insert into user(uid,uname,sex,password,email,imgid,level)value(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);

			ps.setString(1, u.getUid());
			ps.setString(2, u.getUname());
			ps.setInt(3, u.getSex());
			ps.setString(4, u.getPassword());
			
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getImgid());
			ps.setInt(7, u.getLevel());
			//ps.setString(7, "0");
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
