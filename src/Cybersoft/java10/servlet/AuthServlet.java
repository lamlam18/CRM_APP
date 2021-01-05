package Cybersoft.java10.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Cybersoft.java10.util.Path;
import Cybersoft.java10.util.Url;

@WebServlet (name = "authServlet" , urlPatterns = "/login")
public class AuthServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher(Url.LOGIN).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if ("admin".equalsIgnoreCase(password)) {
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(3600);
			session.setAttribute("username", username);
			
			resp.sendRedirect(req.getContextPath() + Path.HOME);
		}else {
			resp.sendRedirect(req.getContextPath() + Path.LOGIN);
		}
		
	}

}
