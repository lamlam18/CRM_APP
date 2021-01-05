package Cybersoft.java10.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "homeServlet", urlPatterns = {
		"/home",
		"/home/home"
})
public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//sent cookie to browser
		
		// tao mot cookie
		Cookie cookie = new Cookie("username", "lamthu"); 
		cookie.setMaxAge(10);
		// them cookie vo trong response de tra ve cho browser
		resp.addCookie(cookie); // add cookie
		resp.addCookie(new Cookie("passwork","ahihi"));
		
		//luu thong tin tu session
		HttpSession session = req.getSession();
		
		Object user = session.getAttribute("user");
		
		
		if (user == null) {
			session.setAttribute("user","admin");
			session.setMaxInactiveInterval(10);
			System.out.println("da set session");
		}
		else {
			System.out.println("user: " + user.toString());
		}
		req.getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(req, resp);
		
	}	
	

}
