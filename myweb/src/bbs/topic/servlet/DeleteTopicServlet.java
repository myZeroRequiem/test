package bbs.topic.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import bbs.dao.ReplyDao;
import bbs.dao.TopicDao;
import bbs.javabean.User;

/**
 * Servlet implementation class DeleteTopicServlet
 */
//@WebServlet("/DeleteTopicServlet")
public class DeleteTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTopicServlet() {
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
		HttpSession session=request.getSession();
		//PrintWriter out=response.getWriter();
		User user=(User)session.getAttribute("user");
		String tid=(String)request.getParameter("topicid");
		//String t="11";
		int topicid=Integer.parseInt(tid);;
		
		String str="";
		if(user!=null){		
			
				TopicDao td=new TopicDao();
				if(td.deleteTopic(topicid)){
					str="删除成功";
				}else{
					str="删除失败";
				}
			
			
		}else{
			str="您未登录，请先登录！";
			
		}
		response.getWriter().write(str);
		//out.println(topicid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
