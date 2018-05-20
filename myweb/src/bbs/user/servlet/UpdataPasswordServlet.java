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
 * Servlet implementation class UpadataPasswordServlet
 */
//@WebServlet("/UpadataPasswordServlet")
public class UpdataPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataPasswordServlet() {
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
		response.setContentType("text/html;charset=GBK");
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		String oldpassword=request.getParameter("oldpassword");	
		String newpassword=request.getParameter("newpassword");
		
		User u=(User)session.getAttribute("user");
		if(u!=null){
			String password=u.getPassword();
			String str="111";
			if(password.equals(oldpassword)){
				u.setPassword(newpassword);
				UserDao dao=new UserDao();
				if(dao.updateInfo(u)){
					str="修改成功";
					
				}else{
					str="修改失败";
				}
			}else{
				str="原密码输入错误";
			}
			response.getWriter().write(str);
		}else{
			String str="您未登录，请先登录！";
			response.getWriter().write(str);
		}
	}

}
