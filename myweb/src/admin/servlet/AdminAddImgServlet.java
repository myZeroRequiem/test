package admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.dao.ImgDao;
import bbs.javabean.Img;


/**
 * Servlet implementation class AdminAddImgServlet
 */
//@WebServlet("/AdminAddImgServlet")
public class AdminAddImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int imgid=Integer.parseInt(request.getParameter("imgid"));
		String img=request.getParameter("img");
		ImgDao imgdao=new ImgDao();
		Img Img=new Img();
		Img.setImgid(imgid);
		Img.setImg(img);
		String str="";
		if(imgdao.addImg(Img)){
			str="添加成功";
		}else{
			str="添加失败";
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
