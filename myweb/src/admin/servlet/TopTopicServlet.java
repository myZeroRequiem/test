package admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.dao.TopicDao;
import bbs.javabean.Topic;

/**
 * Servlet implementation class TopTopicServlet
 */
//@WebServlet("/TopTopicServlet")
public class TopTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopTopicServlet() {
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
		int isTop=Integer.parseInt(request.getParameter("isTop"));
		int topicid=Integer.parseInt(request.getParameter("topicid"));
		TopicDao td=new TopicDao();
		TopicDao td2=new TopicDao();
		String str="";
		Topic t=new Topic();
		if(isTop==0){
			t=td.queryByTopicID(topicid);
			t.setIstop(1);
			if(td2.updataTopic(t)){
				str="置顶成功";
			}else{
				str="置顶失败";
			}
		}else{
			t=td.queryByTopicID(topicid);
			t.setIstop(0);
			if(td2.updataTopic(t)){
				str="取消置顶成功";
			}else{
				str="取消置顶失败";
			}
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
