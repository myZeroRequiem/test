package bbs.topic.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.dao.ReplyDao;
import bbs.dao.TopicDao;
import bbs.javabean.Reply;
import bbs.javabean.Topic;

/**
 * Servlet implementation class TopicServlet
 */
@WebServlet("/TopicServlet")
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicServlet() {
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
		int topicid=Integer.parseInt(request.getParameter("topicid"));
		TopicDao td=new TopicDao();
		Topic topic=new Topic();
		topic=td.queryByTopicID(topicid);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日  HH:mm");
        long time =topic.getTopictime();
        
        String date = simpleDateFormat.format(time);
        topic.setDate(date);
        topic.setClicks(topic.getClicks()+1);
        TopicDao td2=new TopicDao();
        td2.updataTopic(topic);
		request.setAttribute("topic", topic);
		
		//封装回复
		ReplyDao rd=new ReplyDao();
		ArrayList<Reply> reply=new ArrayList<Reply>();
		reply=rd.getReplyByTopicid(topicid);
		request.setAttribute("reply", reply);
		RequestDispatcher dis=request.getRequestDispatcher("jsp/topic.jsp");
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
