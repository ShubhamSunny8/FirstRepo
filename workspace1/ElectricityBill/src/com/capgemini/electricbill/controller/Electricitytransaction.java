package com.capgemini.electricbill.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;










import com.capgemini.electricbill.bean.Customer;
import com.capgemini.electricbill.dao.ElectricityDao;
import com.capgemini.electricbill.dao.ElectricityDaoImp;
import com.capgemini.electricbill.exception.Electricbillexception;

/**
 * Servlet implementation class Electricitytransaction
 */
@WebServlet("*.obj")
public class Electricitytransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Electricitytransaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String target="";
		String listall = "list.jsp";
		String search = "search.jsp";
		String targetError = "error.jsp";
		String targetHome = "index.jsp";
		ElectricityDao Service =new ElectricityDaoImp();
		HttpSession session=request.getSession(true);
		String path = request.getServletPath().trim();
		System.out.println(path);
		switch (path) {
		case "/Home.obj":
			session.setAttribute("error", null);
			session.setAttribute("donor", null);
			target = targetHome;
			break;
			
		case "/search.obj":
			int num=Integer.parseInt(request.getParameter("number"));
			 Customer custList1=new Customer();
			 try {
				 System.out.println("hello here1");
				custList1=Service.getCustomerbyId(num);
				System.out.println("hello herre2");
				System.out.println(custList1.getName()+" "+" "+custList1.getNumber()+" "+" "+custList1.getAddress());
				ArrayList a=new ArrayList();
				a.add(custList1);
				session.setAttribute("a", a);
				target = search;
			} catch (Electricbillexception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					 
			 break;

			// Redirect to Add donor Page

		case "/list.obj":
			try {
				ArrayList<Customer> custList=Service.viewList();
				session.setAttribute("custList", custList);
			} catch (Electricbillexception | SQLException | NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			target = listall;
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(target);
		
		dispatcher.forward(request, response);	
	}
	

}
