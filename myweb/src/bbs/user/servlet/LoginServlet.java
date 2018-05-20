package bbs.user.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import bbs.dao.TopicDao;
import bbs.dao.UserDao;
//import bbs.javabean.Topic;
import bbs.javabean.User;

/**
 * Servlet implementation class FDdf
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//PrintWriter out = response.getWriter();	
		String uid = request.getParameter("uid");
		String password = request.getParameter("password");				
		User u = new User();//实例化user
		//封装进user
		u.setUid(uid);
		u.setPassword(password);	
		UserDao dao = new UserDao();//实例化UserDao
		String str="";
		if (dao.login(u)) {
			HttpSession session = request.getSession(true);	
			//登录成功，将user封装
			UserDao ud=new UserDao();
			User user=ud.getInfo(uid);
			//session.setAttribute("uid", uid);
			
			session.setAttribute("user", user);//将user保存在session里
			session.setMaxInactiveInterval(1800);
			//如果登录成功，顺便将我的话题封装，以便在主页显示
			//session.setAttribute("myTopic", myTopic);//我的话题用request传值
			str="登录成功";
		} else {
			str="登录失败,请检查账号和密码重新登录！";
		}
		response.getWriter().write(str);
	}

}
