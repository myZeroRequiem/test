package bbs.topic.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import bbs.dao.TopicDao;
import bbs.javabean.Topic;

/**
 * Servlet implementation class SearchTopicServlet
 */
@WebServlet("/SearchTopicServlet")
public class SearchTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTopicServlet() {
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
		
		String keyword=request.getParameter("keyword");
		TopicDao td=new TopicDao();
		ArrayList<Topic> searchTopic=td.searchTopic(keyword);
		int listsize=searchTopic.size();
		request.setAttribute("search", searchTopic);
		request.setAttribute("keyword", keyword);
		request.setAttribute("listsize", listsize);
		RequestDispatcher dis=request.getRequestDispatcher("jsp/searchTopic.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
