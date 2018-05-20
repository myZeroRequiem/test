package admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import bbs.dao.UserDao;
import bbs.javabean.User;

/**
 * Servlet implementation class AdminEditUserServlet
 */
//@WebServlet("/AdminEditUserServlet")
public class AdminEditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditUserServlet() {
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
		String uid=request.getParameter("uid");
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		//String password=request.getParameter("password");
		int sex=Integer.parseInt(request.getParameter("sex"));
		String email=request.getParameter("email");
		int imgid=Integer.parseInt(request.getParameter("imgid"));
		int level=Integer.parseInt(request.getParameter("level"));
		User u=new User();
		u.setUid(uid);
		u.setUname(uname);
		u.setPassword(password);
		u.setSex(sex);
		u.setImgid(imgid);
		u.setEmail(email);
		u.setLevel(level);	
		UserDao dao=new UserDao();
		String str="";
		if(dao.updateInfo(u)){
			str="修改成功";
			
		}else{
			str="修改失败";
		}
		response.getWriter().write(str);
	}

}
