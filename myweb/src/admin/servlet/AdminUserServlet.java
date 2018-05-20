package admin.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.dao.UserDao;
import bbs.javabean.User;

/**
 * Servlet implementation class AdminUserServlet
 */
//@WebServlet("/AdminUserServlet")
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserServlet() {
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
		String uid = request.getParameter("uid");
		UserDao ud=new UserDao();
		ArrayList<User> user=new ArrayList<User>();
		User u=new User();
		if(uid==null||uid==""){
			user=ud.AllUser();
		}else{
			if(ud.uidIsUsed(uid)){
				UserDao ud2=new UserDao();
				u=ud2.getInfo(uid);
				user.add(u);
			}
			
		}
		request.setAttribute("user", user);
		//request.setAttribute("uid", uid);
		RequestDispatcher dis=request.getRequestDispatcher("admin/user.jsp");
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
