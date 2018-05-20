package bbs.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.dao.FansDao;
import bbs.javabean.User;

/**
 * Servlet implementation class AddFansServlet
 */
//@WebServlet("/AddFansServlet")
public class AddFansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFansServlet() {
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
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null){
			String uid=user.getUid();
			String followsid=request.getParameter("followsid");
			
			FansDao fd=new FansDao();
			String str="关注失败";
			if(fd.addFans(uid, followsid)){
				str="关注成功！";
			}
			response.getWriter().write(str);
		}else{
			String str="您未登录，请先登录！";
			response.getWriter().write(str);
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
