package bbs.topic.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

import bbs.dao.TopicDao;
//import bbs.dao.UserDao;
import bbs.javabean.Topic;

/**
 * Servlet implementation class AllTopicServlet
 */
//@WebServlet("/AllTopicServlet")
public class GetTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTopicServlet() {
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
		//int typeid=0;
		int typeid=Integer.parseInt(request.getParameter("typeid"));
		
		TopicDao td=new TopicDao();
		ArrayList<Topic> topic=new ArrayList<Topic>();
		if(typeid==0){
			topic=td.getAllTopic();
		}else{
			topic=td.getTopicByType(typeid);
		}
		
		/*request.setAttribute("allTopic", topic);
		RequestDispatcher dis=request.getRequestDispatcher("test.jsp");
		dis.forward(request, response);*/
		//String a="aaa";
		/*PrintWriter out=response.getWriter();
		for(int i=0;i<allTopic.size();i++)
		{out.print(allTopic.get(i));}*/
		try{
			
		JSONArray jsonArray = JSONArray.fromObject(topic);   
	       
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
