package bbs.javabean;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uid;//账号
	private String uname;//昵称
	private String password;//密码
	private int sex;//性别
	private String email;//邮箱
	private int imgid;//头像ID
	private int level;//经验
	private String myImg;//头像地址
	private int fans;//粉丝数
	private int follows;//关注量
	
	//粉丝
	public int getFans() {
		return fans;
	}
	public void setFans(int fans) {
		this.fans = fans;
	}
	
	//关注
	public int getFollows() {
		return follows;
	}
	public void setFollows(int follows) {
		this.follows = follows;
	}
	
	//头像地址
	public String getMyImg() {
		return myImg;
	}
	public void setMyImg(String myImg) {
		this.myImg = myImg;
	}
	
	//账号
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	//昵称
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	//密码
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//邮箱
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//头像地址
	public int getImgid() {
		return imgid;
	}
	public void setImgid(int imgid) {
		this.imgid = imgid;
	}
	
	//性别
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	//
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	

}
