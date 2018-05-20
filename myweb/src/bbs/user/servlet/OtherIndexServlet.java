package bbs.user.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.dao.FansDao;
import bbs.dao.ReplyDao;
import bbs.dao.TopicDao;
import bbs.dao.UserDao;
import bbs.javabean.Reply;
import bbs.javabean.Topic;
import bbs.javabean.User;

/**
 * Servlet implementation class OtherIndexServlet
 */
//@WebServlet("/OtherIndexServlet")
public class OtherIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//PrintWriter out=response.getWriter();
		
		String otheruid=request.getParameter("otheruid");
		HttpSession session=request.getSession();
		User user= (User) session.getAttribute("user");
		String isfollows="0";
		if(user!=null){
			String uid=user.getUid();
			if(uid.equals(otheruid)){
				RequestDispatcher dis1 = request.getRequestDispatcher("userIndex");
				dis1.forward(request, response);
			}
			UserDao userDao=new UserDao();
			FansDao fansDao=new FansDao();
			FansDao followsDao=new FansDao();
			FansDao isfollowsDao=new FansDao();
			ReplyDao myReplyDao=new ReplyDao();	
			TopicDao topicDao=new TopicDao();
			
			User others=new User();
			ArrayList<User> fans=new ArrayList<User>();
			ArrayList<User> follows=new ArrayList<User>();
			ArrayList<Reply> myReply=new ArrayList<Reply>();
			ArrayList<Topic> topic=new ArrayList<Topic>();
			
			
			others=userDao.getInfo(otheruid);
			fans=fansDao.getFans(otheruid);
			follows=followsDao.getFollows(otheruid);
			myReply=myReplyDao.getReplyByUid(otheruid);
			topic=topicDao.getMyTopicInUserIndex(otheruid);
			if(isfollowsDao.isFollows(uid, otheruid)){
				isfollows="1";
			}
			
			request.setAttribute("isfollows", isfollows);
			request.setAttribute("others",others);
			request.setAttribute("fans",fans);
			request.setAttribute("follows",follows);
			request.setAttribute("myReply",myReply);
			request.setAttribute("topic",topic);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("jsp/otherIndex.jsp");
			dis2.forward(request, response);
		}
		UserDao userDao=new UserDao();
		FansDao fansDao=new FansDao();
		FansDao followsDao=new FansDao();
		ReplyDao myReplyDao=new ReplyDao();	
		TopicDao topicDao=new TopicDao();
		
		User others=new User();
		ArrayList<User> fans=new ArrayList<User>();
		ArrayList<User> follows=new ArrayList<User>();
		ArrayList<Reply> myReply=new ArrayList<Reply>();
		ArrayList<Topic> topic=new ArrayList<Topic>();
		
		others=userDao.getInfo(otheruid);
		fans=fansDao.getFans(otheruid);
		follows=followsDao.getFollows(otheruid);
		myReply=myReplyDao.getReplyByUid(otheruid);
		topic=topicDao.getMyTopicInUserIndex(otheruid);
		
		request.setAttribute("isfollows", isfollows);
		request.setAttribute("others",others);
		request.setAttribute("fans",fans);
		request.setAttribute("follows",follows);
		request.setAttribute("myReply",myReply);
		request.setAttribute("topic",topic);
		
		RequestDispatcher dis3 = request.getRequestDispatcher("jsp/otherIndex.jsp");
		dis3.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
