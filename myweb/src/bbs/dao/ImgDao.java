package bbs.dao;

import java.sql.*;
import java.util.ArrayList;

import bbs.db.dbConnection;
import bbs.javabean.Img;



public class ImgDao {
	Connection conn=dbConnection.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	public String getImg(int imgid){
		ps=null;
		rs=null;
		String img=null;
		try{
			String sql="select * from img where imgid=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, imgid);
			rs=ps.executeQuery();
			if(rs.next()){
				img=rs.getString(2);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbConnection.close(ps);
			dbConnection.close(rs);
			dbConnection.close(conn);
		}
		return img;
	}
	public ArrayList<Img> getImg(){
		ps=null;
		rs=null;
		ArrayList<Img> img=new ArrayList<Img>();
		try{
			String sql="select * from img";
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			while(rs.next()){
				Img i=new Img();
				i.setImgid(rs.getInt(1));
				i.setImg(rs.getString(2));
				img.add(i);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbConnection.close(ps);
			dbConnection.close(rs);
			dbConnection.close(conn);
		}
		return img;
	}
	public boolean addImg(Img img){
		boolean result=false;
		try{
			String sql = "insert into img(imgid,img)value(?,?)";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, img.getImgid());
			ps.setString(2,img.getImg());
			
			int i = ps.executeUpdate();
			if (i == 1) {
				result = true;
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
	public boolean editImg(Img img){
		boolean result=false;
		try{
			String sql = "update img set img=? where imgid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,img.getImg());
			ps.setInt(2, img.getImgid());
	
			int i = ps.executeUpdate();
			if (i>0) {
				result = true;
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
}
