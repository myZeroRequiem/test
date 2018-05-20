package bbs.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SetCharacterEncodingFilter
 */
//@WebFilter("/SetCharacterEncodingFilter")
public class SetCharacterEncodingFilter implements Filter {
	 protected String encoding = null;
    /**
     * Default constructor. 
     */
    public SetCharacterEncodingFilter() {
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
	
		/*HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String request_uri = req.getRequestURI();
		
		////如果发现是css或者js文件，直接放行	
		if(request_uri.contains(".css") || request_uri.contains(".js") || request_uri.contains(".png")|| request_uri.contains(".jpg")||request_uri.contains(".gif")){
            
               chain.doFilter(request, response);
            }*/
		String encoding = this.encoding;
	       if (encoding != null)
	    	   request.setCharacterEncoding(encoding);
	       //执行下一个过滤器
	       chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.encoding = fConfig.getInitParameter("encoding");
	}

}
