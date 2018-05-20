package bbs.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	
	private String userIndex="userIndex.jsp";
	private String editUser="editUser.jsp";
	
	private String userIndex_servlet="userIndex";
	private String addFans_servlet="addFans";
	private String deleteFans_servlet="deleteFans";
	private String publishTopic_servlet="publishTopic";
	private String editUser_servlet="editUser";
	private String logout_servlet="logout";
	private String deleteTopic_servlet="deleteTopic";	
	private String reply_servlet="reply";
	private String updataPassword_servlet="updataPassword";
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.setContentType("text/html;");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		// 得到用户请求的URI
		String request_uri = req.getRequestURI();
		// 得到web应用程序的上下文路径
		String ctxPath = req.getContextPath();
		// 去除上下文路径，得到剩余部分的路径
		String uri = request_uri.substring(ctxPath.length());
		////如果发现是css或者js文件，直接放行	
		if(request_uri.contains(".css") || request_uri.contains(".js") || request_uri.contains(".png")|| request_uri.contains(".jpg")||request_uri.contains(".gif")){
            
               chain.doFilter(request, response);
        }else{
			// 判断用户访问的是否是需要登录的页面
			if (uri.equals(userIndex)||uri.equals(userIndex_servlet)
					||uri.equals(addFans_servlet)||uri.equals(deleteFans_servlet)
					||uri.equals(publishTopic_servlet)||uri.equals(editUser_servlet)
					||uri.equals(logout_servlet)||uri.equals(deleteTopic_servlet)
					||uri.equals(editUser)||uri.equals(reply_servlet)
					||uri.equals(updataPassword_servlet)) {
				
				// 如果访问的是需要登录的页面，则判断用户是否已经登录
				if (null != session.getAttribute("user")
						&& "" != session.getAttribute("user")) {
					chain.doFilter(request, response);
				} else {			
					String path= ctxPath + "/jsp/login.jsp";
					out.println("您没有登录，请先<a href="+path+" target=_top>登录</a>！");
					return;				
				}		
			} else {
				chain.doFilter(request, response);
				
			}
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		//regist_servlet = config.getInitParameter(PUBLISHTOPIC_SERVLET);
	}

}
