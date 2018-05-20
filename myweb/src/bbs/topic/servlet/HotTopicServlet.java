package bbs.topic.servlet;
//貌似用不到了
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.dao.TopicDao;
import bbs.javabean.Topic;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class HotTopicServlet
 */
//@WebServlet("/HotTopicServlet")
public class HotTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotTopicServlet() {
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
		TopicDao td=new TopicDao();
		ArrayList<Topic> hotTopic=td.getHotTopic();
		try{
			
			JSONArray jsonArray = JSONArray.fromObject(hotTopic);   
		       
	        String jsonObject =jsonArray.toString(); 
	           
	        
	           
	        response.getWriter().write(jsonObject); 
			}catch(IOException e) {   
	            e.printStackTrace();   
	        } 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
