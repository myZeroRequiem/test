package bbs.javabean;

public class Reply {
	private int replyno;
	private int topicid;
	private String uid;
	private String reply;
	private long replytime;
	private String replyuid;
	private int isread;
	private int floor;
	////////
	//时间，年月日形式
	///////
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	///////////
	public int getReplyno() {
		return replyno;
	}
	public void setReplyno(int replyno) {
		this.replyno = replyno;
	}
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public long getReplytime() {
		return replytime;
	}
	public void setReplytime(long replytime) {
		this.replytime = replytime;
	}
	public String getReplyuid() {
		return replyuid;
	}
	public void setReplyuid(String replyuid) {
		this.replyuid = replyuid;
	}
	public int getIsread() {
		return isread;
	}
	public void setIsread(int isread) {
		this.isread = isread;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	
	//////////////
	/////封装用户信息
	///////////////
	private String uname;
	private String img;
	private int level;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	////////////
	///话题标题
	///////////
	private String topicname;
	public String getTopicname() {
		return topicname;
	}
	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}
	
	
	
}
