package com.ss;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet011
 */
@WebServlet("/Servlet011")
public class Servlet011 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet011() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s=request.getParameter("number");
		//String password=request.getParameter("password");
		String target=null;
		ServletContext sc=getServletContext();
		/*if(("admin").equals(username)&&("admin").equals(password));
		{
		target="Profile";
		request.setAttribute("sKey", "loggedin.."+username);
		}
		
		{
			target="error";
			request.setAttribute("eKey1","you tried using name as");
			request.setAttribute("eKey2","wrong name and Password");
		}*/
		
		int num=Integer.parseInt(s);
		if(num%2==0)
		{
			target="Even";
		}
		else
		{
			target="Odd";
		}
		/*response.setStatus(response.SC_PROXY_AUTHENTICATION_REQUIRED);
		response.sendRedirect(target);
		*/
		RequestDispatcher rd=sc.getRequestDispatcher("/"+target);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
