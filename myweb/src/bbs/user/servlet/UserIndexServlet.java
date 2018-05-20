package bbs.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.javabean.Reply;
import bbs.javabean.Topic;
import bbs.javabean.User;
import bbs.dao.FansDao;
//import bbs.dao.ImgDao;
import bbs.dao.ReplyDao;
import bbs.dao.TopicDao;
//import bbs.dao.UserDao;

/**
 * Servlet implementation class UserInfoServlet
 */
//@WebServlet("/userInfo1")
public class UserIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserIndexServlet() {
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
		PrintWriter out=response.getWriter();
		String arg1=request.getParameter("arg1");//跳转到指定位置
		HttpSession session=request.getSession();
		User user= (User) session.getAttribute("user");
		if(user!=null){
		String uid=user.getUid();
		//String uid="2";
		FansDao fansDao=new FansDao();
		FansDao followsDao=new FansDao();
		ReplyDao myReplyDao=new ReplyDao();
		ReplyDao replyMeDao=new ReplyDao();
		TopicDao topicDao=new TopicDao();
		ArrayList<User> fans=new ArrayList<User>();
		ArrayList<User> follows=new ArrayList<User>();
		ArrayList<Reply> myReply=new ArrayList<Reply>();
		ArrayList<Reply> replyMe=new ArrayList<Reply>();
		ArrayList<Topic> topic=new ArrayList<Topic>();
		fans=fansDao.getFans(uid);
		follows=followsDao.getFollows(uid);
		myReply=myReplyDao.getReplyByUid(uid);
		replyMe=replyMeDao.getReplyByReplyuid(uid);
		topic=topicDao.getMyTopicInUserIndex(uid);
		
		request.setAttribute("arg1", arg1);
		request.setAttribute("fans",fans);
		request.setAttribute("follows",follows);
		request.setAttribute("myReply",myReply);
		request.setAttribute("replyMe",replyMe);
		request.setAttribute("topic",topic);
		//out.print(topic);
		
		RequestDispatcher dis = request.getRequestDispatcher("jsp/userIndex.jsp");
		dis.forward(request, response);
		}else{
			out.println("<htnl><body>");
			out.println("您未登录，即将跳转到登录界面<br>");
			out.println("如未跳转，请<a href='jsp/login.jsp'>点击这里</a>");
			out.println("</body></html>");
			response.setHeader("refresh","3;url=jsp/login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
