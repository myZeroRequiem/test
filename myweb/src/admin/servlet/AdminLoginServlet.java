package admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.dao.AdminDao;
import bbs.javabean.Admin;


/**
 * Servlet implementation class AdminLoginServlet
 */
//@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();	
		String admin = request.getParameter("admin");
		String password = request.getParameter("password");				
		Admin a=new Admin();
		a.setAdmin(admin);
		a.setPassword(password);
		AdminDao ad=new AdminDao();
		
		if (ad.login(a)) {
			HttpSession session = request.getSession(true);			
			
			session.setAttribute("admin", admin);
			RequestDispatcher dis=request.getRequestDispatcher("admin/index.jsp");
			dis.forward(request, response);
		} else {
			out.println("登录失败，请重新登录");
			response.setHeader("refresh", "2;admin.jsp");
		}
		
	}

}
