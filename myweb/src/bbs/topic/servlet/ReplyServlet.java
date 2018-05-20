package bbs.topic.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.dao.ReplyDao;
import bbs.dao.TopicDao;
import bbs.dao.UserDao;
import bbs.javabean.Reply;
import bbs.javabean.Topic;
import bbs.javabean.User;

/**
 * Servlet implementation class ReplyServlet
 */
//@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		//获取文章ID
		int topicid=Integer.parseInt(request.getParameter("topicid"));
		
		TopicDao td=new TopicDao();
		Topic t=td.queryByTopicID(topicid);
		//获取文章作者ID：topicuid
		String replyuid=t.getUid();
		//登录用户ID
		User user=(User)session.getAttribute("user");
		String str="";
		if(user!=null){
			String uid=user.getUid();
			//获取回复内容
			String reply=request.getParameter("reply");
			//获取时间戳
			Date now=new Date();
			long time=now.getTime();
			t.setReplys(t.getReplys()+1);
			t.setLastuid(uid);
			t.setLasttime(time);
			TopicDao td2=new TopicDao();
			if(td2.updataTopic(t)){
				//计算楼层,楼层计算根据回复数量来
				//ReplyDao rd=new ReplyDao();
				int floor=t.getReplys()+1;
				//进行封装
				Reply r=new Reply();
				r.setUid(uid);
				r.setReplyuid(replyuid);
				r.setReply(reply);
				r.setReplytime(time);
				r.setTopicid(topicid);
				r.setFloor(floor);
				//再次实例化DAO对象，因为貌似用过一次就不能再用了
				ReplyDao replyDao=new ReplyDao();
				if(replyDao.reply(r)){
					UserDao ud=new UserDao();
					user.setLevel(user.getLevel()+1);
					ud.updateInfo(user);
					str="发表成功";	
				}else{
					str="发表失败";	
				}
			}else{
				str="发表失败";	
			}
		}else{
			str="您未登录，请先登录！";	
		}
		response.getWriter().write(str);
	}
}
