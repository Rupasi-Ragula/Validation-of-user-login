package com.validation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("rrupasi@teksystems.com") && password.equals("01121999")) {
			RequestDispatcher rd = request.getRequestDispatcher("Dashboard");
			rd.forward(request, response);
		}
		else if(username.equals("") || password.equals(""))
			{
			out.println("<h2>Sorry UserName or Password Error!</h2>");
			out.println("<h4>Username or password is empty...Try again<br/><br/></br></h4>");
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);
			
			}
		else {
			out.println("<h2>Sorry UserName or Password Error!</h2>");
			out.println("<h4>Enter valid username and password<br/><br/></br></h4>");
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
		out.close();
		
		
	}

}
