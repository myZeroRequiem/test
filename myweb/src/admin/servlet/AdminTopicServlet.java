package admin.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.dao.TopicDao;
import bbs.javabean.Topic;

/**
 * Servlet implementation class AdminTopicServlet
 */
//@WebServlet("/AdminTopicServlet")
public class AdminTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTopicServlet() {
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
		String topicname = request.getParameter("topicname");
		int typeid=Integer.parseInt(request.getParameter("typeid"));
		ArrayList<Topic> topic=new ArrayList<Topic>();
		TopicDao td=new TopicDao();
		if(typeid==0&&topicname==null&&uid==null){
			topic=td.getAllTopic();
		}/*else if(typeid==0&&topicname==""&&uid!=null){
			topic=td.getMyTopic(uid);
		}else if(typeid==0&&topicname!=null&&uid==null){
			topic=td.searchTopic(topicname);
		}else if(typeid==0&&topicname!=null&&uid!=null){
			topic=td.adminSearchTopicByUid(topicname, uid);
		}else if(typeid!=0&&topicname==null&&uid==null){
			topic=td.getTopicByType(typeid);
		}else if(typeid!=0&&topicname==null&&uid!=null){
			topic=td.adminTopicByUidAndType(uid, typeid);
		}else if(typeid!=0&&topicname!=null&&uid==null){
			topic=td.adminSearchTopicByType(topicname, typeid);
		}else if(typeid!=0&&topicname==null&&uid!=null){
			topic=td.adminSearchByUidAndType(topicname, uid, typeid);
		}*/
		else if(typeid==0){
			if(uid==""){
				if(topicname==""){
					topic=td.getAllTopic();
				}else{
					topic=td.searchTopic(topicname);
				}
				
			}else{
				if(topicname==""){
					topic=td.getMyTopic(uid);
				}else{
					topic=td.adminSearchTopicByUid(topicname, uid);
				}
				
			}
		}else{
			if(uid==""){
				if(topicname==""){
					topic=td.getTopicByType(typeid);
				}else{
					topic=td.adminSearchTopicByType(topicname, typeid);
				}
				
			}else{
				if(topicname==""){
					topic=td.adminTopicByUidAndType(uid, typeid);
				}else{
					topic=td.adminSearchByUidAndType(topicname, uid, typeid);
				}
				
			}
		}
		request.setAttribute("topic", topic);
		
		RequestDispatcher dis=request.getRequestDispatcher("admin/topic.jsp");
		dis.forward(request, response);
	}

}
