package admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.dao.ReplyDao;
import bbs.dao.TopicDao;

/**
 * Servlet implementation class AdminDeleteTopicServlet
 */
//@WebServlet("/AdminDeleteTopicServlet")
public class AdminDeleteTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");		
		int topicid=Integer.parseInt(request.getParameter("topicid"));
		TopicDao td=new TopicDao();
		ReplyDao rd=new ReplyDao();
		String str="";
		if(td.deleteTopic(topicid)&&rd.deleteReply(topicid)){
			str="删除成功";
		}else{
			str="删除失败";
		}
		response.getWriter().write(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
