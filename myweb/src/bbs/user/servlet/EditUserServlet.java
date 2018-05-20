package bbs.user.servlet;

import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.dao.UserDao;
import bbs.javabean.User;

/**
 * Servlet implementation class UpdateServlet
 */
//@WebServlet("/UpdateServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
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
		response.setContentType("text/html;charset=GBK");
		request.setCharacterEncoding("utf-8");
		//PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String uname=request.getParameter("uname");
		
		//String password=request.getParameter("password");
		int sex=Integer.parseInt(request.getParameter("sex"));
		String email=request.getParameter("email");
		int imgid=Integer.parseInt(request.getParameter("imgid"));
		
		User u=(User)session.getAttribute("user");
		String str="";
		if(u!=null){
			u.setUname(uname);
			//u.setPassword(password);
			u.setSex(sex);
			u.setImgid(imgid);
			u.setEmail(email);
			
			UserDao dao=new UserDao();
			if(dao.updateInfo(u)){
				str="修改成功";
				
			}else{
				str="修改失败";
			}
		}else{
			str="您未登录，请先登录！";
			
		}
		response.getWriter().write(str);
	}

}
