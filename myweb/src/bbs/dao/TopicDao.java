package bbs.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bbs.db.dbConnection;
import bbs.javabean.Topic;
import bbs.javabean.User;


public class TopicDao {
	Connection conn = dbConnection.getConnection();

	PreparedStatement ps = null;

	ResultSet rs = null;

	// 发表话题
	public boolean addTopic(Topic t) {
		boolean result = false;
		ps = null;
		rs = null;
		try {
			String sql = "insert into topic(uid,topicname,content,typeid,topictime,lastuid,lasttime)value(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUid());
			ps.setString(2, t.getTopicname());
			ps.setString(3, t.getContent());
			ps.setInt(4, t.getTypeid());
			ps.setLong(5, t.getTopictime());
			ps.setString(6, t.getLastuid());
			ps.setLong(7, t.getLasttime());
			
			int i = ps.executeUpdate();
			if (i == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}

		return result;
	}

	// 查询我的话题
	public ArrayList<Topic> getMyTopic(String uid) {
		ArrayList<Topic> myTopic = new ArrayList<Topic>();
		conn = dbConnection.getConnection();
		ps = null;
		rs = null;
		try {
			String sql = "select * from topic where uid=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Topic t = new Topic();
				t.setTopicid(rs.getInt(1));
				t.setTopicname(rs.getString(3));
				t.setContent(rs.getString(4));
				t.setTypeid(rs.getInt(5));
				t.setClicks(rs.getInt(6));
				t.setReplys(rs.getInt(7));
				t.setIstop(rs.getInt(8));
				t.setTopictime(rs.getLong(9));
				t.setLasttime(rs.getLong(10));
				t.setLastuid(rs.getString(11));
				
				myTopic.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return myTopic;
	}

	// 删除话题
	public boolean deleteTopic(int topicid) {
		boolean result = false;
		conn = dbConnection.getConnection();
		try {
			String sql = "delete from topic where topicid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, topicid);
			int i = ps.executeUpdate();
			if (i > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}

		return result;
	}

	// 关键字查询
	public ArrayList<Topic> searchTopic(String keyword) {
		ArrayList<Topic> topic = new ArrayList<Topic>();
		conn = dbConnection.getConnection();
		try {
			String sql = "select * from topic where topicname like ('%" + keyword + "%') " + "or content like ('%"+ keyword + "%')";
			ps = conn.prepareStatement(sql);
			// ps.setString(1, keyword);
			// ps.setString(2, keyword);
			rs = ps.executeQuery();
			while (rs.next()) {
				Topic t = new Topic();
				t.setTopicid(rs.getInt(1));
				t.setUid(rs.getString(2));
				t.setTopicname(rs.getString(3));
				t.setContent(rs.getString(4));
				t.setTypeid(rs.getInt(5));
				t.setClicks(rs.getInt(6));
				t.setReplys(rs.getInt(7));
				t.setIstop(rs.getInt(8));
				t.setTopictime(rs.getLong(9));
				t.setLasttime(rs.getLong(10));
				t.setLastuid(rs.getString(11));
				UserDao ud=new UserDao();
				User user=ud.getInfo(rs.getString(2));
				t.setUname(user.getUname());
				//时间戳转换成日期封装进topic
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日  HH:mm");
				String date = simpleDateFormat.format(rs.getLong(9));
		        t.setDate(date);
		        String lastdate = simpleDateFormat.format(rs.getLong(10));
		        t.setLastdate(lastdate);
				topic.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return topic;
	}

	//查询所有话题
	public ArrayList<Topic> getAllTopic() {
		ArrayList<Topic> allTopic = new ArrayList<Topic>();
		
		conn = dbConnection.getConnection();
		try {
			String sql = "select * from topic order by lasttime desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				Topic t = new Topic();
				t.setTopicid(rs.getInt(1));
				
				t.setUid(rs.getString(2));
				t.setTopicname(rs.getString(3));
				t.setContent(rs.getString(4));
				t.setTypeid(rs.getInt(5));
				t.setClicks(rs.getInt(6));
				t.setReplys(rs.getInt(7));
				t.setIstop(rs.getInt(8));
				t.setTopictime(rs.getLong(9));
				t.setLasttime(rs.getLong(10));
				t.setLastuid(rs.getString(11));
				UserDao ud=new UserDao();
				User user=ud.getInfo(rs.getString(2));
				t.setUname(user.getUname());
				allTopic.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return allTopic;
	}
	
	//根据话题ID查询话题
	public Topic queryByTopicID(int topicid){
		conn=dbConnection.getConnection();
		Topic t=new Topic();
		try{
			String sql="select * from topic where topicid= ?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, topicid);
			rs=ps.executeQuery();
			while(rs.next()){				
				t.setTopicid(rs.getInt(1));
				t.setUid(rs.getString(2));
				t.setTopicname(rs.getString(3));
				t.setContent(rs.getString(4));
				t.setTypeid(rs.getInt(5));
				t.setClicks(rs.getInt(6));
				t.setReplys(rs.getInt(7));
				t.setIstop(rs.getInt(8));
				t.setTopictime(rs.getLong(9));
				t.setLasttime(rs.getLong(10));
				t.setLastuid(rs.getString(11));
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return t;
	}

	//查询我的最新5条话题，主页调用
	public ArrayList<Topic> getMyNewTopicInIndex(String uid) {
		ArrayList<Topic> myTopic = new ArrayList<Topic>();
		conn = dbConnection.getConnection();
		
		ps = null;
		rs = null;
		try {
			String sql = "select * from topic where uid=? order by topictime desc LIMIT 5";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Topic t = new Topic();
				t.setTopicid(rs.getInt(1));
				t.setTopicname(rs.getString(3));
				t.setContent(rs.getString(4));
				t.setTypeid(rs.getInt(5));
				t.setClicks(rs.getInt(6));
				t.setReplys(rs.getInt(7));
				t.setIstop(rs.getInt(8));
				t.setTopictime(rs.getLong(9));
				t.setLasttime(rs.getLong(10));
				t.setLastuid(rs.getString(11));
				UserDao ud=new UserDao();
				User user=ud.getInfo(rs.getString(2));
				t.setUname(user.getUname());
				myTopic.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return myTopic;
	}
	
	//根据类型查询话题
	public ArrayList<Topic> getTopicByType(int typeid){
		ArrayList<Topic> topic = new ArrayList<Topic>();
		conn = dbConnection.getConnection();
		
		ps = null;
		rs = null;
		try {
			String sql = "select * from topic where typeid=? order by topictime desc";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, typeid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Topic t = new Topic();
				t.setTopicid(rs.getInt(1));
				t.setUid(rs.getString(2));
				t.setTopicname(rs.getString(3));
				t.setContent(rs.getString(4));
				t.setTypeid(rs.getInt(5));
				t.setClicks(rs.getInt(6));
				t.setReplys(rs.getInt(7));
				t.setIstop(rs.getInt(8));
				t.setTopictime(rs.getLong(9));
				t.setLasttime(rs.getLong(10));
				t.setLastuid(rs.getString(11));
				UserDao ud=new UserDao();
				User user=ud.getInfo(rs.getString(2));
				t.setUname(user.getUname());
				topic.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return topic;
	}
	//个人主页加载话题
	public ArrayList<Topic> getMyTopicInUserIndex(String uid) {
		ArrayList<Topic> myTopic = new ArrayList<Topic>();
		conn = dbConnection.getConnection();
		
		ps = null;
		rs = null;
		try {
			String sql = "select * from topic where uid=? order by topictime";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Topic t = new Topic();
				t.setTopicid(rs.getInt(1));
				t.setTopicname(rs.getString(3));
				t.setContent(rs.getString(4));
				t.setTypeid(rs.getInt(5));
				t.setClicks(rs.getInt(6));
				t.setReplys(rs.getInt(7));
				t.setIstop(rs.getInt(8));
				t.setTopictime(rs.getLong(9));
				t.setLasttime(rs.getLong(10));
				t.setLastuid(rs.getString(11));
				//把发表人的昵称封装进topic
				UserDao ud=new UserDao();
				User user=ud.getInfo(rs.getString(2));
				t.setUname(user.getUname());
				//时间戳转换成日期封装进topic
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日  HH:mm");
				String date = simpleDateFormat.format(rs.getLong(9));
		        t.setDate(date);
				myTopic.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return myTopic;
	}
	public boolean updataTopic(Topic t){
		boolean result=false;
		try{
			String sql="update  topic set uid=?,"+"topicname=?,"+"content=?,"+"typeid=?,"+"clicks=?,"+"replys=?,"+"istop=?,"+"topictime=?,"+"lasttime=?,"+"lastuid=? where topicid=?";
			ps=conn.prepareStatement(sql);	
			ps.setString(1, t.getUid());
			ps.setString(2, t.getTopicname());
			ps.setString(3, t.getContent());	
			ps.setInt(4, t.getTypeid());
			ps.setInt(5, t.getClicks());
			ps.setInt(6, t.getReplys());
			ps.setInt(7, t.getIstop());
			ps.setLong(8, t.getTopictime());		
			ps.setLong(9, t.getLasttime());
			ps.setString(10, t.getLastuid());
			ps.setInt(11, t.getTopicid());
			int i=ps.executeUpdate();
			if(i>0){
				result=true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return result;
	}
	public ArrayList<Topic> getHotTopic(){
		ArrayList<Topic> hotTopic = new ArrayList<Topic>();
		conn = dbConnection.getConnection();
		try{
			String sql="select * from topic order by clicks desc limit 10";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Topic t = new Topic();
				t.setTopicid(rs.getInt(1));
				t.setUid(rs.getString(2));
				t.setTopicname(rs.getString(3));
				t.setContent(rs.getString(4));
				t.setTypeid(rs.getInt(5));
				t.setClicks(rs.getInt(6));
				t.setReplys(rs.getInt(7));
				t.setIstop(rs.getInt(8));
				t.setTopictime(rs.getLong(9));
				t.setLasttime(rs.getLong(10));
				t.setLastuid(rs.getString(11));
				hotTopic.add(t);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return hotTopic;
	}
	public ArrayList<Topic> adminSearchTopic(String keyword) {
		ArrayList<Topic> topic = new ArrayList<Topic>();
		conn = dbConnection.getConnection();
		try {
			String sql = "select * from topic where topicname like ('%" + keyword + "%') ";
			ps = conn.prepareStatement(sql);
			// ps.setString(1, keyword);
			// ps.setString(2, keyword);
			rs = ps.executeQuery();
			while (rs.next()) {
				Topic t = new Topic();
				t.setTopicid(rs.getInt(1));
				t.setUid(rs.getString(2));
				t.setTopicname(rs.getString(3));
				t.setContent(rs.getString(4));
				t.setTypeid(rs.getInt(5));
				t.setClicks(rs.getInt(6));
				t.setReplys(rs.getInt(7));
				t.setIstop(rs.getInt(8));
				t.setTopictime(rs.getLong(9));
				t.setLasttime(rs.getLong(10));
				t.setLastuid(rs.getString(11));
				
				topic.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return topic;
	}
	public ArrayList<Topic> adminSearchTopicByUid(String keyword,String uid) {
		ArrayList<Topic> topic = new ArrayList<Topic>();
		conn = dbConnection.getConnection();
		try {
			String sql = "select * from topic where topicname like ('%" + keyword + "%') and uid = ?";
			ps = conn.prepareStatement(sql);
			 ps.setString(1, uid);
			// ps.setString(2, keyword);
			rs = ps.executeQuery();
			while (rs.next()) {
				Topic t = new Topic();
				t.setTopicid(rs.getInt(1));
				t.setUid(rs.getString(2));
				t.setTopicname(rs.getString(3));
				t.setContent(rs.getString(4));
				t.setTypeid(rs.getInt(5));
				t.setClicks(rs.getInt(6));
				t.setReplys(rs.getInt(7));
				t.setIstop(rs.getInt(8));
				t.setTopictime(rs.getLong(9));
				t.setLasttime(rs.getLong(10));
				t.setLastuid(rs.getString(11));
				
				topic.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return topic;
	} 
	public ArrayList<Topic> adminSearchByUidAndType(String keyword,String uid,int typeid) {
		ArrayList<Topic> topic = new ArrayList<Topic>();
		conn = dbConnection.getConnection();
		try {
			String sql = "select * from topic where uid=? and type = ? and topicname like ('%" + keyword + "%')";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, typeid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Topic t = new Topic();
				t.setTopicid(rs.getInt(1));
				t.setUid(rs.getString(2));
				t.setTopicname(rs.getString(3));
				t.setContent(rs.getString(4));
				t.setTypeid(rs.getInt(5));
				t.setClicks(rs.getInt(6));
				t.setReplys(rs.getInt(7));
				t.setIstop(rs.getInt(8));
				t.setTopictime(rs.getLong(9));
				t.setLasttime(rs.getLong(10));
				t.setLastuid(rs.getString(11));
				
				topic.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return topic;
	} 
	public ArrayList<Topic> adminSearchTopicByType(String keyword,int typeid) {
		ArrayList<Topic> topic = new ArrayList<Topic>();
		conn = dbConnection.getConnection();
		try {
			String sql = "select * from topic where typeid = ? and topicname like ('%" + keyword + "%')";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, typeid);
			// ps.setString(2, keyword);
			rs = ps.executeQuery();
			while (rs.next()) {
				Topic t = new Topic();
				t.setTopicid(rs.getInt(1));
				t.setUid(rs.getString(2));
				t.setTopicname(rs.getString(3));
				t.setContent(rs.getString(4));
				t.setTypeid(rs.getInt(5));
				t.setClicks(rs.getInt(6));
				t.setReplys(rs.getInt(7));
				t.setIstop(rs.getInt(8));
				t.setTopictime(rs.getLong(9));
				t.setLasttime(rs.getLong(10));
				t.setLastuid(rs.getString(11));
				
				topic.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return topic;
	} 
	public ArrayList<Topic> adminTopicByUidAndType(String uid,int typeid) {
		ArrayList<Topic> topic = new ArrayList<Topic>();
		conn = dbConnection.getConnection();
		try {
			String sql = "select * from topic where uid=? and type = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, typeid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Topic t = new Topic();
				t.setTopicid(rs.getInt(1));
				t.setUid(rs.getString(2));
				t.setTopicname(rs.getString(3));
				t.setContent(rs.getString(4));
				t.setTypeid(rs.getInt(5));
				t.setClicks(rs.getInt(6));
				t.setReplys(rs.getInt(7));
				t.setIstop(rs.getInt(8));
				t.setTopictime(rs.getLong(9));
				t.setLasttime(rs.getLong(10));
				t.setLastuid(rs.getString(11));
				
				topic.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return topic;
	} 
	
	//删除用户时删除该用户的话题
	public boolean deleteUser(String uid){
		boolean result=false;
		try{
			String sql="delete from topic where uid=?";
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
