package bbs.topic.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.dao.TopicDao;
import bbs.dao.UserDao;
import bbs.javabean.Topic;
import bbs.javabean.User;

/**
 * Servlet implementation class PublishTopicServlet
 */
//@WebServlet("/PublishTopicServlet")
public class PublishTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishTopicServlet() {
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
		//doGet(request, response);
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		User u=(User)session.getAttribute("user");
		if(u!=null){
			String uid=u.getUid();
			
			
			String topicname=request.getParameter("topicname");
			int typeid=Integer.parseInt(request.getParameter("typeid"));
			String content=request.getParameter("content");
			
			//out.println("-----a-----");
			Date now=new Date();
			long time=now.getTime();
			Topic t=new Topic();
			t.setTopicname(topicname);
			t.setTypeid(typeid);
			t.setContent(content);
			t.setUid(uid);
			t.setTopictime(time);
			t.setLastuid(uid);
			t.setLasttime(time);
			
			TopicDao dao=new TopicDao();
			String str="发表失败";
			if(dao.addTopic(t)){
				UserDao ud=new UserDao();
				u.setLevel(u.getLevel()+1);
				ud.updateInfo(u);
				str="发表成功";
				
			}
			response.getWriter().write(str);
		}else{
			String str="您未登录，请先登录！";
			response.getWriter().write(str);
		}
	}

}
