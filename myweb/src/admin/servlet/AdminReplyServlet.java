package admin.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.dao.ReplyDao;
//import bbs.dao.TopicDao;
import bbs.javabean.Reply;
//import bbs.javabean.Topic;

/**
 * Servlet implementation class AdminReplyServlet
 */
//@WebServlet("/AdminReplyServlet")
public class AdminReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReplyServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String uid = request.getParameter("uid");
		String tid = request.getParameter("tid");	
		ArrayList<Reply> reply=new ArrayList<Reply>();
		ReplyDao rd=new ReplyDao();
		if(tid==""||tid==null){
			if(uid==null||uid==""){
				reply=rd.getAllReply();
			}else{
				reply=rd.getReplyByUid(uid);
			}
		}else{
			int topicid=Integer.parseInt(tid);
			if(uid==null||uid==""){
				reply=rd.getReplyByTopicid(topicid);
			}else{
				reply=rd.getReplyByUidAndTopicid(uid, topicid);
			}
		}
		request.setAttribute("reply", reply);
		
		RequestDispatcher dis=request.getRequestDispatcher("admin/reply.jsp");
		dis.forward(request, response);
		
		
	}

}
