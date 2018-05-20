package admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.dao.FansDao;
import bbs.dao.ReplyDao;
import bbs.dao.TopicDao;
import bbs.dao.UserDao;
//import bbs.javabean.User;

/**
 * Servlet implementation class AdminDeleteUserServlet
 */
//@WebServlet("/AdminDeleteUserServlet")
public class AdminDeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=GBK");
		request.setCharacterEncoding("utf-8");
		//PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		
		UserDao ud=new UserDao();
		FansDao fd=new FansDao();
		ReplyDao rd=new ReplyDao();
		TopicDao td=new TopicDao();
		String str="删除失败";
		if(rd.deleteUser(uid)){
			if(td.deleteUser(uid))
				if(fd.deleteUser(uid))
					if(ud.deleteUser(uid))
						str="删除成功";			
		}
		response.getWriter().write(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
