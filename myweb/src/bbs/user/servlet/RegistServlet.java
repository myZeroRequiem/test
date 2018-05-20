package bbs.user.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import bbs.javabean.User;
import bbs.dao.UserDao;

/**
 * Servlet implementation class RegistServlet
 */

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//PrintWriter out = response.getWriter();
		String uid=request.getParameter("uid");
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		int sex=Integer.parseInt(request.getParameter("sex"));
		String email=request.getParameter("email");
		User u=new User();
		u.setUid(uid);
		u.setUname(uname);
		u.setPassword(password);
		u.setSex(sex);
		u.setEmail(email);
		UserDao dao=new UserDao();
		//out.println("--------w------");
		String str="";
		if(dao.adduser(u)){
			str="注册成功";
		}
		else{
			str="注册失败";
		}
		response.getWriter().write(str);
	}

}
