package bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bbs.db.dbConnection;
import bbs.javabean.Reply;
import bbs.javabean.Topic;
import bbs.javabean.User;

public class ReplyDao {
	Connection conn = dbConnection.getConnection();

	PreparedStatement ps = null;

	ResultSet rs = null;
	
	//发表回帖
	public boolean reply(Reply r){
		boolean result=false;
		conn=dbConnection.getConnection();
		try{
			String sql="insert into reply(topicid,uid,replyuid,reply,replytime,floor)value(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, r.getTopicid());
			ps.setString(2, r.getUid());
			ps.setString(3, r.getReplyuid());
			ps.setString(4, r.getReply());
			ps.setLong(5, r.getReplytime());
			ps.setInt(6, r.getFloor());
			
			int i=ps.executeUpdate();
			if(i==1){
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
	//根据话题ID查询回复
	public ArrayList<Reply> getReplyByTopicid(int topicid){
		ArrayList<Reply> reply=new ArrayList<Reply>();
		conn=dbConnection.getConnection();
		try{
			String sql="select * from reply where topicid=? order by replytime asc";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, topicid);
			rs=ps.executeQuery();
			while(rs.next()){
				Reply r=new Reply();
				r.setReplyno(rs.getInt(1));
				r.setTopicid(topicid);
				r.setUid(rs.getString(3));
				r.setReplyuid(rs.getString(4));
				r.setReply(rs.getString(5));
				r.setReplytime(rs.getLong(6));
				r.setFloor(rs.getInt(7));
				r.setIsread(rs.getInt(8));
				long time=rs.getLong(6);
				//时间戳转换成日期封装进回复
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日  HH:mm");
				String date = simpleDateFormat.format(time);
		        r.setDate(date);
		        //回帖的用户信息
		        UserDao ud=new UserDao();
		        User u=ud.getInfo(rs.getString(3));
		        r.setUname(u.getUname());
		        r.setLevel(u.getLevel());
		        r.setImg(u.getMyImg());
				reply.add(r);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return reply;
	}
	//根据发布者查询回复
	public ArrayList<Reply> getReplyByUid(String uid){
		ArrayList<Reply> reply=new ArrayList<Reply>();
		conn=dbConnection.getConnection();
		try{
			String sql="select * from reply where uid=? order by replytime desc";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs=ps.executeQuery();
			while(rs.next()){
				Reply r=new Reply();
				r.setReplyno(rs.getInt(1));
				r.setTopicid(rs.getInt(2));
				r.setUid(uid);
				r.setReplyuid(rs.getString(4));
				r.setReply(rs.getString(5));
				r.setReplytime(rs.getLong(6));
				r.setFloor(rs.getInt(7));
				r.setIsread(rs.getInt(8));
				//封装话题标题
				TopicDao t=new TopicDao();
				r.setTopicname(t.queryByTopicID(rs.getInt(2)).getTopicname());
				//时间戳转日期
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日  HH:mm");
				String date = simpleDateFormat.format(rs.getLong(6));
		        r.setDate(date);
				reply.add(r);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return reply;
	}
	//计算用户回帖量
	public int getReplySumByUid(String uid){
		int sum=0;
		try {
			String sql = "select count(*) as replys from reply where uid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			rs.next();
			sum = rs.getInt("replys");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(ps);
			dbConnection.close(conn);
		}
		return sum;
	}
	//计算用户被回帖量
	public int getReplySumByReplyuid(String uid){
		int sum=0;
		try {
			String sql = "select count(*) as replys from reply where replyuid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			rs.next();
			sum = rs.getInt("replys");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(ps);
			dbConnection.close(conn);
		}
		return sum;
	}
	//计算用户未读回复量
	public int getNoReadReplySum(String uid){
		int sum=0;
		try {
			String sql = "select count(*) as replys from reply where replyuid=?and isread=0";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			rs.next();
			sum = rs.getInt("replys");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(ps);
			dbConnection.close(conn);
		}
		return sum;
	}
	//查询用户被回复的消息
	public ArrayList<Reply> getReplyByReplyuid(String uid){
		ArrayList<Reply> reply=new ArrayList<Reply>();
		conn=dbConnection.getConnection();
		try{
			String sql="select * from reply where replyuid=? order by replytime desc";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs=ps.executeQuery();
			while(rs.next()){
				Reply r=new Reply();
				r.setReplyno(rs.getInt(1));
				r.setTopicid(rs.getInt(2));
				r.setUid(rs.getString(3));
				r.setReplyuid(uid);
				r.setReply(rs.getString(5));
				r.setReplytime(rs.getLong(6));
				r.setFloor(rs.getInt(7));
				r.setIsread(rs.getInt(8));
				//发表回帖的用户信息
		        UserDao ud=new UserDao();
		        User u=ud.getInfo(rs.getString(3));
		        r.setUname(u.getUname());
		        r.setLevel(u.getLevel());
		        r.setImg(u.getMyImg());
		        //回帖的话题标题
		        TopicDao td=new TopicDao();
		        Topic t=td.queryByTopicID(rs.getInt(2));
		        r.setTopicname(t.getTopicname());
		      //时间戳转日期
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日  HH:mm");
				String date = simpleDateFormat.format(rs.getLong(6));
		        r.setDate(date);
				reply.add(r);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return reply;
	}
	//查询用户被回复的未读消息
	public ArrayList<Reply> getNoReadReply(String uid){
		ArrayList<Reply> reply=new ArrayList<Reply>();
		conn=dbConnection.getConnection();
		try{
			String sql="select * from reply where replyuid = ? and isread = 0 order by replytime desc";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs=ps.executeQuery();
			while(rs.next()){
				Reply r=new Reply();
				r.setReplyno(rs.getInt(1));
				r.setTopicid(rs.getInt(2));
				r.setUid(uid);
				r.setReplyuid(rs.getString(4));
				r.setReply(rs.getString(5));
				r.setReplytime(rs.getLong(6));
				r.setFloor(rs.getInt(7));
				r.setIsread(rs.getInt(8));
				//用户信息
		        UserDao ud=new UserDao();
		        User u=ud.getInfo(rs.getString(3));
		        r.setUname(u.getUname());
		        r.setLevel(u.getLevel());
		        r.setImg(u.getMyImg());
				reply.add(r);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return reply;
	}
	//计算当前楼层，已废弃该方法，楼层计算根据局话题回复数量来
	public int getFloor(int topicid){
		int floor=1;
		try {
			String sql = "select count(*) as replys from reply where topicid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, topicid);
			rs = ps.executeQuery();
			rs.next();
			floor = rs.getInt("replys")+1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(ps);
			dbConnection.close(conn);
		}
		return floor;
	}
	//删除话题时删除该话题的回帖
	public boolean deleteReply(int topicid){
		boolean result=false;
		try{
			String sql="delete from reply where topicid=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, topicid);
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
	public ArrayList<Reply> getAllReply(){
		ArrayList<Reply> reply=new ArrayList<Reply>();
		conn=dbConnection.getConnection();
		try{
			String sql="select * from reply";
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			while(rs.next()){
				Reply r=new Reply();
				r.setReplyno(rs.getInt(1));
				r.setTopicid(rs.getInt(2));
				r.setUid(rs.getString(3));
				r.setReplyuid(rs.getString(4));
				r.setReply(rs.getString(5));
				r.setReplytime(rs.getLong(6));
				r.setFloor(rs.getInt(7));
				r.setIsread(rs.getInt(8));
				
				reply.add(r);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return reply;
	}
	
	public ArrayList<Reply> getReplyByUidAndTopicid(String uid,int topicid){
		ArrayList<Reply> reply=new ArrayList<Reply>();
		conn=dbConnection.getConnection();
		try{
			String sql="select * from reply where uid=? and topicid = ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, topicid);
			rs=ps.executeQuery();
			while(rs.next()){
				Reply r=new Reply();
				r.setReplyno(rs.getInt(1));
				r.setTopicid(rs.getInt(2));
				r.setUid(rs.getString(3));
				r.setReplyuid(rs.getString(4));
				r.setReply(rs.getString(5));
				r.setReplytime(rs.getLong(6));
				r.setFloor(rs.getInt(7));
				r.setIsread(rs.getInt(8));
				
				reply.add(r);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close(conn);
			dbConnection.close(ps);
			dbConnection.close(rs);
		}
		return reply;
	}
	//删除单独一条回帖
	public boolean deleteReplyByReplyno(int replyno){
		boolean result=false;
		try{
			String sql="delete from reply where replyno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, replyno);
			int i=ps.executeUpdate();
			while(i>0){
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
	
	//删除用户时删除该用户的回帖
	public boolean deleteUser(String uid){
		boolean result=false;
		try{
			String sql="delete from reply where uid=?";
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
