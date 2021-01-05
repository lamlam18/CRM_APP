package Cybersoft.java10.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "firstFilter" , urlPatterns = "/*")
public class FirstFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//nhung dong lenh duoc chay khi nhan request
		req.setCharacterEncoding("UTF-8");
		System.out.println("da set encoding cho request ---> done");
		
		chain.doFilter(req, response);
		// nhung dong lenh duocj chay khi tra ve response
		resp.setCharacterEncoding("UTF-8");
		System.out.println("da set encoding cho request ---> done");
		
	}
	
	

}
