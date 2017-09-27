package com.capgemini.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.dto.RechargeDAO;
import com.capgemini.exception.MobileException;
import com.capgemini.service.IRechargeServiceImp;


/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/firstservlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
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
		IRechargeServiceImp Service =new IRechargeServiceImp();
		//RechargeDAO ob = new RechargeDAO();
		String target = "";
		HttpSession session=request.getSession(true);
		//System.out.println("hello");
		
		ArrayList<RechargeDAO> RechargeList = new ArrayList<>();
		
					try {
						RechargeList = Service.viewList();
					} catch (MobileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("view list accessed"+RechargeList);
					target = "Sucess.jsp";
				
			session.setAttribute("RechargeList", RechargeList);
		//System.out.println("atribute setted");
	RequestDispatcher dispatcher = request.getRequestDispatcher(target);
	//System.out.println("request dispatcher doene"+dispatcher);
	dispatcher.forward(request, response);
	//System.out.println(request+"  "+response);
	}
}
