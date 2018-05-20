package bbs.javabean;


public class Topic {
	
	private int topicid;
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	
	private String uid;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	private String topicname;
	public String getTopicname() {
		return topicname;
	}
	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}
	
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	private int typeid;
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	
	private int clicks;
	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	
	private int replys;
	public int getReplys() {
		return replys;
	}
	public void setReplys(int replys) {
		this.replys = replys;
	}
	
	private int istop;
	public int getIstop() {
		return istop;
	}
	public void setIstop(int top) {
		this.istop = top;
	}
	//发表时间
	private long topictime;		
	public long getTopictime() {
		return topictime;
	}
	public void setTopictime(long topictime) {
		this.topictime = topictime;
	}

	private long lasttime;
	public long getLasttime() {
		return lasttime;
	}
	public void setLasttime(long lasttime) {
		this.lasttime = lasttime;
	}
	
	private String lastuid;
	public String getLastuid() {
		return lastuid;
	}
	public void setLastuid(String lastuid) {
		this.lastuid = lastuid;
	}
		
	//发表时间-时间格式（年-月-日）
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String uname;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	private String lastdate;
	public String getLastdate() {
		return lastdate;
	}
	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}
	
}
